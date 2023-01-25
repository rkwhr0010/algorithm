package algorithm07;

import java.util.*;

class Node{ 
    int data; 
    Node lt, rt; 
    public Node(int val) { 
        data=val; 
        lt=rt=null; 
    } 
} 
  
public class Tree말단노드까지의가장짧은경로BFS{ 
    Node root; 
    
    public int BFS2(Node root){ 
    	Queue<Node> Q=new LinkedList<>();
    	Q.offer(root);
    	int L = 0 ;
    	
    	while(!Q.isEmpty()) {
    		int len = Q.size();
    		
    		for (int i = 0; i < len; i++) {
    			Node cur = Q.poll();
    			if(cur.lt ==null && cur.rt == null) return L;//자식노드가 없다면 말단
    			if(cur.lt != null) Q.add(cur.lt);
    			if(cur.rt != null) Q.add(cur.rt);
			}
    		L++;
    	}
    	return 0;
    } 
    
    
	public int BFS(Node root){ 
		Queue<Node> Q=new LinkedList<>();
		Q.offer(root);
		int L=0;
		while(!Q.isEmpty()){
			int len=Q.size();
			for(int i=0; i<len; i++){
				Node cur=Q.poll();
				if(cur.lt==null && cur.rt==null) return L;
				if(cur.lt!=null) Q.offer(cur.lt);
				if(cur.rt!=null) Q.offer(cur.rt);
			}
			L++;
		}
		return 0;
    } 
  
    public static void main(String args[]) { 
    	Tree말단노드까지의가장짧은경로BFS tree=new Tree말단노드까지의가장짧은경로BFS(); 
        tree.root=new Node(1); 
        tree.root.lt=new Node(2); 
        tree.root.rt=new Node(3); 
        tree.root.lt.lt=new Node(4); 
        tree.root.lt.rt=new Node(5); 
        System.out.println(tree.BFS(tree.root)); 
    } 
} 