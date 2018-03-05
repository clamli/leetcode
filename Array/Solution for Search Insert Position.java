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
	
	public int searchInsert(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
        	int mid = (lo + hi) / 2;
        	if (nums[mid] == target) {
        		return mid;
        	} else if (nums[mid] > target) {
        		hi = mid - 1;
        	} else {
        		lo = mid + 1;
        	}
        }
        return lo;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
