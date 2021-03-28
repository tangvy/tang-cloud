package com.tangv.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/7/11 1:28 下午
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka7001 {

    public static void main(String[] args) {
        //System.out.println(ccc);
        SpringApplication.run(Eureka7001.class,args);
    }

}
