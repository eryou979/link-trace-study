package org.example.service3.client;

import cn.hutool.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author dlz
 * @since 2024/03/04
 */
@FeignClient(name = "service1")
public interface ExampleClient {
    @PostMapping("/service1")
    JSONObject getService();

}
































