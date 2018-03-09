package leetcode;

import java.util.List;
import java.lang.reflect.Array;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.naming.ldap.StartTlsRequest;
import javax.naming.spi.DirStateFactory.Result;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	
	public int firstMissingPositive(int[] nums) {	
		if (nums.length == 0)
			return 1;
		
		int maxvalue = findMax(nums);
		if (maxvalue <= 0) return 1;
		
		boolean[] flag = new boolean[maxvalue+1];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) flag[nums[i]] = true;
		}
		int i;
		for (i = 1; i < flag.length; i++) {
			if (flag[i] == false)
				return i;
		}
		return i;
    }
	
	private int findMax(int[] nums) {
		int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] > max) {
        		max = nums[i];
        	}
        }
        return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
