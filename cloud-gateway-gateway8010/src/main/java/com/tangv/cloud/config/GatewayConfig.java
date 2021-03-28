package com.tangv.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

/**
 * author:   tangwei
 * Date:     2021/3/28 15:41
 * Description: 网关配置文件
 */
@Configuration
public class GatewayConfig {

    /**
     * 组装一个路由配置，将http://news.baidu.com/finance的路由设置为网关服务的/finance
     * id:标记这个路由的唯一标识
     */
    @Bean
    public RouteLocator financeRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_finance", r -> r.path("/finance")
                .uri("http://news.baidu.com/finance"));
        return routes.build();
    }

    @Bean
    public RouteLocator guoneiRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_news_guonei",r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei"));
        return routes.build();
    }
}