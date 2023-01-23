package algorithm07;

import java.util.*;
class Node3{ 
    int data; 
    Node3 lt, rt; 
    public Node3(int val) { 
        data=val; 
        lt=rt=null; 
    } 
} 
  
public class DFS이진트리순회{ 
    Node3 root; 
  
    Node3 DFS(Node3 node) {
    	if(node == null) return node;
    	else {
    		DFS(node.lt);
    		//4, 2, 5, 1, 6, 3, 7
    		DFS(node.rt);
    		System.out.print(node.data+" ");
    		//4, 5, 2, 6, 7, 3, 1
    	}
    	return node;
    }
    
    public static void main(String args[]) { 
    	DFS이진트리순회 tree=new DFS이진트리순회(); 
        tree.root=new Node3(1); 
        tree.root.lt=new Node3(2); 
        tree.root.rt=new Node3(3); 
        tree.root.lt.lt=new Node3(4); 
        tree.root.lt.rt=new Node3(5); 
		tree.root.rt.lt=new Node3(6); 
        tree.root.rt.rt=new Node3(7);
        tree.DFS(tree.root); 
    } 
} 