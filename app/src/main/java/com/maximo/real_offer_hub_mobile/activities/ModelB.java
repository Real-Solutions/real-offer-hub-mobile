package com.maximo.real_offer_hub_mobile.activities;


public class ModelB {
    private String property;
    private String earnestMoney;
    private String loanType;
    private String buyersAgent;
    private String responseDate;
    private String responseTime;
    private String closeOfEscrow;
    private boolean expanded;


    public ModelB(String property, String earnestMoney, String loanType, String buyersAgent, String responseDate, String responseTime, String closeOfEscrow) {
        this.property = property;
        this.earnestMoney = earnestMoney;
        this.loanType = loanType;
        this.buyersAgent = buyersAgent;
        this.responseDate = responseDate;
        this.responseTime = responseTime;
        this.closeOfEscrow = closeOfEscrow;
        this.expanded = false;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getEarnestMoney() {
        return earnestMoney;
    }

    public void setEarnestMoney(String earnestMoney) {
        this.earnestMoney = earnestMoney;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getBuyersAgent() {
        return buyersAgent;
    }

    public void setBuyersAgent(String buyersAgent) {
        this.buyersAgent = buyersAgent;
    }

    public String getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getCloseOfEscrow() {
        return closeOfEscrow;
    }

    public void setCloseOfEscrow(String closeOfEscrow) {
        this.closeOfEscrow = closeOfEscrow;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    @Override
    public String toString() {
        return "ModelB{" +
                "property='" + property + '\'' +
                ", earnestMoney='" + earnestMoney + '\'' +
                ", loanType='" + loanType + '\'' +
                ", buyersAgent='" + buyersAgent + '\'' +
                ", responseDate='" + responseDate + '\'' +
                ", responseTime='" + responseTime + '\'' +
                ", closeOfEscrow='" + closeOfEscrow + '\'' +
                '}';
    }
}
