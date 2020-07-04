package com.kangping.redission;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * 功能：
 * </p>
 *
 * @author kangping
 * Copyright Inc. All rights reserved
 * @version v1.0
 * @ClassName: RedissionProperties
 * @date 2020/7/4
 */
@ConfigurationProperties(prefix = "kangping.redission")
public class RedissionProperties {

    /**
     * ip
     */
    private String host = "localhost";

    /**
     * 端口
     */
    private Integer port;

    /**
     * 超时时间
     */
    private Integer connectTimeout;

    /**
     * 是否加密
     */
    private Boolean ssl;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Boolean getSsl() {
        return ssl;
    }

    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
    }
}
