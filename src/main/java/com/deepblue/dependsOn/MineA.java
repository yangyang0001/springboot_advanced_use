package com.deepblue.dependsOn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Slf4j
@Component("mineA")
@DependsOn("mineB") // 去掉此注解，启动必报 BeanInitializationException
public class MineA {

    /**
     * MineA 没有通过 @Autowired 直接声明对 MineB 的依赖，
     * 而是依赖 MineB @PostConstruct 设置的静态数据。
     * Spring 无法自动推断这一隐式依赖，必须用 @DependsOn 手动声明。
     */
    @PostConstruct
    public void init() {
        log.info(">>> MineA @PostConstruct 开始...");

        if (!MineB.isInitialized()) {
            throw new BeanInitializationException(
                    "MineA 初始化失败！MineB 必须先完成初始化! 请在 MineA 类上添加 @DependsOn(\"mineB\")"
            );
        }

        String data = MineB.getSharedData();
        log.info(">>> MineA @PostConstruct 成功，获取到 MineB 的数据: {}", data);
    }
}
