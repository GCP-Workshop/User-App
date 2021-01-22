package com.example.demo;

import com.example.demo.Data.Health;
import com.example.demo.Data.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping(path = "/health")
    public Health health() {
        String instanceId = System.getenv("SSH_CLIENT");
        String status = String.format("success %s", instanceId);
        Health health = new Health("health", status);
        return health;
    }

    @GetMapping(path = "/users")
    public List<User> users() {
        List<User> userList = new ArrayList<>();
        User user = new User("jack", 15, "India");
        userList.add(user);
        return userList;
    }

}
