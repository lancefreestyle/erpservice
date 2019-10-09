package com.capgemini.cn.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfigProperties {

    /**
     * 开源协议版本名称
     */
    private static final String DEFAULT_LICENSE = "Apache License Version 2.0";

    /**
     * 开源协议说明网址
     */
    private static final String DEFAULT_LICENSE_URL = "https://github.com/springfox/springfox/blob/master/LICENSE";

    /**
     * 是否启用
     */
    @Value(value = "${swagger-api.enabled:false}")
    private boolean enabled;

    /**
     * 接口文档地址上下文路径
     */
    @Value(value = "${swagger-api.pathMapping:/}")
    private String pathMapping;

    /**
     * 标题
     */
    @Value(value = "${swagger-api.title:}")
    private String title;

    /**
     * 描述
     */
    @Value(value = "${swagger-api.description:}")
    private String description;

    /**
     * 联系人姓名
     */
    @Value(value = "${swagger-api.contactName:}")
    private String contactName;

    /**
     * 联系人网址
     */
    @Value(value = "${swagger-api.contactUrl:}")
    private String contactUrl;

    /**
     * 联系人电子邮箱地址
     */
    @Value(value = "${swagger-api.contactEmail:}")
    private String contactEmail;

    /**
     * 开源协议版本名称
     */
    @Value(value = "${swagger-api.license:Apache License Version 2.0}")
    private String license;

    /**
     * 开源协议说明网址
     */
    @Value(value = "${swagger-api.licenseUrl:https://github.com/springfox/springfox/blob/master/LICENSE}")
    private String licenseUrl;

    /**
     * 接口文档版本号
     */
    @Value(value = "${swagger-api.version:}")
    private String version;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPathMapping() {
        return pathMapping;
    }

    public void setPathMapping(String pathMapping) {
        this.pathMapping = pathMapping;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


}
