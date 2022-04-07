/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managment.system.Util;

import com.managment.system.SBBST.SBBSTNode;
import com.managment.system.SBBST.SelfBalancingBinarySearchTree;
import com.managment.system.model.Employees;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Omar Abdelbr
 */
public class EmployeesSBBST {
    
    SelfBalancingBinarySearchTree sbbst;
    List<Employees> employees;

    public EmployeesSBBST(List<Employees> employees) {
        this.employees = employees;
        this.sbbst = new SelfBalancingBinarySearchTree();
        constructTree();
    }
    
    private void constructTree(){
        //construct empty balanced tree
        for(int i=0 ; i<employees.size();i++){
            sbbst.insert(i);
        }
        //employees by status 1 - 2 - 3
        employees = employees.stream()
                .sorted(Comparator.comparingInt(Employees::getStatus))
                .collect(Collectors.toList());
        //order tree nodes by level 3 - 2 - 1
        sbbst.orderTreeNodesByLevel();
        //fill tree nodes
        for(int i=0 ; i<employees.size(); i++){
            sbbst.getOrderedTreeNodes().get(i).setEmployee(employees.get(i));
        }
    }        

    public SelfBalancingBinarySearchTree getSbbst() {
        return sbbst;
    }

    public void setSbbst(SelfBalancingBinarySearchTree sbbst) {
        this.sbbst = sbbst;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }
        
}
