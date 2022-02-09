package com.example.redis.config;
/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class CacheConfig {
    private static final Logger Log = LoggerFactory.getLogger(CacheConfig.class);

    @Component
    @Profile("local")
    @ConditionalOnProperty(name = "local.redis.port")
    public class EmbededRedis{

        @Value("${local.redis.port:6379}")
        private int redisPort;

        private RedisServer redisServer;

        @PostConstruct
        public void startRedis(){
            redisServer = RedisServer.builder().port(redisPort).setting("maxmemory 128M").build();
            if(!redisServer.isActive()){
                try{
                    redisServer.start();
                }catch (RuntimeException ex){
                    Log.info("Embedded Redis server is already running");
                }
            }
        }

        @PreDestroy
        public void stopRedis(){
            redisServer.stop();
        }

    }
}
 */


