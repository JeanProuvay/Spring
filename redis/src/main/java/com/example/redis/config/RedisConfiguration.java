package com.example.redis.config;

import com.example.redis.domain.Student;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    //----- Inicio Implementacion con Jedis (ConnectionFactory) -----
    /*
    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory(new RedisStandaloneConfiguration("localhost",6379));
    }
    */
    //----- Termino Implementacion con Jedis (ConnectionFactory) -----


    //----- Inicio Implementacion con Redisson (RedissonClient) -----
    /*
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        return Redisson.create(config);
    }
    */
    //----- Termino Implementacion con Redisson (RedissonClient) -----


    //----- Inicio Implementacion con Lettuce (ConnectionFactory) -----
    ///*
    @Bean
    public LettuceConnectionFactory redisConnectionFactory(){
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost",6379));
    }
    //*/
    //----- Termino Implementacion con Lettuce (ConnectionFactory) -----


    //----- Inicio Implementacion redisTemplate para consultar redis directamente -----
    ///*
    @Bean
    RedisTemplate<String, Student> redisTemplate(){
        final RedisTemplate<String, Student> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory()); //Funciona con un ConnectionFactory de Jedis o Lettuce
        return redisTemplate;
    }
    //*/
    //----- Termino Implementacion redisTemplate para consultar redis directamente -----
}
