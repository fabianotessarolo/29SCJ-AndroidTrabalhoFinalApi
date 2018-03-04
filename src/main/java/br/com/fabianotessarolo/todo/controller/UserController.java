package br.com.fabianotessarolo.todo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabianotessarolo.todo.model.User;
import br.com.fabianotessarolo.todo.service.UserService;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/{username}")
    User buscar (@PathVariable(value = "username") String username) {
    		logger.info("GET:" + username);
        return userService.buscar(username);
    }

    @PostMapping
    public void salvar(@RequestBody User user) {
    	logger.info("SAVING:" + user.getUsername());
        userService.salvar(user);
    }



}
