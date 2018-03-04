package br.com.fabianotessarolo.todo.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabianotessarolo.todo.model.User;
import br.com.fabianotessarolo.todo.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepository;

	public HashMap<String, Object> login(String username, String password) {

		HashMap<String, Object> retornlogin = new HashMap<>();

		User user = userRepository.findByUsernameAndPassword(username, password);

		if (user != null && !user.getUsername().equals("")) {
			retornlogin.put("username", user.getUsername());
			retornlogin.put("logged", true);
		} else {
			retornlogin.put("username", 0);
			retornlogin.put("logged", false);
		}
		
		return retornlogin;

	}
	

}
