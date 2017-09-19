package com.problems.questions;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseLinkedList {
	class Node {
		Node next;
		int value;
		
		Node(int value) {
			this.value = value;
			this.next = null;
		}
		void add(Node node) {
			this.next = node;
		}
		
		@Override
		public boolean equals(Object node) { 
			if(this == (Node) node) return true;
			Node temp1 = this, temp2 = (Node)node;  
			while(temp1 != null && temp2 != null) { 
				if(temp1.value != temp2.value) return false; 
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			 
			return (temp1 == null && temp2 == null);
		} 
	}
	// Your resolution 
	// Time complexity: O(n) -> n would be the size of the list
	// Space complexity:  Since it uses the iteration method, the space complexity would be constant
	public Node reverse(Node head){
		//If List is null or there's only one node in the list
		if(head == null || head.next == null) return head;
		
		Node newHead = null, next = null;
		while(head != null) {
			next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		} 
		return newHead;
	} 
	
	// JUnit test cases 
	/*
	 * Testing with multiple Nodes in the List
	 */
	@Test
	public void testReveseWithMultipleNodes() {
		Node head = new Node(0);
		Node tail = head;
		for(int i = 1; i <= 10; i++) {
			Node node = new Node(i);
			tail.next = node;
			tail = node;
		} 

	    Node expectedHead = new Node(10);
	    Node expectedTail = expectedHead;
	    for(int i = 9; i >= 0; i--) {
			Node node = new Node(i);
			expectedTail.next = node;
			expectedTail = node;
		}  
   
	    assertEquals("Check Result: ", false, expectedHead.equals(head));  
	    //Check the function is working or not
	    Node reverse = reverse(head);
	    assertEquals("Check Result: ", true, expectedHead.equals(reverse));  
	}
	/*
	 * Testing with One Nodes in the List
	 */
	@Test
	public void testReveseWithOneNode() {
		Node head = new Node(0);  
	    Node expectedHead = new Node(0);  
	    Node reverse = reverse(head);
	    
	    assertEquals("Check Result: ", true, expectedHead.equals(reverse));  
	}
	/*
	 * Testing when Node is null
	 */
	@Test
	public void testReveseWithNull() { 
	    Node expectedHead = new Node(0);   
	    Node reverse = reverse(null);
	    
	    assertEquals("Check Result: ", false, expectedHead.equals(reverse));   
	} 

	@Test
	public void testReveseWithDifferentSize() { 
		Node head = new Node(0);
		Node tail = head;
		for(int i = 1; i <= 4; i++) {
			Node node = new Node(i);
			tail.next = node;
			tail = node;
		} 

	    Node expectedHead = new Node(5);
	    Node expectedTail = expectedHead;
	    for(int i = 4; i >= 0; i--) {
			Node node = new Node(i);
			expectedTail.next = node;
			expectedTail = node;
		}  
    
	    //It should return false since they have different sizes
	    Node reverse = reverse(head);
	    assertEquals("Check Result: ", false, expectedHead.equals(reverse));  
	}
}
 
