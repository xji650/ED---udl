/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Sayago
 * @param <T>
 */
public class TreeNode<T> {    
       T element;
       TreeNode<T> left;
       TreeNode<T> right;
       
       TreeNode(T element, TreeNode<T> left, TreeNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
       }    
}
