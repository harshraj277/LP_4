package DAA;

import java.util.PriorityQueue;

class Node
{
	char ch;
	int freq;
	
	Node left , right;
	
	Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
	
	 
}


public class HuffmanEncoding {

	

	public static void main(String[] args) 
	{
		 char[] ch = {'A', 'B', 'C', 'D', 'E', 'F'};
	        int[] freq = {5, 9, 12, 13, 16, 45};
		
		
		//min heap based on frequency
		PriorityQueue<Node> pq = new PriorityQueue<>(
				(a,b)->Integer.compare(a.freq, b.freq)
				);
		
		//insert all character into the priority queue
		for (int i = 0; i < ch.length; i++) 
		{
			pq.add(new Node(ch[i],freq[i]));
		}
		
		//buil huffman tree
		
		while (pq.size()>1)
		{
			Node left =pq.poll();
			Node right=pq.poll();
			
			Node parent = new Node('-',left.freq+right.freq);
			
			parent.left=left;
			parent.right=right;
			
			pq.add(parent);
			
		}
		
		//generate huffman codes
		
		Node root = pq.poll();
		
		System.out.println("Huffman code :");
		generateCode(root,"");
		
	}

	private static void generateCode(Node root, String code) 
	{
		if(root==null)
		{
			return;
		}
		
		//leaf node
		if(root.left==null && root.right==null)
		{
			System.out.println(root.ch+" : "+code);
		}
		
		generateCode(root.left,code+"0");
		generateCode(root.right, code+"1");
		
	}
	
	
	

}
