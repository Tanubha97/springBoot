package com.web.app.webapp.controller;


import com.web.app.webapp.model.Todo;
import com.web.app.webapp.service.TodoRepository;
import com.web.app.webapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TodoController {

    // @Autowired
    //TodoService todoService ;

    @Autowired
    TodoRepository repository;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    private String getLoggedinUserName(ModelMap model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }
    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model){
        String name= getLoggedinUserName(model); // or we can take the name paramater as defaul in object class variable.
        model.put("todos", repository.findByUser(name));
        // model.put("todos", todoService.retrieveTodos(name));
        return "list-todos";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public String showTodo(ModelMap model)
    {   model.addAttribute("todo",new Todo(0,(String) model.get("name"),
            " ", new Date(), false ));
        return "add-todo";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "add-todo";
        }
        todo.setUser(getLoggedinUserName(model));
        repository.save(todo);
       // todoService.addTodo(getLoggedinUserName(model),todo.getDesc() , todo.getTargetDate(), false);
        return "redirect:/list-todos";
    }
    @RequestMapping(value="/update-todo", method = RequestMethod.GET)
    public String updateTodo(ModelMap model, @RequestParam int id){
        // Todo todo = todoService.retrieveTodo(id);
        Todo todo = repository.findById(id).get();
        model.put("todo",todo);
        return "add-todo";
    }

    @RequestMapping(value="/update-todo", method = RequestMethod.POST)
    public String updatedTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "add-todo";
        }
        todo.setUser(getLoggedinUserName(model));
        repository.save(todo);
      //  todoService.updateTodo(todo);
        return "redirect:/list-todos";
    }

    @RequestMapping(value="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam int id){
        /*if(id==1)
            throw new RuntimeException("Something went wrong"); */
        //todoService.deleteTodo(id);
        repository.deleteById(id);
        return "redirect:/list-todos";
    }
}
