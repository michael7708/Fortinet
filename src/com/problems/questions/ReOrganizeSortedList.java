package com.problems.questions;

public class ReOrganizeSortedList {
	public ReOrganizeSortedList() {};
	public static String solution(int[] array) {
		StringBuffer sb = new StringBuffer();
		
		int prev = array[0];
		boolean give_hyphen = false;
		for(int i = 1; i < array.length; i++) { 
			if(array[i] == prev + 1 && !give_hyphen) {
				if(i == 1) sb.append(prev);
				sb.append('-');
				give_hyphen = true;
				if(i == array.length - 1) sb.append(array[i]);
			} else if(array[i] == prev + 1  && i == array.length - 1) {
				sb.append(array[i]);
			} else if(array[i] > prev + 1) { 
				if(give_hyphen) {
					sb.append(prev).append(',').append(array[i]); 
					give_hyphen = false;
				} else {
					if(i == 1) sb.append(prev);
					sb.append(',').append(array[i]);
				}
			} 
			prev = array[i];
		}
		
		return sb.toString();
	}
	
	public static String second_Solution(int[] array) {
		StringBuffer sb = new StringBuffer();
		
		boolean dash = false;
		for(int i = 0; i < array.length; i++) { 
			if(i < array.length - 1) {
				if(array[i + 1] == array[i] + 1) {
					if(!dash) {
						sb.append(array[i]);
						sb.append('-'); 
						dash = true;
					} else {
						continue;
					}
				} else {
					sb.append(array[i]);
					sb.append(',');
					dash = false;
				}
			} else if(i == array.length - 1) {
				sb.append(array[i]);
			}
			
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		int[] array = {1,3,4,6 ,8,9,10,11,13,15,16,17, 19,21,22, 23, 26, 27, 28, 33};
		
		System.out.println(solution(array));
		System.out.println(second_Solution(array));
	}
}
