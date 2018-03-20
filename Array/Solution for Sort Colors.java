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
	
	public void sortColors(int[] nums) {
//  method 1
//		int p1 = 0, p2 = nums.length - 1, index = 0;
//		
//	    while (index <= p2) {
//	    	if (nums[index] == 0) {
//	    		nums[index] = nums[p1];
//	    		nums[p1] = 0;
//	    		p1++;
//	    	} else if (nums[index] == 2) {
//	    		nums[index] = nums[p2];
//	    		nums[p2] = 2;
//	    		p2--;
//	    		index--;
//	    	}
//	    	index++;
//	    }
		
		//method2
		int size = nums.length;
		int ind0 = 0, ind1 = 0, ind2 = 0;
		
		for (int i = 0; i < size; i++) {
			if (nums[i] == 0) {
				nums[ind2++] = 2;
				nums[ind1++] = 1;
				nums[ind0++] = 0;
			} else if (nums[i] == 1) {
				nums[ind2++] = 2;
				nums[ind1++] = 1;
			} else if (nums[i] == 2) {
				nums[ind2++] = 2;
			}
		}
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}