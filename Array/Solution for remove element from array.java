package leetcode;

import java.util.List;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;
		
		int len = 0;
        for (int i = 0; i < nums.length; i++) {
        	len++;
        	nums[len-1] = nums[i];
    		while (i < nums.length-1 && nums[i+1] == nums[i]) {
        		i++;
        	}
        }
        return len;
    }
	
	
	public int removeElement(int[] nums, int val) {
		if (nums.length == 0) return 0;
		
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			while (i < nums.length && nums[i] == val) {
				i++;
			}
			if (i == nums.length) break;
			len++;
			nums[len-1] = nums[i];
		}
		return len;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
