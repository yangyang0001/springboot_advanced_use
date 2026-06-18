package com.deepblue.dependsOn;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component("mineB")
public class MineB {

    // Spring 无法感知这个静态状态 —— 这正是需要 @DependsOn 的原因
    private static volatile boolean initialized = false;
    private static volatile String sharedData;

    @PostConstruct
    public void init() {
        sharedData = "MineB 提供的关键数据[time = " + DateUtil.format(new Date(), DateUtil.format(new Date(), DatePattern.NORM_DATETIME_PATTERN)) + "]";
        initialized = true;
        log.info(">>> MineB @PostConstruct 完成: {}", sharedData);
    }

    public static boolean isInitialized() {
        return initialized;
    }

    public static String getSharedData() {
        return sharedData;
    }
}
