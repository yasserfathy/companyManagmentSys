/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managment.system.model;

import java.util.List;

/**
 *
 * @author yasser
 * @param <Employee>
 */
public interface BSTinterface<Employee> {

    public Employee add(Employee element); //returns the object

    public Employee addBalanced(Employee element);

    public boolean isEmpty();

    public boolean contains(Employee element); // breadth first or depth first search

    public int size();

    public Employee delete(Employee element); //returns the object, not a Node<E>.

    public Employee max();

    public Employee min();

    public String display();

    @Override
    public String toString();

    public boolean edit(Employee oldElement, Employee newElement);

    public boolean isBalanced();

    public List<Employee> toList();//returns an in-order list of E
}
