package org.example.service2;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.service2.client.ExampleClient;
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
@RequestMapping("service2")
@Slf4j
@AllArgsConstructor
public class Service2Application {
    private final ExampleClient exampleClient;

    public static void main(String[] args) {
        SpringApplication.run(Service2Application.class, args);
    }

    @GetMapping
    public Object test() {
        log.info("service2");
        final JSONObject result = exampleClient.getService();
        return JSONUtil.createObj()
                .set("status", result);
    }
}
