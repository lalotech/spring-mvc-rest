/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lalotech.spring.mvc.rest.controller;

import java.util.List;
import net.lalotech.spring.mvc.rest.model.User;
import net.lalotech.spring.mvc.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Eduardo
 */
@Controller()
public class UserREST {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody()
    public List<User> getUsers() {
        System.out.println("call users");
        try {
            return userService.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping(value = "/user/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody()
    public User getUsers(@PathVariable("id")Long id) throws Exception{        
        return userService.findUser(id);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleException(Exception e) {
        return "System Error";
    }

}
