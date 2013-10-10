/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lalotech.spring.mvc.rest.dao;

import javax.annotation.Resource;
import net.lalotech.spring.mvc.rest.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Eduardo
 */
@Repository()
public class UserDAO extends HibernateDAO<User>{ 
   public UserDAO(){
      setClazz(User.class );
   }
}
