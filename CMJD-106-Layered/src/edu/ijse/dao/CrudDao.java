/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.dao;

import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public interface CrudDao<T, ID> extends SuperDao{
    boolean create(T t) throws Exception; // Inserts a new entity (t) into the database.
    boolean update(T t) throws Exception;//Updates an existing entity (t) in the database.
    boolean delete(ID id) throws Exception; //Deletes an entity from the database based on its identifier (id).
    T get(ID id) throws Exception; //Retrieves an entity from the database based on its identifier (id).
    ArrayList<T> getAll() throws Exception; // Retrieves all entities of type T from the database.
}
