package com.example.demo;

import com.example.demo.Data.Health;
import com.example.demo.Data.PubSubRequest;
import com.example.demo.Data.User;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    private static final Logger logger = Logger.getLogger(DemoApplication.class.getName());

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/health")
    public Health health() throws UnknownHostException {
        logger.info("Request received to check health");
        InetAddress id = InetAddress.getLocalHost();
        String status = String.format("success %s", id.getHostName());
        Health health = new Health("health check", status);
        logger.info("status of health check " + status);
        return health;
    }

    @GetMapping(path = "/health-down")
    public Health healthDown() throws UnknownHostException {
        logger.info("Request received to log error");
        InetAddress id = InetAddress.getLocalHost();
        String status = String.format("failure %s", id.getHostName());
        Health health = new Health("health", status);
        logger.warning("health check fail " + status);
        logger.severe("health check fail " + status);
        return health;
    }

    @GetMapping(path = "/users")
    public List<User> users() {
        logger.info("Request received to retrieve users");
        List<User> userList = userRepository.findAll();
        logger.info("Returned User list of size " + userList.size());
        return userList;
    }

    @PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
    public User users(@RequestBody PubSubRequest pubSubRequest) throws JsonProcessingException {

        logger.info("Request received to add user");
        String decodedMessage = pubSubRequest.getPubSubMessage().getBase64DecodedData();
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(decodedMessage, User.class);
        logger.info("Parsed encoded data");
        userRepository.save(user);
        logger.info("Stored user information");
        return user;
    }

}
