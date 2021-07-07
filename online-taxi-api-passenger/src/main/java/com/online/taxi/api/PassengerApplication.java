
package com.online.taxi.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.online.taxi"})
public class PassengerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PassengerApplication.class, args);
    }
}
