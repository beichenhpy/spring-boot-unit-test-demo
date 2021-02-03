package cn.beichenhpy.unittestdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author beichenhpy
 * @version 1.0
 * @description TODO 解决方法1：mockResponse charset问题，将默认的替换为utf8 解决中文乱码问题
 * @since 2021/2/3 11:28
 */
@Configuration
public class McvConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.stream()
                .filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
                .findFirst()
                .ifPresent(converter -> ((MappingJackson2HttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8));
    }
}
