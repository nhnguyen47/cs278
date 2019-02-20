package cs272lab3;

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
		    return data + "," + link.toString();
		
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


	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		IntNode node1 = new IntNode(5, null);
		IntNode node2 = new IntNode(10, null);
		IntNode node3 = new IntNode();
		
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

	}

}
