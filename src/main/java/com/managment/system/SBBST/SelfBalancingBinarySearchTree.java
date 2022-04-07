/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managment.system.SBBST;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author yasser
 */
public class SelfBalancingBinarySearchTree implements BSTinterface<SBBSTNode> {

    private SBBSTNode root;

    private String treeStr;

    List<SBBSTNode> treeNodes;

    List<SBBSTNode> orderedTreeNodes;

    /* Constructor */
    public SelfBalancingBinarySearchTree() {
        root = null;
    }

    /* Function to check if tree is empty */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /* Make the tree logically empty */
    public void clear() {
        root = null;
    }

    /* Function to insert data */
    public void insert(int data) {
        root = insert(data, root);
    }

    /* Function to get height of node */
    private int height(SBBSTNode t) {
        return t == null ? -1 : t.height;
    }

    /* Function to max of left/right node */
    private int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }

    /* Function to insert data recursively */
    private SBBSTNode insert(int x, SBBSTNode t) {
        if (t == null) {
            t = new SBBSTNode(x);
        } else if (x < t.data) {
            t.left = insert(x, t.left);
            if (height(t.left) - height(t.right) == 2) {
                if (x < t.left.data) {
                    t = rotateWithLeftChild(t);
                } else {
                    t = doubleWithLeftChild(t);
                }
            }
        } else if (x > t.data) {
            t.right = insert(x, t.right);
            if (height(t.right) - height(t.left) == 2) {
                if (x > t.right.data) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }
        } else
           ;  // Duplicate; do nothing
        t.height = max(height(t.left), height(t.right)) + 1;
        return t;
    }

    /* Rotate binary tree node with left child */
    private SBBSTNode rotateWithLeftChild(SBBSTNode k2) {
        SBBSTNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /* Rotate binary tree node with right child */
    private SBBSTNode rotateWithRightChild(SBBSTNode k1) {
        SBBSTNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;
        return k2;
    }

    /**
     * Double rotate binary tree node: first left child with its right child;
     * then node k3 with new left child
     */
    private SBBSTNode doubleWithLeftChild(SBBSTNode k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child with its left child;
     * then node k1 with new right child
     */
    private SBBSTNode doubleWithRightChild(SBBSTNode k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    /* Functions to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(SBBSTNode r) {
        if (r == null) {
            return 0;
        } else {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }

    /* Functions to search for an element */
    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(SBBSTNode r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rval = r.data;
            if (val < rval) {
                r = r.left;
            } else if (val > rval) {
                r = r.right;
            } else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }

    private void inorder(SBBSTNode r) {
        if (r != null) {
            inorder(r.left);
            System.out.print(r.data + " ");
            inorder(r.right);
        }
    }

    /* Function for preorder traversal */
    public void preorder() {
        preorder(root);
    }

    private void preorder(SBBSTNode r) {
        if (r != null) {
            System.out.print(r.data + " ");
            preorder(r.left);
            preorder(r.right);
        }
    }

    /* Function for postorder traversal */
    public void postorder() {
        postorder(root);
    }

    private void postorder(SBBSTNode r) {
        if (r != null) {
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.data + " ");
        }
    }

    public void orderTreeNodesByLevel() {
        treeNodes = new ArrayList<>();
        orderedTreeNodes = new ArrayList<>();
        fillNodeList(root);
        orderedTreeNodes = treeNodes.stream()
                .sorted(Comparator.comparingInt(SBBSTNode::getHeight).reversed())
                .collect(Collectors.toList());
    }

    public List<SBBSTNode> getTreeNodesOrderedByLevel() {
        treeNodes = new ArrayList<>();
        orderedTreeNodes = new ArrayList<>();
        fillNodeList(root);
        orderedTreeNodes = treeNodes.stream()
                .sorted(Comparator.comparingInt(SBBSTNode::getHeight).reversed())
                .collect(Collectors.toList());
        return orderedTreeNodes;
    }

    private void fillNodeList(SBBSTNode r) {
        if (r != null) {
            postorder(r.left);
            postorder(r.right);
            treeNodes.add(r);
        }
    }

    public List<SBBSTNode> getTreeNodes() {
        return treeNodes;
    }

    public void setTreeNodes(List<SBBSTNode> treeNodes) {
        this.treeNodes = treeNodes;
    }

    public List<SBBSTNode> getOrderedTreeNodes() {
        return orderedTreeNodes;
    }

    public void setOrderedTreeNodes(List<SBBSTNode> orderedTreeNodes) {
        this.orderedTreeNodes = orderedTreeNodes;
    }

    @Override
    public SBBSTNode add(SBBSTNode element) {
        SBBSTNode iteratorNode = root;
        if (iteratorNode == null) {
            root = element;
            return element;
        } else {
            while (iteratorNode != null) {
                if (iteratorNode.data == element.data) {
                    return null;
                }
                if (element.data > iteratorNode.data) {
                    if (iteratorNode.right == null) {
                        iteratorNode.right = element;
                        return element;
                    } else {
                        iteratorNode = iteratorNode.right;
                    }
                } else if (element.data < iteratorNode.data) {
                    if (iteratorNode.left == null) {
                        iteratorNode.left = element;
                        return element;
                    } else {
                        iteratorNode = iteratorNode.left;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public SBBSTNode addBalanced(SBBSTNode element) {
        insert(element.data);
        return element;
    }

    @Override
    public boolean contains(SBBSTNode element) {
        return search(element.data);
    }

    @Override
    public int size() {
        return countNodes();
    }

    @Override
    public SBBSTNode delete(SBBSTNode element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SBBSTNode max() {
        SBBSTNode maxNode = root;
        while (maxNode.getRight() != null) {
            maxNode = maxNode.getRight();
        }
        return maxNode;
    }

    @Override
    public SBBSTNode min() {
        SBBSTNode minNode = root;
        while (minNode.getLeft() != null) {
            minNode = minNode.getLeft();
        }
        return minNode;
    }

    @Override
    public String display() {
        return display(root);
    }

    private String display(SBBSTNode r) {
        if (r != null) {
            postorder(r.left);
            postorder(r.right);
            treeStr = treeStr + r.data;
        }
        return treeStr;
    }

    @Override
    public boolean edit(SBBSTNode oldElement, SBBSTNode newElement) {
        SBBSTNode current = root;
        while (current != null) {
            if (current.data == oldElement.data) {
                current.data = newElement.data;
                return true;
            }
            current = current.data < oldElement.data ? current.right : current.left;
        }
        return false;
    }

    @Override
    public boolean isBalanced() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SBBSTNode> toList() {
        return getOrderedTreeNodes();
    }

}
