package com.example.demo;

import com.example.demo.Data.Health;
import com.example.demo.Data.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/health")
    public Health health() throws UnknownHostException {
        InetAddress id = InetAddress.getLocalHost();
        String status = String.format("success %s", id.getHostName());
        Health health = new Health("health", status);
        return health;
    }

    @GetMapping(path = "/users")
    public List<User> users() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
    public User users(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

}
