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
	
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	int complement = target - nums[i];
        	if (map.containsKey(complement)) {
        		return new int[] {map.get(complement), i};
        	}
        	map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
	
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
        	if (i == 0 || nums[i-1] != nums[i]) {
        		int sum = 0 - nums[i];
        		int left = i + 1;
        		int right = nums.length - 1;
        		while (left < right) {
        			if (nums[left] + nums[right] == sum) {
        				result.add(Arrays.asList(nums[i], nums[left], nums[right]));
        				while (left < right && nums[left] == nums[left+1]) left++;
        				while (left < right && nums[right] == nums[right-1]) right--;
        				left++;
        				right--;
        			} else if (nums[left] + nums[right] < sum) {
        				left++;
        			} else {
        				right--;
        			}
        		}
        	}
        }
        
        return result;
    }
	
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
        	if (i == 0 || nums[i-1] != nums[i]) {
        		for (int j = i + 1; j < nums.length - 2; j++) {
        			if (j == i + 1 || nums[j-1] != nums[j]) {
        				int left = j + 1;
                		int right = nums.length - 1;
                		while (left < right) {
                			if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                				result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                				while (left < right && nums[left] == nums[left+1]) left++;
                				while (left < right && nums[right] == nums[right-1]) right--;
                				left++;
                				right--;
                			} else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                				left++;
                			} else {
                				right--;
                			}
                		}
        			}
            	}
        	}
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
