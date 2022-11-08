package com.gl.fssd.lab3.algo;

import java.util.HashSet;
import java.util.Set;

public class SearchSumInBST {
    

    public static class Node {
        private int iData;
        private Node objLeftNode;
        private Node objRightNode;

        public Node(int iData){
            super();
            this.iData = iData;
        }//End of constructor
        public int getData(){
            return this.iData;
        }//End of getData Method.
        public Node getLeft(){
            return this.objLeftNode;
        }//End of getLeft method

        public Node getRight(){
            return this.objRightNode;
        }//End of getRight method

        public String toString(){
            return this.iData+"";
        }//End of toString method
    }//End of Node static class

    private Node root; 
    public SearchSumInBST(int iData){
        this.root = new Node(iData);
    }//End of constructor 

    public void insert(int iData){
        if(this.root == null){
            this.root = new Node(iData);
        }
        insert(this.root, iData);
    }//End of insert method.

    private Node insert(Node objNode, int iData) {
        if(objNode==null)
            objNode = new Node(iData);

        if(iData < objNode.getData()){
            objNode.objLeftNode = insert(objNode.getLeft(),iData);
        }
        
        if(iData > objNode.getData()){
            objNode.objRightNode = insert(objNode.getRight(),iData);
        }
        return objNode;
    }//End of insert method

    public Set<Integer> findSumPair(int iSumm){
        Set<Integer> objValues = new HashSet<>();
        Set<Integer> objPair   = new HashSet<>();
        traversePreOrder(this.root, iSumm,objValues,objPair);
        return objPair;

    }//End of findSumPair

    private boolean traversePreOrder(Node objNode, int iSum, Set<Integer> objCollectedValues, Set<Integer> objPair){
        if(objNode == null)
            return false;
        int iNodeData = objNode.iData;
        if(objCollectedValues.contains(iSum-iNodeData)){
            objPair.add(iSum-iNodeData);
            objPair.add(iNodeData);
            return true;
        }//End of if block
        objCollectedValues.add(iNodeData);
        if((objNode.getLeft()!=null) && (traversePreOrder(objNode.getLeft(), iSum, objCollectedValues, objPair)) )
            return true;
        if((objNode.getRight()!=null) && (traversePreOrder(objNode.getRight(), iSum, objCollectedValues, objPair)) )
            return true;    
        return false;
    }//End of traversePreOrder method.
    
}//End of SearchSumInBST class