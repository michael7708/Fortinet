package com.problems.questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class DivideAListIntoKGroupsWithEqualSum {
	public boolean separate(List<Integer> list, int k){
		if(list == null || list.size() < k || k == 0) return false; 
		if(k == 1) return true;  
		// Time complexity:  we use recursion to get possible combination. The complexity would be O(2^n), n would be the size of the list
		// Space complexity: The space would be O(2^N), because the recursion methods can be stacked 2^n times in memory 
		
		//Getting the total sum to check if it's possible to divide the list into K groups with equal sum
		long totalSum = 0L;
		for(int i : list) totalSum += i;  
		if(totalSum % k != 0) return false;
		Collections.sort(list);
		
		//The sum in each group...
		long subSum = totalSum/k;
		long[] subGroups = new long[k];
		boolean[] visited = new boolean[list.size()];
		System.out.println(subSum);
		boolean result = helper(list, k, subSum, 0, subGroups, visited, 0); 
		return  result;
	}
	
	public boolean helper(List<Integer> list, int K, long subSum, int groupIndex, long[] subGroups, boolean[] visited, int start) {
		//System.out.println(Arrays.toString(subGroups));
		//System.out.println("Visited " +Arrays.toString(visited) + "\n");
		if(start <= list.size() - 1 && subGroups[groupIndex] == subSum) {
			if(groupIndex == K - 1) return true;
			return helper(list, K, subSum, groupIndex + 1, subGroups, visited, 0);
		} 
		
		for(int i = start; i <list.size(); i++) {
			if(visited[i]) continue;
			long tempSum = subGroups[groupIndex] + (long)list.get(i);
			
			if(tempSum <= subSum) {
				visited[i] = true;
				subGroups[groupIndex] = tempSum;
				boolean result = helper(list, K, subSum, groupIndex, subGroups, visited, start + 1);
				
				//Need to restore to the previous state in order to get next possible combination
				visited[i] = false;
				subGroups[groupIndex] -= (long)list.get(i);
				
				if(result) return true;
			} else break; //No need to add the rest since the list is sorted
		}
		return false;
	}
	
	// JUnit test cases 
	@Test
	public void testSeperate() {
		DivideAListIntoKGroupsWithEqualSum q = new DivideAListIntoKGroupsWithEqualSum();
		Integer[] test = {2, 2, 2, 2, 2, 2};
		List<Integer> list = Arrays.asList(test); 
		int K = 0;
		//Testing Null
		assertEquals("Check Result: ", false, q.separate(null, K)); 
		
		//Testing when K is 0
		assertEquals("Check Result: ", false, q.separate(list, K)); 
		
		//when K is greater than the size of the list
		K = 20;
		assertEquals("Check Result: ", false, q.separate(list, K)); 
		
		//When divide into 3 groups
		K = 3;
		assertEquals("Check Result: ", true, q.separate(list, K));  
		
		//When divide into 4 groups
		K = 4;
		assertEquals("Check Result: ", false, q.separate(list, K));  
		
		//When divide into list.size groups
		K = 6;
		assertEquals("Check Result: ", true, q.separate(list, K)); 
		
		//When values in the list are huge
		Integer[] test2 = {Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE, Integer.MAX_VALUE}; 
		List<Integer> list2 = Arrays.asList(test2);
		K = 2;
		assertEquals("Check Result: ", true, q.separate(list2, K));
	}   
}
