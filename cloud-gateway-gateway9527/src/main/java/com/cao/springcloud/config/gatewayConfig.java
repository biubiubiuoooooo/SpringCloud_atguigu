package com.cao.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class gatewayConfig {

    @Bean
    public RouteLocator createWayConfig(RouteLocatorBuilder routeLocator){
        RouteLocatorBuilder.Builder routes = routeLocator.routes();
      return routes.route("pament_config_guonei",r->r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
    }


}
