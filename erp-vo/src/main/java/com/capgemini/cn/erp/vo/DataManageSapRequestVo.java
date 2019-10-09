package com.capgemini.cn.erp.vo;

import java.io.Serializable;
import java.util.List;

public class DataManageSapRequestVo implements Serializable {
	private static final long serialVersionUID = 1L;
    private String Msgty;
    private String Belnr;
    private String Gjahr;
    private String Bldat;
    private String Blart;
    private String Bukrs;
    private String Budat;
    private String Waers;
    private String Bktxt;
    private List<SapRequestVoItem> Head2Item;

    public String getMsgty() {
        return Msgty;
    }

    public void setMsgty(String msgty) {
        Msgty = msgty;
    }

    public String getBelnr() {
        return Belnr;
    }

    public void setBelnr(String belnr) {
        Belnr = belnr;
    }

    public String getGjahr() {
        return Gjahr;
    }

    public void setGjahr(String gjahr) {
        Gjahr = gjahr;
    }

    public String getBldat() {
        return Bldat;
    }

    public void setBldat(String bldat) {
        Bldat = bldat;
    }

    public String getBlart() {
        return Blart;
    }

    public void setBlart(String blart) {
        Blart = blart;
    }

    public String getBukrs() {
        return Bukrs;
    }

    public void setBukrs(String bukrs) {
        Bukrs = bukrs;
    }

    public String getBudat() {
        return Budat;
    }

    public void setBudat(String budat) {
        Budat = budat;
    }

    public String getWaers() {
        return Waers;
    }

    public void setWaers(String waers) {
        Waers = waers;
    }

    public String getBktxt() {
        return Bktxt;
    }

    public void setBktxt(String bktxt) {
        Bktxt = bktxt;
    }

    public List<SapRequestVoItem> getHead2Item() {
        return Head2Item;
    }

    public void setHead2Item(List<SapRequestVoItem> head2Item) {
        Head2Item = head2Item;
    }
}
