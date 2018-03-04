package br.com.fabianotessarolo.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabianotessarolo.todo.model.User;
import br.com.fabianotessarolo.todo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public void salvar(User user) {

		User aux = userRepository.findByUsername(user.getUsername());

		if (aux != null) {
			user.setUsername(aux.getUsername());
		}

		userRepository.save(user);
	}

	public User buscar(String username) {
		return userRepository.findByUsername(username);
	}
}
