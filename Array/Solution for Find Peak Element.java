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
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import javax.tools.ToolProvider;
import javax.xml.ws.Endpoint;

import org.omg.CORBA.Current;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.css.ElementCSSInlineStyle;

class Solution {
	public int findPeakElement(int[] nums) {
		return find(0, nums.length-1, nums);
    }
	
	private int find(int start, int end, int[] nums) {
		if (start == end) return start;
		
		int mid = (start + end) / 2, index = 0;
		if (mid-1 < 0) {
			if (nums[mid] < nums[mid+1]) {
				index = find(mid+1, end, nums);
			} else {
				return mid;
			}
		} else if (nums[mid+1] < nums[mid] && nums[mid-1] < nums[mid]) {
			return mid;
		} else if (nums[mid+1] > nums[mid] && nums[mid-1] > nums[mid]) {
			if (mid - start < mid - end) {
				index = find(start, mid-1, nums);
			} else {
				index = find(mid+1, end, nums);
			}	
		} else if (nums[mid+1] < nums[mid] && nums[mid-1] > nums[mid]) {
			index = find(start, mid-1, nums);
		} else if (nums[mid+1] > nums[mid] && nums[mid-1] < nums[mid]) {
			index = find(mid+1, end, nums);
		}
		
		return index;
	}
}