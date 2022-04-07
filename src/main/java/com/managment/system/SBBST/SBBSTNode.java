/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managment.system.SBBST;

import com.managment.system.model.Employees;

/**
 *
 * @author yasser
 */
public class SBBSTNode {

    SBBSTNode left, right;
    int data;
    int height;
    Employees employee;

    /* Constructor */
    public SBBSTNode() {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }
    /* Constructor */

    public SBBSTNode(int n) {
        left = null;
        right = null;
        data = n;
        height = 0;
    }

    public SBBSTNode getLeft() {
        return left;
    }

    public void setLeft(SBBSTNode left) {
        this.left = left;
    }

    public SBBSTNode getRight() {
        return right;
    }

    public void setRight(SBBSTNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }
    
    
}
