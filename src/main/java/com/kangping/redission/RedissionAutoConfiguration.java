package com.kangping.redission;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>
 * 功能：
 * </p>
 *
 * @author kangping
 * Copyright Inc. All rights reserved
 * @version v1.0
 * @ClassName: RedissionAutoConfiguration
 * @date 2020/7/4
 */
@ConditionalOnClass(RedisClient.class)
@Configuration
@EnableConfigurationProperties(value = RedissionProperties.class)
public class RedissionAutoConfiguration {

    @Bean
    public RedissonClient redissonClient(RedissionProperties redissionProperties) {
        Config config = new Config();
        String prefix = "redis://";
        if (redissionProperties.getSsl()) {
            prefix = "rediss://";
        }
        config.useSingleServer().setAddress(prefix+redissionProperties.getHost()+":"+redissionProperties.getPort())
                .setConnectTimeout(redissionProperties.getConnectTimeout());
        return Redisson.create(config);
    }
}
