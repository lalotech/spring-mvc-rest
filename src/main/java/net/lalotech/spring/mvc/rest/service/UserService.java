/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lalotech.spring.mvc.rest.service;

import java.util.List;
import net.lalotech.spring.mvc.rest.model.User;

/**
 *
 * @author Eduardo
 */
public interface UserService {
    List<User> getUsers() throws Exception;
    User findUser(Long id) throws Exception;
    User createUser(User u) throws Exception;
}
