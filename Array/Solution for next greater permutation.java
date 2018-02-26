package leetcode;

import java.util.List;
import java.lang.reflect.Array;
import java.time.format.ResolverStyle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	
	public void nextPermutation(int[] nums) {
		int i = nums.length - 1;
        while (i != 0 && nums[i] <= nums[i-1]) i--;
        if (i != 0) swap(i-1, nums);
        reversePermutation(i, nums);
    }
	
	private void reversePermutation(int index, int[] nums) {
		for (int i=index, j=nums.length-1; i<j; i++, j--) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
	}
	
	private void swap(int index, int[] nums) {
		int i;
		for (i = nums.length - 1; i > index; i--) {
			if (nums[i] > nums[index]) break;
		}
		// return value in the position of i and index
		int tmp = nums[i];
		nums[i] = nums[index];
		nums[index] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
