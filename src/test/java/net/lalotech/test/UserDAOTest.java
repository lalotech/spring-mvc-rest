/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lalotech.test;

import net.lalotech.spring.mvc.config.PersistenceConfiguration;
import net.lalotech.spring.mvc.config.SystemConfiguration;
import net.lalotech.spring.mvc.rest.dao.UserDAO;
import net.lalotech.spring.mvc.rest.model.User;
import net.lalotech.spring.mvc.rest.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Eduardo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SystemConfiguration.class, PersistenceConfiguration.class})
public class UserDAOTest {

    @Autowired
    UserDAO user;

    @Autowired
    UserService userService;

    @Test()
    public void test() throws Exception {
        System.out.println("call test " + userService.getUsers().size());
    }
    @Test()
    public void test1() throws Exception{
        
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setUsername("username"+(i+1));
            System.out.println("username"+(i+1));
            //userService.createUser(u);
        }
        
    }
}
