package br.com.fabianotessarolo.todo.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabianotessarolo.todo.model.Todo;
import br.com.fabianotessarolo.todo.service.TodoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/todo")
public class TodoController {
	
	private static final Logger logger = Logger.getLogger(TodoController.class);

    @Autowired
    TodoService todoService;

    @GetMapping
    List<Todo> buscarTodos() {
    		logger.info("Listing documents...");
        return todoService.buscarTodas();

    }

    @GetMapping(value = "/descricao/{descricao}")
    Todo buscar (@PathVariable(value = "descricao") String descricao) {
    		logger.info("GET:" + descricao);
        return todoService.buscar(descricao);
    }

    @PostMapping
    public void salvar(@RequestBody Todo todo) {
    	logger.info("SAVING:" + todo.getDescricao());
        todoService.salvar(todo);
    }



}
