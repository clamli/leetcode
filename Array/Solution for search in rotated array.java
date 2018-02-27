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
	
	public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start < end) {
        	mid = (start+end) / 2;
        	if (nums[mid] > nums[end])
        		start = mid + 1;
        	else end = mid;
        }
        
        int rotate = start;
        start = 0;
        end = nums.length - 1;
        int realmid;
        while (start <= end) {
        	mid = (start+end) / 2;
        	realmid = (mid + rotate) % nums.length;
        	if (nums[realmid] == target)
        		return realmid;
        	else if (nums[realmid] < target) start = mid + 1;
        	else if (nums[realmid] > target) end = mid - 1;
        }
        
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
