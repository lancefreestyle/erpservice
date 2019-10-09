package com.capgemini.cn.erp.vo;

import java.io.Serializable;

public class DataManageSapResponseVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String sapCertificateCode;

    public String getSapCertificateCode() {
        return sapCertificateCode;
    }

    public void setSapCertificateCode(String sapCertificateCode) {
        this.sapCertificateCode = sapCertificateCode;
    }
}
