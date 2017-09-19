package com.problems.questions;
 
import java.util.Arrays;
import java.util.LinkedList; 
import java.util.Queue; 

public class MultiDimensionArray { 
	 
    // This is a provided function, Assume it works
    public static Long getValue(int... indexOfDimension) {
    	long [][][] test = {
    			{
    				{1,2,3,4},
    				{1,2,3,4},
    				{0,0,0,0}
    			},
    			{
    				{1,2,3,4},
    				{1,2,3,4},
    				{1,2,3,4}
    			},
    			{
    				{1,2,3,4},
    				{1,2,3,4},
    				{1,2,3,15}
    			}
    	};
        //... 
    	int x = indexOfDimension[0];
    	int y = indexOfDimension[1];
    	int z = indexOfDimension[2];
    	System.out.println(x + " " + y + " " + z);
    	long value = test[x][y][z];
        return value;
    }
    // Time complexity:  Since we parse every element in the Array and output every possible combination, 
	//                   the time complexity would be O(len^n)-> n is the numbers of the dimensions, and len is the average length of each dimensions 
	// Space complexity: We use BFS and use a queue to store possible combinations, the space complexity would be O(len^n) as well
	
    public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) { 
    	long sum = 0L;  
    	Queue<int[]> queue = new LinkedList<int[]>();
    	int length = 0;
    	
    	for(int index = 0; index < lengthOfDeminsion.length; index++) {
    		length = lengthOfDeminsion[index];
    		if(index == 0) {
    			//When it's the first number, it needs to initialize the array
    			for(int i = 0; i < length; i++) {
    				int[] array= new int[lengthOfDeminsion.length];
    				array[index] = i;
    				queue.offer(array);
    			}
    		} else {
    			//Doing BFS to append possible combination
    			int level_count = queue.size(); 
        		for(int count = 0; count < level_count; count++) {
        			 int[] array = queue.remove();
        			 for(int i = 0; i < length; i++ ) {
        				 array[index] = i;
        				 if(index == lengthOfDeminsion.length - 1) {
        					 sum += getValue(array);
        				 } else {  
        					 int[] new_array = Arrays.copyOf(array,lengthOfDeminsion.length);
            				 queue.offer(new_array);
        				 } 
        			 }
        		}
    		} 
    	}  
    	return sum;
    } 
    
    public static void main(String[] args) {
    	MultiDimensionArray array = new MultiDimensionArray();
    	int[] indices = {3,3,4};
    	System.out.println( "Sum is :" + sum(array, indices) );
    }
}
