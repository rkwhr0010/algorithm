package algorithm07;

import java.util.*;
class Node2{ 
    int data; 
    Node2 lt, rt; 
    public Node2(int val) { 
        data=val; 
        lt=rt=null; 
    } 
} 
  
public class BFS레벨탐색{ 
    Node2 root; 
    public void BFS(Node2 root){ 
		Queue<Node2> Q=new LinkedList<>();
		Q.add(root);
		int L=0;
        while(!Q.isEmpty()){
            int len = Q.size();
			System.out.print(L+" : ");
            for(int i=0; i<len; i++){
                Node2 cur = Q.poll();
                System.out.print(cur.data+" ");
                if(cur.lt!=null) Q.add(cur.lt);
                if(cur.rt!=null) Q.add(cur.rt);
            }
			L++;
			System.out.println();
        }
    } 
  
    void BFS2(Node2 root) {
    	Queue<Node2> q = new LinkedList<>();
    	int L = 0;
    	q.add(root);
    	
    	for(;!q.isEmpty();) {
    		int size = q.size();
    		for (int i = 0; i < size; i++) {
	    		Node2 cur = q.poll();
	    		System.out.print(cur.data+" ");
	    		if(cur.lt != null) q.add(cur.lt);
	    		if(cur.rt != null) q.add(cur.rt);
    		}
    		System.out.println();
    		L++;
    	}
    	
    }
    
    
    
    
    public static void main(String args[]) { 
    	BFS레벨탐색 tree=new BFS레벨탐색(); 
        tree.root=new Node2(1); 
        tree.root.lt=new Node2(2); 
        tree.root.rt=new Node2(3); 
        tree.root.lt.lt=new Node2(4); 
        tree.root.lt.rt=new Node2(5); 
		tree.root.rt.lt=new Node2(6); 
        tree.root.rt.rt=new Node2(7);
        tree.BFS2(tree.root); 
    } 
} 