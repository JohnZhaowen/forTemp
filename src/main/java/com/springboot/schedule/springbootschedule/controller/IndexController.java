package com.springboot.schedule.springbootschedule.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:
 */
@Controller
@RequestMapping("/mom")
@Slf4j
@Api(tags = "首页")
public class IndexController {

    @GetMapping(value = {"", "/index"})
    @ApiOperation("首页")
    public String index(){
        return "index";
    }

}
