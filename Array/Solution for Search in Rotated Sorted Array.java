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
	
	public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        if (hi == -1) return false;
        
        while (lo < hi) {
        	int mid = (lo + hi) / 2;
        	if (nums[mid] == target) return true;
        	if (nums[mid] > nums[hi]) {
        		if (target < nums[mid] && target >= nums[lo]) hi = mid - 1;
        		else lo = mid + 1;
        	} else if (nums[mid] < nums[hi]) {
        		if (target <= nums[hi] && target > nums[mid]) lo = mid + 1;
        		else hi = mid - 1;
        	} else {
        		hi--;
        	}
        }
        
        return (nums[lo] == target);
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}