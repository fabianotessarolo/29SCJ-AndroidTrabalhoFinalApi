package br.com.fabianotessarolo.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.fabianotessarolo.todo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);




}
