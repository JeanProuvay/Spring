package com.example.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@EnableCaching
@Configuration
public class CacheConfiguration /* extends CachingConfigurerSupport */{
    //----- Inicio Implementacion CacheManager para Cache almacenada en app -----
    /*
    @Bean
    public CacheManager getCache(){
        return new ConcurrentMapCacheManager("students","address");
    }
    */
    //----- Termino Implementacion CacheManager para Cache almacenada en app -----



    //----- Inicio Implementacion CacheManager para Cache almacenada en Redis con Redisson -----
    /*
    @Bean
    public CacheManager getCache(RedissonClient redissonClient){
        Map<String, CacheConfiguration> config = new HashMap<>();
        config.put("students", new CacheConfiguration());
        //config.put("address", new CacheConfiguration());

        return new RedissonSpringCacheManager(redissonClient);
    }
    */
    //----- Termino Implementacion CacheManager para Cache almacenada en Redis con Redisson -----



    public static final String STUDENTS_CACHE = "students";
    //----- Inicio Implementacion CacheManager para Cache almacenada en Redis con Lettuce -----
    ///*
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        redisCacheConfigurationMap.put(STUDENTS_CACHE, createConfig(1, ChronoUnit.MINUTES));
        redisCacheConfigurationMap.put("address", createConfig(1, ChronoUnit.MINUTES)); //Segunda Cache "address"

        return RedisCacheManager
                .builder(redisConnectionFactory)
                .withInitialCacheConfigurations(redisCacheConfigurationMap)
                .build();
    }
    //*/
    //----- Termino Implementacion CacheManager para Cache almacenada en Redis con Lettuce -----

    //----- Inicio Metodo con la configuracion de tiempo de durabilidad de la cache -----
    //*
    private RedisCacheConfiguration createConfig(long time, ChronoUnit temporalUnit){
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.of(time, temporalUnit));
    }
    //*/
    //----- Termino Metodo con la configuracion de tiempo de durabilidad de la cache -----
}
