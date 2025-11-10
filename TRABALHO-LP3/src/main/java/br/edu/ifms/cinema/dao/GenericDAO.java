/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.cinema.dao;

import java.util.List;

/**
 *
 * @author victor ferreira
 */
public interface GenericDAO<T> {
    public void add(T entity);
    public T update(T entity);
    public void remove (T entity);
    public T getById(Long id);
    public List<T> getAll();
    
}
