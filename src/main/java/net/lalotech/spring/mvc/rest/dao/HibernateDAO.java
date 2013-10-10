/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lalotech.spring.mvc.rest.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Eduardo
 */
abstract class HibernateDAO<T>{
   private Class< T > clazz;
 
   @Autowired
   private SessionFactory sessionFactory;
 
   public void setClazz( final Class< T > clazzToSet ){
      clazz = clazzToSet;
   }
 
   public T findOne( final long id ){
      return (T) getCurrentSession().get( clazz, id );
   }
   
   public List< T > findAll(){
      return getCurrentSession()
       .createQuery( "SELECT o FROM " + clazz.getSimpleName()+" o").list();
   }
 
   public T save( final T entity ){
      getCurrentSession().persist( entity );
      return entity;
   }
 
   public T update( final T entity ){
      return (T) getCurrentSession().merge( entity );
   }
 
   public void delete( final T entity ){
      getCurrentSession().delete( entity );
   }
   public void deleteById( final long id ){
      final T entity = findOne( id);
      delete( entity );
   }
 
   protected final Session getCurrentSession(){
      return sessionFactory.getCurrentSession();
   }
}
