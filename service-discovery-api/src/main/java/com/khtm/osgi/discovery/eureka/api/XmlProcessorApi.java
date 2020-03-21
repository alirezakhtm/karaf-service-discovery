/*
 * Copyright (c)
 * Designed and developed by Alireza Khatami Doost.
 * email: alireza.khtm@gmail.com
 * linkedIn: https://www.linkedin.com/in/alireza-khatami-doost-63b41177/
 */

package com.khtm.osgi.discovery.eureka.api;

import com.khtm.osgi.discovery.eureka.model.Application;
import com.khtm.osgi.discovery.eureka.model.Instance;
import com.khtm.osgi.discovery.eureka.model.Root;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface XmlProcessorApi {

    Root analysisGetAllServiceInfo(String response) throws JAXBException, ParserConfigurationException, IOException, SAXException;
    Application analysisGetApplicationInfo(String response) throws JAXBException;
    List<Instance> analysisAllSessionsOfService(String response) throws JAXBException;

}
