package com.deepblue.service.impl;

import com.deepblue.annotation.FilteAdvanced;
import com.deepblue.entity.MineResponse;
import com.deepblue.service.AdvancedService;
import org.springframework.stereotype.Service;

@Service
public class AdvancedServiceImpl implements AdvancedService {

    @Override
    @FilteAdvanced
    public MineResponse doAdvanced() {
        MineResponse response = new MineResponse();
        response.setId("1");
        response.setUsername("yangjianwei");
        response.setPassword("19900106");
        return response;
    }

}
