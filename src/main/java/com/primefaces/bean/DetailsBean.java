package com.primefaces.bean;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ScopedProxyMode;

@ManagedBean
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DetailsBean {
    
    private String pmr;
    private String title;
    private int year;
    public DetailsBean(String pmr, String title, int year2) {
        this.pmr = pmr;
        this.title = title;
        this.year = year2;
    }
    public String getPmr() {
        return pmr;
    }
    public void setPmr(String pmr) {
        this.pmr = pmr;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

}
