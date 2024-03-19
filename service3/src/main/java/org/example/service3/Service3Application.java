package org.example.service3;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.service3.client.ExampleClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlz
 * @since 2024/03/11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
@RequestMapping("service3")
@Slf4j
@AllArgsConstructor
public class Service3Application {
    private final ExampleClient exampleClient;

    public static void main(String[] args) {
        SpringApplication.run(Service3Application.class, args);
    }

    @GetMapping
    public Object test() {
        log.info("service3");
        final HttpResponse response = HttpUtil.createPost("localhost:8001/service1").execute();
        response.close();
        return JSONUtil.createObj()
                .set("status", response.body());
    }
}
