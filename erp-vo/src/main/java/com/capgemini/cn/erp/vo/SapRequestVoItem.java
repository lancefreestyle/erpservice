package com.capgemini.cn.erp.vo;

import java.io.Serializable;

public class SapRequestVoItem implements Serializable {
	private static final long serialVersionUID = 1L;
    private String Shkzg;
    private String Hkont;
    private String Lifnr;
    private String Kunnr;
    private String Saknr;
    private String Wrbtr;
    private String Sgtxt;
    private String Kostl;
    private String Prctr;
    private String Gsber;

    public String getShkzg() {
        return Shkzg;
    }

    public void setShkzg(String shkzg) {
        Shkzg = shkzg;
    }

    public String getHkont() {
        return Hkont;
    }

    public void setHkont(String hkont) {
        Hkont = hkont;
    }

    public String getLifnr() {
        return Lifnr;
    }

    public void setLifnr(String lifnr) {
        Lifnr = lifnr;
    }

    public String getKunnr() {
        return Kunnr;
    }

    public void setKunnr(String kunnr) {
        Kunnr = kunnr;
    }

    public String getSaknr() {
        return Saknr;
    }

    public void setSaknr(String saknr) {
        Saknr = saknr;
    }

    public String getWrbtr() {
        return Wrbtr;
    }

    public void setWrbtr(String wrbtr) {
        Wrbtr = wrbtr;
    }

    public String getSgtxt() {
        return Sgtxt;
    }

    public void setSgtxt(String sgtxt) {
        Sgtxt = sgtxt;
    }

    public String getKostl() {
        return Kostl;
    }

    public void setKostl(String kostl) {
        Kostl = kostl;
    }

    public String getPrctr() {
        return Prctr;
    }

    public void setPrctr(String prctr) {
        Prctr = prctr;
    }

    public String getGsber() {
        return Gsber;
    }

    public void setGsber(String gsber) {
        Gsber = gsber;
    }
}
