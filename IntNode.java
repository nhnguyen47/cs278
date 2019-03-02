package cs272lab4;

/*
 *  Author Nhat Nguyen
 *  Course: CS 272
 *  BannerID: 800608179
 *  Date: Feb 19 2019
 */

public class IntNode {
	
	private int data;
	private IntNode link;
	
	/** no-argument constructor
	 *  @postcondition
	 *   node value is 0, and
	 *   link is null reference. 
	 */  
	
	public IntNode() {
		
		data = 0;
		link = null;
		
	}
	
	/**
	 * @param _data
	 *  assign node value.
	 * @param _node
	 *  assign link to node.
	 */
	
	public IntNode (int _data, IntNode _node) {
		
		data = _data;
		link = _node;
		
	}

	/**
	 * @return
	 *  value of a node.
	 */
	
	public int getData() {
		
		return data;
		
	}
	
	/**
	 * @return
	 *  link of a node.
	 */
	
	public IntNode getLink() {
		
		return link;
		
	}
	
	/**
	 * @param newData
	 *  new value to be set to a node.
	 */
	
	public void setData(int newData) {
		
		data = newData;
		
	}
	
	/**
	 * @param newLink
	 *  new link to be set to a node.
	 */
	
	public void setLink(IntNode newLink) {
		
		link = newLink;
		
	}
	
	/**
	 * @param head
	 *  starting node.
	 * @return
	 *  number of nodes in a list starting from a given head.
	 */
	
