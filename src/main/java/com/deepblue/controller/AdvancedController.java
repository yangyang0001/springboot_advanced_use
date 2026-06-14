package com.deepblue.controller;

import com.deepblue.entity.MineResponse;
import com.deepblue.service.AdvancedService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/advanced-control")
@RestController
public class AdvancedController {

    @Resource
    private AdvancedService advancedService;

    @RequestMapping("/advanced")
    public MineResponse advanced() {
        return advancedService.doAdvanced();
    }
}
