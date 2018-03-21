package leetcode;

import java.util.List;
import java.awt.font.GraphicAttribute;
import java.lang.reflect.Array;
import java.security.AlgorithmConstraints;
import java.text.DateFormatSymbols;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import javax.naming.SizeLimitExceededException;
import javax.naming.ldap.StartTlsRequest;
import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.tools.ToolProvider;
import javax.xml.ws.Endpoint;

import org.omg.CORBA.Current;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	
//	public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new LinkedList<>();
//        result.add(new LinkedList<>());
//        backtrack(nums, result, 0, new LinkedList<>());
//        return result;
//    }	
//	
//	public void backtrack(int[] nums, List<List<Integer>> result, int start, List<Integer> curlist) {
//		for (int i = start; i < nums.length; i++) {
//			curlist.add(nums[i]);
//			result.add(new LinkedList<>(curlist));
//			backtrack(nums, result, i+1, curlist);
//			curlist.remove(curlist.size() - 1);
//		}
//	}
	
	public List<List<Integer>> subsets(int[] nums) {

		int size = nums.length;
		int subnum = (int)Math.pow(2, size);
		
		List<List<Integer>> result = new LinkedList<>();
		
		for (int i = 0; i < subnum; i++) {
			List<Integer> list = new LinkedList<>();
			for (int j = 0; j < size; j++) {
				if (((i>>>j) & 1) == 1) {
					list.add(nums[j]);
				}
			}
			result.add(list);
		}
		
		return result;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}