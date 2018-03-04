package br.com.fabianotessarolo.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.fabianotessarolo.todo.model.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {

    Todo findByDescricao(String descricao);




}
