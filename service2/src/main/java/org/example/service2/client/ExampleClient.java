package org.example.service2.client;

import cn.hutool.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dlz
 * @since 2024/03/04
 */
@FeignClient(name = "service3")
public interface ExampleClient {
    @GetMapping("/service3")
    JSONObject getService();

}
