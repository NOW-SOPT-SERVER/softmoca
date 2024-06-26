package org.spot.pratice.controller;

import org.spot.pratice.controller.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "1차 세미나 테스트 API 입니다!";
    }

    @GetMapping("/test/json")
    public ApiResponse testJson() {
        return ApiResponse.create("1차 세미나 테스트 API - JSON  application ignore test commit");
    }

}
