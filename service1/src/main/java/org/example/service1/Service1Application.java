package org.example.service1;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.service1.client.ExampleClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("service1")
@Slf4j
@AllArgsConstructor
public class Service1Application {
    private final ExampleClient exampleClient;

    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }

    @GetMapping
    public Object test() {
        log.info("service1");
        final JSONObject result = exampleClient.getService();
        return JSONUtil.createObj()
                .set("status", result);
    }

    @PostMapping
    public Object test2() {
        return JSONUtil.createObj()
                .set("status", "ok");
    }

}
