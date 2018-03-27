package com.primefaces.web.bean;

public class User {
    
    private String parmaID;
    
    private String tradingPartner;
    
    private String vatException;
    
    private String taxException;
    
    private String companyType;
    
    private String diversityCode;

    public String getParmaID() {
        return parmaID;
    }

    public void setParmaID(String parmaID) {
        this.parmaID = parmaID;
    }

    public String getTradingPartner() {
        return tradingPartner;
    }

    public void setTradingPartner(String tradingPartner) {
        this.tradingPartner = tradingPartner;
    }

    public String getVatException() {
        return vatException;
    }

    public void setVatException(String vatException) {
        this.vatException = vatException;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getDiversityCode() {
        return diversityCode;
    }

    public void setDiversityCode(String diversityCode) {
        this.diversityCode = diversityCode;
    }

    public String getTaxException() {
        return taxException;
    }

    public void setTaxException(String taxException) {
        this.taxException = taxException;
    }
}
