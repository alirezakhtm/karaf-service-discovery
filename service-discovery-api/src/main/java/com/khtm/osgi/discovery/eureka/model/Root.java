/*
 * Copyright (c)
 * Designed and developed by Alireza Khatami Doost.
 * email: alireza.khtm@gmail.com
 * linkedIn: https://www.linkedin.com/in/alireza-khatami-doost-63b41177/
 */

package com.khtm.osgi.discovery.eureka.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "applications")
public class Root {

    private String versions__delta;
    private String apps__hashcode;
    private List<Application> applications;

    @XmlElement(name = "versions__delta")
    public String getVersions__delta() {
        return versions__delta;
    }

    public void setVersions__delta(String versions__delta) {
        this.versions__delta = versions__delta;
    }

    @XmlElement(name = "apps__hashcode")
    public String getApps__hashcode() {
        return apps__hashcode;
    }

    public void setApps__hashcode(String apps__hashcode) {
        this.apps__hashcode = apps__hashcode;
    }

    @XmlElement(name = "application")
    public List<Application> getApplications() {
        return applications;
    }

    public void setApplication(List<Application> applications) {
        this.applications = applications;
    }
}
