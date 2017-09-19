package com.problems.questions;

public class FindingPopluarNumber {
	public static int solution(int[] arrays) {
		int res = -1;
		int idx = arrays.length / 4;
		while(idx <= 3*arrays.length/4) {
			//Doing Binary Search here
			int num = arrays[idx];
			//System.out.println(idx + " " + num);
			//use BS to find the first occurence
			int start = findFirst(arrays, 0, arrays.length, num);
			int end   = findLast(arrays, 0, arrays.length, num);
			 
			if((end - start + 1) > arrays.length/4) return num; 
			idx += arrays.length / 4; 
		}
		
		return res;
	}
	
	public static int findFirst(int[] arrays, int start, int end, int num) {
		int low = start;
		int high = end;
		
		while(low <= high) {
			int mid = low + (high - low)/2;
			if((mid == 0 || num > arrays[mid - 1]) && num == arrays[mid]) return mid;
			else if(num > arrays[mid]) low = mid + 1;
			else high = mid - 1;
			
		}
		
		return -1;
	}
	
	public static int findLast(int[] arrays, int start, int end, int num) {
		int low = start;
		int high = end;
		
		while(low <= high) {
			int mid = low + (high - low)/2;
			if((mid == arrays.length - 1|| num < arrays[mid + 1]) && num == arrays[mid]) return mid;
			else if(num < arrays[mid]) high = mid - 1;
			else low = mid + 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arrays =   {1,2,3,4,4,4,4,4,5,6,7,8};
		int[] arrays2 =  {1,2,4,4,4,7,7,7,9,9,9,9} ;
		System.out.println("Hello World");
		System.out.println(solution(arrays));
		System.out.println(solution(arrays2));
		
		 int x[][][]=new int[5][8][10];
	        System.out.println(x.length+" "+x[0].length+" "+x[0][0].length);
		
	}
}
