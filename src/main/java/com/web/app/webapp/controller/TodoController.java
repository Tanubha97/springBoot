package com.web.app.webapp.controller;


import com.web.app.webapp.model.Todo;
import com.web.app.webapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    TodoService todoService ;
    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model){
        String name= (String) model.get("name"); // or we can take the name paramater as default in object class variable.
        model.put("todos", todoService.retrieveTodos(name));
        return "list-todos";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public String showAddTodo(ModelMap model){
        return "add-todo";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, Todo todo){
        model.addAttribute("todo",new Todo(0,(String) model.get("name"),"Default Desc", new Date(), false ));
        return "redirect:/list-todos";
    }

    @RequestMapping(value="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam int id){
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }
}
