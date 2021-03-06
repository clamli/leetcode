package leetcode;

import java.util.List;
import java.awt.font.GraphicAttribute;
import java.awt.font.NumericShaper;
import java.lang.reflect.Array;
import java.security.AlgorithmConstraints;
import java.text.DateFormatSymbols;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Logger;

import javax.naming.SizeLimitExceededException;
import javax.naming.ldap.StartTlsRequest;
import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.swing.DefaultFocusManager;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import javax.tools.ToolProvider;
import javax.xml.ws.Endpoint;

import org.omg.CORBA.Current;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.css.ElementCSSInlineStyle;

class Solution {
	
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums.length == 0) return result;
        int count1 = 0, count2 = 0, num1 = nums[0], num2 = nums[0];
        
		for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == num1) {
        		count1++;
        	} else if (nums[i] == num2) {
        		count2++;
        	} else if (count1 == 0) {
        		num1 = nums[i];
        		count1 = 1;
        	} else if (count2 == 0) {
        		num2 = nums[i];
        		count2 = 1;
        	} else {
        		count1--;
        		count2--;
        	}
        }
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num1) count1++;
			else if (nums[i] == num2) count2++;
		}
		if (count1 > (int)(nums.length/3))
			result.add(num1);
		if (count2 > (int)(nums.length/3))
			result.add(num2);
		
		return result;
    }
}