	public static int listLength(IntNode head) {
		
		int answer = 0;
		
		for(IntNode cursor = head; cursor != null; cursor = cursor.link) {
			
			answer++;
			
		}
		
		return answer;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	public String toString() {
		
		if (link == null)
			
		    return data + "";
		
		else 
			
		    return data + "->" + link.toString();
		
	}
	
	/**
	 * @param newdata
	 *  new node value.
	 *  @postcondition
	 *   a new node has been added after a given node.
	 */
	
	public void addNodeAfterThis(int newdata) {
		
		link = new IntNode(newdata, link);
		
	}
	
	/**
	 * @param head
	 *  given head node.
	 * @param data
	 *  value in a linked list with given head node to be searched.
	 * @return
	 *  true if given value exists in the linked list,
	 *  false otherwise.
	 */
	
	public static boolean search(IntNode head, int data) {
		
		if(head == null)
			
			return false;
		
		else {
			
			IntNode cursor;
			
			for(cursor = head; cursor != null; cursor = cursor.link) {
				
				if(cursor.data == data) 
					
					return true;
	
			}
			
			return false;
			
		}
		
	}
	
	/**
	 * @postcondition
	 *  a node has been removed after a given node.
	 */
	
	public void removeNodeAfterThis() {
		
		if(link == null) {
			
			System.out.println("No node after to be removed.");
			
		}
		
		link = link.link;
		
	}
	
	/**
	 * @param head
	 *  the start of the tested linked list.
	 * @return
	 *  0 if head is null, otherwise
	 *  number of even elements.
	 */
	
	public static int listEvenNumber(IntNode head) {
		
		int evennum = 0;
		IntNode cursor;
		
		if(head == null)
			
			return 0;
		
		for(cursor = head; cursor != null; cursor = cursor.link) {
			
			if(cursor.data % 2 == 0)
				
				evennum++;
			
		}
		
		return evennum;
		
	}
	
	/**
	 * @param newdata
	 *  new value to be added.
	 * @postcondition
	 *  new data has been added to the end of the linked list.
	 */
	
	public void addToEnd(int newdata) {
		
		IntNode temp = this;
		
    	while(temp.link != null) {
    		
    		temp = temp.link;
    		
    	}
    	
    	temp.link = new IntNode(newdata, null);
		
	}
	
	/**
	 * @param head
	 *  the start of the linked list.
	 * @param num
	 *  the number of nodes at the back to be taken the sum of.
	 * @return
	 *  the total sum of the last nodes in the list.
	 */
	
	public static int sumLast(IntNode head, int num) {
		
		if(head == null)
			
    		return 0;
		
    	else {
    		
    		int count = 0;
    		IntNode temp = head;
    		
    		while(temp != null) {
    			
    			count++;
    			
    			temp = temp.link;
    			
    		}
    		
    		if(num >= count)
    			
    			return head.data + sumLast(head.link, num--);
    		
    		else
    			
    			return sumLast(head.link, num);
		}

	}
	
	/**
	 * @param head
	 *  the start of the link list.
	 * @return
	 *  null if head is null, otherwise
	 *  a new list with all odd elements from the current list.
	 */
	public static IntNode copyOdd(IntNode head) {
		
		if(head == null)
			
			return null;
		
		IntNode newList = null;
		
    	while(head != null) {
    		
    		if(head.data % 2 == 1)
    			
    			newList = new IntNode(head.data, newList);
    		
    		head = head.link;
    		
    	}
    	
    	return newList;
    	
	}
	
	/**
	 * @param head
	 *  the start of the linked list.
	 * @param e
	 *  the value to be removed.
	 * @return
	 * all nodes without value e.
	 */
	
	public static IntNode removeAll(IntNode head, int e) {
		
		IntNode prev = null;
		IntNode temp = head;
		
    	while(temp != null) {
    		
    		if(temp.data == e) {
    			
    			if(prev == null)
    				
    				head = temp.link;
    			
    			else

    				prev.link = temp.link;
    		}
    		
    		prev = temp;
    		
    		temp = temp.link;
    		
    	}
    	
    	return head;

	}
	
	/**
	 * @param head
	 *  the start of the linked list.
	 * @return
	 *  the head itself if head is null or list only has 1 node, otherwise
	 *  the reversed linked list.
	 */
	
	public static IntNode reverse(IntNode head) {
		
		if (head == null || head.link == null) {
			
			
			return head;
		}
		
		else {
			
			IntNode next = head.link;
			
			head.setLink(null);
			
			IntNode rev = reverse(next);
			
			next.setLink(head);
			
			return rev;
			
		}

	}
	
	/**
	 * @param head
	 *  the start of the linked list.
	 * @return
	 *  whether the linked list has a cycle or not.
	 */
	
	public static boolean hasCycle(IntNode head) {
		
		IntNode temp = head; 
		IntNode visited[] = new IntNode[500];
		int count = 0;
		
    	while(temp != null) {
    		
    		int i = 0;
    		
    		while(i < count) {
    			
    			if(visited[i] == temp)
    			
    				return true;
    		
    			i++;
    		
    		}
    		
    		visited[count] = temp;
    		
    		count++;
    		
    		temp = temp.link;
    	}
    	
    	return false;

	}
	
	/**Make cycle for testing.
	 * @param head
	 *  the start of the linked list.
	 * @param i
	 *  i-th node from the head to link the end node to.
	 * @postcondition
	 *  the tail has been linked to the i-th node from the head. 
	 */
	
	public static void makeCycle(IntNode head, int i) {
		
    	IntNode temp = head; 
    	IntNode cycle = null;
    	
    	while(temp.link != null) {
    		
    		if(i == 0)
    		
    			cycle = temp;
    		
    		i--;
    		
    		temp = temp.link;
    	}
    	
    	temp.link = cycle;
    	
    }

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		IntNode node1 = new IntNode(5, null);
		IntNode node2 = new IntNode(10, null);
		IntNode node3 = new IntNode();
		
		System.out.println("\n=>LAB 3<=");
		
		// test getData() and getLink methods
		
		System.out.println("\n=>Test getData() and getLink methods<=");
		System.out.println("First node value: "+node1.getData());
		System.out.println("First node is linked to: "+node1.getLink());
		System.out.println("Second node value: "+node2.getData());
		System.out.println("Second node is linked to: "+node2.getLink());
		
		// test setData() method
		
		System.out.println("\n=>Test setData() method<=");
		System.out.println("Old node value: "+node3.getData());
		node3.setData(30);
		System.out.println("New node value: "+node3.getData());
		
		// test setLink() method
		
		System.out.println("\n=>Test setLink() method<=");
		node1.setLink(node2);
		System.out.println("New first node is linked to: "+node1.getLink());
		node2.setLink(node3);
		System.out.println("New second node is linked to: "+node2.getLink());
		
		// test listLength() method
		
		System.out.println("\n=>Test listLength() method<=");
		System.out.println("Number of nodes in the list: "+listLength(node1));
		
		// test toString() method
		
		System.out.println("\n=>Test toString() method<=");
		System.out.println("Linked list: "+node1.toString());
		
		// test addNodeAfterThis() method
		
		System.out.println("\n=>Test addNodeAfterThis() method<=");
		node1.addNodeAfterThis(20);
		System.out.println("New linked list: "+node1.toString());
		System.out.println("Number of nodes in the list: "+listLength(node1));
		
		// test search() method
		
		System.out.println("\n=>Test search() method<=");
		System.out.println("Is 20 a value in this list? "+search(node1, 20));
		System.out.println("Is 50 a value in this list? "+search(node1, 50));
		
		// test removeNodeAfterThis() method
		
		System.out.println("\n=>Test removeNodeAfterThis() method<=");
		node1.removeNodeAfterThis();
		System.out.println("New linked list: "+node1.toString());
		System.out.println("Number of nodes in the list: "+listLength(node1));
		
		System.out.println("\n=>LAB 4<=");
		
		// test listEvenNumber() method
		
		System.out.println("\n=>Test listEvenNumber() method<=");
		System.out.println("Original linked list: "+node1.toString());
		System.out.println("Number of even elements: "+listEvenNumber(node1));
		
		// test addToEnd() method
		
		System.out.println("\n=>Test addToEnd() method<=");
		System.out.println("Original linked list: "+node1.toString());
		node1.addToEnd(12);
		node1.addToEnd(28);
		node1.addToEnd(0);
		node1.addToEnd(34);
		System.out.println("New linked list: "+node1.toString());
		
		// test sumLast() method
		
		System.out.println("\n=>Test sumLast() method<=");
		System.out.println("Original linked list: "+node1.toString());
		System.out.println("Sum of last 1 node: "+sumLast(node1, 1));
		System.out.println("Sum of last 2 nodes: "+sumLast(node1, 2));
		System.out.println("Sum of last 3 nodes: "+sumLast(node1, 3));
		System.out.println("Sum of last 4 nodes: "+sumLast(node1, 4));
		
		// test copyOdd() method
		
		System.out.println("\n=>Test copyOdd() method<=");
		System.out.println("Original linked list: "+node1.toString());
		IntNode odds = copyOdd(node1);
		System.out.println("New linked list with only odd elements: "+odds.toString());
		
		// test removeAll() method
		
		System.out.println("\n=>Test removeAll() method<=");
		node1.addToEnd(12);
		node1.addToEnd(28);
		System.out.println("Original linked list: "+node1.toString());
		node1 = removeAll(node1, 12);
		System.out.println("Remove 12: "+node1.toString());
		node1 = removeAll(node1, 28);
		System.out.println("Remove 28: "+node1.toString());
		node1 = removeAll(node1, 5);
		System.out.println("Remove 5: "+node1.toString());
		
		// test reverse() method
		
		System.out.println("\n=>Test reverse() method<=");
		System.out.println("Original linked list: "+node1.toString());
		IntNode rev1 = reverse(node1);
		System.out.println("Reversed linked list: "+rev1.toString());
		
		// test hasCycle() method
		
		System.out.println("\n=>Test hasCycle() method<=");
		IntNode node4 = new IntNode(5, null);
		IntNode node5 = new IntNode(10, null);
		IntNode node6 = new IntNode(20, null);
		node4.setLink(node5);
		node5.setLink(node6);
		node4.addToEnd(30);
		node4.addToEnd(40);
		node4.addToEnd(50);
		node4.addToEnd(60);
		System.out.println("Original linked list: "+node4.toString());
		System.out.println("Has cycle?: "+hasCycle(node4));
		System.out.println("Linked last node to third node to make a cycle for testing.");
		makeCycle(node4, 3);
		System.out.println("Has cycle?: "+hasCycle(node4));
		
	}

}
