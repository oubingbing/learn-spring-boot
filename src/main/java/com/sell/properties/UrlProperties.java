package com.sell.properties;import lombok.Data;import org.springframework.boot.context.properties.ConfigurationProperties;import org.springframework.stereotype.Component;@Data@Component@ConfigurationProperties(prefix = "url")public class UrlProperties {    private String wechatUrl;    private String qiniuUrl;}