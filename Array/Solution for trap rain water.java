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
	/* Brute force */
//	public int trap(int[] height) {
//		int size = height.length, rain = 0;
//        for (int i = 1; i < size - 1; i++) {
//        	int leftmax = -1, rightmax = -1;
//        	for (int j = i; j >= 0; j--) {
//        		leftmax = max(leftmax, height[j]);
//        	} 
//        	for (int j = i; j < size; j++) {
//        		rightmax = max(rightmax, height[j]);
//        	}
//        	rain += min(leftmax, rightmax) - height[i];
//        }
//        return rain;
//    }
	
	/* Brute force */
	
	/* Dynamic Programming */
//	public int trap(int[] height) {		
//		int size = height.length, rain = 0;
//		if (size == 0) return 0;
//		int[] leftmax = new int[size], rightmax = new int[size];
//		leftmax[0] = height[0];
//		rightmax[size-1] = height[size-1];
//		for (int i = 1; i < size; i++) {
//			leftmax[i] = max(height[i], leftmax[i-1]);
//		}
//		for (int i = size-2; i >= 0; i--) {
//			rightmax[i] = max(rightmax[i+1], height[i]);
//		}
//		for (int i = 0; i < size; i++) {
//			rain += min(leftmax[i], rightmax[i]) - height[i];
//		}
//		return rain;
//	}
	/* Dynamic Programming */
	
	/* By Stack*/
//	public int trap(int[] height) {
//		int size = height.length, current = 0, rain = 0;
//		Stack<Integer> S = new Stack<>();
//		while (current < size) {
//			while (!S.empty() && height[current] > height[S.peek()]) {
//				int top = S.pop();
//				if (S.empty()) break;
//				int minval = min(height[S.peek()], height[current]);
//				int distance = current - S.peek() - 1;
//				rain += distance * (minval - height[top]);
//			}
//			S.push(current++);
//		}
//		return rain;
//	}
	/* By Stack*/
	
	
	/* Two Pointers*/
	public int trap(int[] height) {
		int rain = 0;
		int left = 0, right = height.length - 1;
		int leftmax = -1, rightmax = -1;
		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] >= leftmax) {
					leftmax = height[left];
				} else {
					rain += leftmax - height[left];
				}
				left++;
			} else {
				if (height[right] >= rightmax) {
					rightmax = height[right]; 
				} else {
					rain += rightmax - height[right];
				}
				right--;
			}
		}
		return rain;
	}
	/* Two Pointers*/
	
	private int max(int a, int b) {
		if (a >= b) return a;
		else return b;
	}
	
	private int min(int a, int b) {
		if (a >= b) return b;
		else return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
