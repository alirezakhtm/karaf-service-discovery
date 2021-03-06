/*
 * Copyright (c)
 * Designed and developed by Alireza Khatami Doost.
 * email: alireza.khtm@gmail.com
 * linkedIn: https://www.linkedin.com/in/alireza-khatami-doost-63b41177/
 */

package com.khtm.osgi.discovery.eureka.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Port {

    private String value;
    private boolean enabled;

    @XmlValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlAttribute(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enable) {
        this.enabled = enable;
    }
}
