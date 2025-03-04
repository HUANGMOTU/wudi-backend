package com.yupi.usercenter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
public class CookieConfig {
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        // null不能带引号 跨域sessionid不一致关键
        serializer.setSameSite(null);
        serializer.setDomainName("wudi-nav.xyz"); // 设置 Cookie 域名
        return serializer;
    }
}