package com.star.web.controller.system;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "商品信息管理接口")
@RestController
public class testController {

    @Operation(summary = "单个商品详情")
    @RequestMapping("/test")
    public String test(){
        return "hello";
    }
}
