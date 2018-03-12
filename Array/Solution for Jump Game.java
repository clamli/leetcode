package leetcode;

import java.util.List;
import java.lang.reflect.Array;
import java.security.AlgorithmConstraints;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import javax.naming.SizeLimitExceededException;
import javax.naming.ldap.StartTlsRequest;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.omg.CORBA.Current;
import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	
//	public int jump(int[] nums) {
//        int minstep = nums.length, end = nums.length - 1;
//		minstep = jumpiter(nums, 0, minstep, 0, end);
//		return minstep;
//    }
//	
//	public int jumpiter(int[] nums, int start, int minstep, int curstep, int end) {
//		if (curstep < minstep) {
//			
//			if (start == end) {
//				minstep = curstep;
//			} else if (nums[start] != 0 && start < end) {
//				for (int i = 1; i <= nums[start]; i++) {
//					if (start+i > end) break;
//					minstep = jumpiter(nums, start+i, minstep, curstep+1, end);
//				}
//			}
//		}
//
//		return minstep;
//	}
	
	public int jump(int[] nums) {
		if (nums.length < 2) return 0;
		int currentMax = 0, nextMax = 0, i = 0, level = 0, size = nums.length;
		
		while (currentMax-i+1 > 0) {
			level++;
			for (; i <= currentMax; i++) {
				nextMax = max(nextMax, nums[i]+i);
				if (nextMax >= size - 1) return level;
			}
			currentMax = nextMax;
		}
		
		return -1;
		
	}
	
	private int max(int a, int b) {
		if (a > b) return a;
		else return b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}