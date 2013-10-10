/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lalotech.spring.mvc.rest.service.impl;

import java.util.List;
import net.lalotech.spring.mvc.rest.dao.UserDAO;
import net.lalotech.spring.mvc.rest.model.User;
import net.lalotech.spring.mvc.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Eduardo
 */
@Service
@Transactional()
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserDAO userDao;

    @Override
    public List<User> getUsers() throws Exception {
        return userDao.findAll();
    }

    @Override
    public User findUser(Long id) throws Exception {
        //return userDao.findOne(id);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User createUser(User u) throws Exception {
        return userDao.save(u);
    }

    
}
