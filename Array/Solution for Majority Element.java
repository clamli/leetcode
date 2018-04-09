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
//	public int majorityElement(int[] nums) {
//		HashMap<Integer, Integer> map = new HashMap<>();
//		int majority = nums.length / 2, result = 0, origin, cnt;
//		for (int i = 0; i < nums.length; i++) {
//			origin = (map.containsKey(nums[i])) ? map.get(nums[i]) : 0;
//			cnt = origin + 1;
//			if (cnt > majority) {
//				result = nums[i];
//				break;
//			}
//			map.put(nums[i], cnt);
//		}
//		return result;
//    }
	
	public int majorityElement(int[] nums) {
		int count = 1, majority = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				majority = nums[i];
				count = 1;
			} else if (nums[i] == majority) {
				count++;
			} else {
				count--;
			}
		}
		return majority;
    }
}
