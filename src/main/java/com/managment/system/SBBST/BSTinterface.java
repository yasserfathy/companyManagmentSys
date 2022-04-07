/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managment.system.SBBST;

import java.util.List;

/**
 *
 * @author Omar Abdelbr
 */
interface BSTinterface<E> {

    public E add(E element); //returns the object

    public E addBalanced(E element);

    public boolean isEmpty();

    public boolean contains(E element); // breadth first or depth first search

    public int size();

    public E delete(E element); //returns the object, not a Node<E>.

    public E max();

    public E min();

    public String display();

    public String toString();

    public boolean edit(E oldElement, E newElement);

    public boolean isBalanced();

    public List<E> toList();//returns an in-order list of E
}
