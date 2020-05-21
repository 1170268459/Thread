package com.xxc.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "SERVERONE")
public interface ServerClient {

    @PostMapping("/thread")
    String create(Integer s);


}
