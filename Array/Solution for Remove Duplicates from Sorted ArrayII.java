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
	
//	public int removeDuplicates(int[] nums) {
//		int cnt = 0, curnum, ind = 0;
//		if (nums.length == 0) return 0;
//		
//		curnum = nums[0];
//		ind++;
//		cnt++;
//        for (int i = 1; i < nums.length; i++) { 	
//        	if (nums[i] != curnum) {
//        		cnt = 1;
//        		curnum = nums[i];
//        		nums[ind++] = nums[i];
//        	} else if (cnt+1 <= 2) {
//        		cnt++;
//        		nums[ind++] = nums[i];
//        	}
//        }
//        
//        return ind;
//    }
	
	public int removeDuplicates(int[] nums) {
		int ind = 0;
		for (int i = 0; i < nums.length; i++) {
			if (ind < 2 || nums[ind-2] != nums[i])
				nums[ind++] = nums[i];
		}
		return ind;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}