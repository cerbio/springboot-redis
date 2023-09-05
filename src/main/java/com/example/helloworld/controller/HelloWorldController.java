package com.example.helloworld.controller;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String sendGreetings() {
        return "Hello, World!";
    }

    @GetMapping("ping")
    public ping(){
        // Replace these values with your Redis server configuration
        String redisHost = "localhost"; // Redis server host
        int redisPort = 6379;          // Redis server port
        String redisPassword = "your_password"; // Replace with your Redis password

        // Create a Jedis instance
        Jedis jedis = new Jedis(redisHost, redisPort);

        // Authenticate with the Redis server using the password
        jedis.auth(redisPassword);

        // Test the connection by sending a PING command
        String response = jedis.ping();
        System.out.println("Server response: " + response);

        // Close the Jedis connection when you're done
        jedis.close();
    }
}
