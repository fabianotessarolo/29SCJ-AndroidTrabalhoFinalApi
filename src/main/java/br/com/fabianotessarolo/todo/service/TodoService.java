package br.com.fabianotessarolo.todo.service;

import br.com.fabianotessarolo.todo.model.Todo;
import br.com.fabianotessarolo.todo.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public void salvar(Todo todo) {

        Todo aux = todoRepository.findByDescricao(todo.getDescricao());

        if (aux != null) {
            todo.setId(aux.getId());
        }

        todoRepository.save(todo);
    }

    public List<Todo> buscarTodas() {
        return todoRepository.findAll();

    }

    public Todo buscar(String descricao) {
        return todoRepository.findByDescricao(descricao);
    }
}
