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
	
	private int extremeInsertionIndex(int[] nums, int target, boolean left) {
		int lo = 0, hi = nums.length;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (target < nums[mid] || (left && nums[mid] == target)) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}
	
	public int[] searchRange(int[] nums, int target) {
		int[] index = {-1, -1};
		
        int leftIndex = extremeInsertionIndex(nums, target, true);
        
        if ( leftIndex == nums.length || nums[leftIndex] != target) {
        	return index;
        } else {
        	index[0] = leftIndex;
        	index[1] = extremeInsertionIndex(nums, target, false) - 1;
        	return index;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
