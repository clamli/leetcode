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
	
	public int maxSubArray(int[] nums) {
		int maxsum = nums[0], sum = nums[0];
		if (nums.length == 0) return 0;
		
		for (int i = 1; i < nums.length; i++) {
			if (sum < 0) sum = nums[i];
			else sum += nums[i];
			if (sum > maxsum) maxsum = sum;
		}
		
		return maxsum;
    }
	
	
//	public int maxSubArray(int[] nums) {
//		int size = nums.length;
//		int[] dp = new int[size];
//		dp[0] = nums[0];
//		int maxsum = dp[0];
//		for (int i = 1; i < size; i++) {
//			dp[i] = dp[i-1] > 0 ? (dp[i-1]+nums[i]) : nums[i];
//			if (dp[i] > maxsum) maxsum = dp[i];
//		}
//		
//		return maxsum;
//		
//	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}