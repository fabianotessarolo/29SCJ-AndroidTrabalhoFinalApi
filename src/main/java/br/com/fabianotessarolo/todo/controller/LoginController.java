package br.com.fabianotessarolo.todo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabianotessarolo.todo.model.Login;
import br.com.fabianotessarolo.todo.service.LoginService;

@RestController
@CrossOrigin
@RequestMapping(value = "/app")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login) {

		HashMap<String, Object> returnlogin = new HashMap<String, Object>();

		HttpStatus returnStatus = HttpStatus.OK;

		if (login != null && !login.getUsername().equals("")) {
			returnlogin = loginService.login(login.getUsername(), login.getPassword());

			boolean loginStatus = (boolean) returnlogin.get("logged");

			if (!loginStatus) {
				returnlogin.put("message", "invalid user or password");
				returnStatus = HttpStatus.UNAUTHORIZED;
			}

		} else {
			returnlogin.put("message", "invalid parameters");
			returnStatus = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<HashMap<String, Object>>(returnlogin, returnStatus);

	}

}
