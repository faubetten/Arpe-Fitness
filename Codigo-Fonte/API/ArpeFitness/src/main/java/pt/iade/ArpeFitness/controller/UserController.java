package pt.iade.ArpeFitness.controller;

import pt.iade.ArpeFitness.models.tables.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.ArpeFitness.models.repositories.UserRepository;

@RestController
@RequestMapping(path = "/api/user")

public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getUserByName(@PathVariable("name") String name) {
        logger.info("Sending user data by name: " + name);
        return userRepository.findUserByName(name);
    }


    
}
