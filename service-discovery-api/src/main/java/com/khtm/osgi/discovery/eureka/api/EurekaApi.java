/*
 * Copyright (c)
 * Designed and developed by Alireza Khatami Doost.
 * email: alireza.khtm@gmail.com
 * linkedIn: https://www.linkedin.com/in/alireza-khatami-doost-63b41177/
 */

package com.khtm.osgi.discovery.eureka.api;

import com.khtm.osgi.discovery.eureka.model.HttpResponse;
import com.khtm.osgi.discovery.eureka.model.Instance;
import com.khtm.osgi.discovery.eureka.model.Root;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface EurekaApi {

    static String STATUS_UP = "UP";
    static String STATUS_DOWN = "DOWN";

    void init(String eurekaUrl, int eurekaPortNum, String ipv4);

    HttpResponse registerServiceInEurekaService(
            String applicationName,
            int portNumber,
            String healthCheckUrl,
            String statusPageUrl,
            String homePageUrl
    ) throws IOException, JAXBException, ParserConfigurationException, SAXException;

    HttpResponse unregisterServiceFromEurekaService(String applicationName, String instanceId) throws IOException;

    boolean changeStatus(String instanceId, String applicationName, String status) throws IOException;

    List<Instance> getServiceInfo(String applicationName) throws IOException, JAXBException;

    Root getAllServicesInfo() throws IOException, JAXBException, ParserConfigurationException, SAXException;

    void unregisterThisService() throws IOException;

}
