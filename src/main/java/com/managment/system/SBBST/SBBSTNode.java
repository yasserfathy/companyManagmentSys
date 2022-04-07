/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managment.system.SBBST;

/**
 *
 * @author yasser
 */
public class SBBSTNode {

    SBBSTNode left, right;
    int data;
    int height;

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
}
