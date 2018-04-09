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
//	public int[] twoSum(int[] numbers, int target) {
//		int remain, hi, lo;
//		int[] result = new int[2];
//		boolean flag = false;
//		for (int i = 0; i < numbers.length-1; i++) {
//			remain = target - numbers[i];
//			result[0] = i + 1;
//			lo = i + 1;
//			hi = numbers.length - 1;
//			while(lo <= hi) {
//				int mid = (hi + lo) / 2;
//				if (numbers[mid] == remain) {
//					flag = true;
//					result[1] = mid + 1;
//					break;
//				} else if (numbers[mid] > remain) {
//					hi = mid - 1;
//				} else if (numbers[mid] < remain) {
//					lo = mid + 1;
//				}
//			}
//			if (flag) return result;
//		}
//		return result;
//    }
	
	public int[] twoSum(int[] numbers, int target) {
		int lo = 0, hi = numbers.length - 1;
		int[] result = new int[2];
		while (lo < hi) {
			if (numbers[lo] + numbers[hi] == target) {
				result[0] = lo + 1;
				result[1] = hi + 1;
				break;
			} else if (numbers[lo] + numbers[hi] > target) {
				hi--;
			} else if (numbers[lo] + numbers[hi] < target) {
				lo++;
			}
		}
		return result;
    }
}
