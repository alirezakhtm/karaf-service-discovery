/*
 * Copyright (c)
 * Designed and developed by Alireza Khatami Doost.
 * email: alireza.khtm@gmail.com
 * linkedIn: https://www.linkedin.com/in/alireza-khatami-doost-63b41177/
 */

package com.khtm.osgi.discovery.eureka.client;

import com.khtm.osgi.discovery.eureka.api.EurekaApi;
import com.khtm.osgi.discovery.eureka.model.HttpResponse;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.cm.ConfigurationEvent;
import org.osgi.service.cm.ConfigurationListener;

import java.util.Dictionary;

public class EurekaClient implements BundleActivator {

    private ServiceRegistration<ConfigurationListener> registration;

    public void start(BundleContext bundleContext) throws Exception {
        this.registerService(bundleContext);
        this.setOnListener(bundleContext);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        registration.unregister();
    }

    private Dictionary<String, Object> getProperties(BundleContext bundleContext){
        Dictionary<String, Object> properties = null;
        ServiceReference<ConfigurationAdmin> reference = bundleContext.getServiceReference(ConfigurationAdmin.class);
        ConfigurationAdmin configurationAdmin = bundleContext.getService(reference);
        try {
            Configuration configuration = configurationAdmin.getConfiguration("eureka.config");
            properties = configuration.getProperties();
        } catch (Exception ex){
            System.err.println("[*] Eureka client: file \"eureka.config.cfg\" is not found.");
        } finally {
            return properties;
        }
    }

    private void registerService(BundleContext bundleContext){
        Dictionary<String, Object> properties = this.getProperties(bundleContext);
        if(properties == null){
            System.err.println("[*] Service can not be register on Eureka Server.");
            return;
        }
        EurekaApi eurekaApi = bundleContext.getService(bundleContext.getServiceReference(EurekaApi.class));
        eurekaApi.init(
                // eureka url
                properties.get("eureka.server.url").toString(),
                // eureka port number
                Integer.parseInt(properties.get("eureka.server.port").toString()),
                // ipv4
                properties.get("application.ip").toString()
        );
        try {
            HttpResponse httpResponse = eurekaApi.registerServiceInEurekaService(
                    // application name
                    properties.get("application.name").toString(),
                    // port number
                    Integer.parseInt(properties.get("application.port").toString()),
                    // health check url
                    properties.get("application.healthcheckurl").toString(),
                    // status page url
                    properties.get("application.statuspageurl").toString(),
                    // home page url
                    properties.get("application.homepageurl").toString()
            );
            if(httpResponse.getResponseCode() == 200){
                System.out.println("[*] Eureka service registering has been done.");
            }else {
                System.err.println("[*] Eureka service registering has been failed.");
            }
        } catch (Exception e) {
            System.err.println("[*] Service can not be register on Eureka Server.");
        }
    }

    private void setOnListener(BundleContext bundleContext){
        ConfigurationListener listener = event -> {
          if(event.getPid().equals("eureka.config")){
              this.registerService(bundleContext);
          }
        };
        registration = bundleContext.registerService(ConfigurationListener.class, listener, null);
    }
}
