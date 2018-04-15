package leetcode;

import java.util.List;
import java.awt.font.GraphicAttribute;
import java.awt.font.NumericShaper;
import java.io.FilterInputStream;
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
	
//	public int threeSumSmaller(int[] nums, int target) {
//        Arrays.sort(nums);
//        return backtrack(nums, target, 0, 0, 0, 0);
//    }
//	
//	int backtrack(int[] nums, int target, int cursum, int curnum, int start, int cnt) {
//		if (curnum == 3) {
//			if (cursum < target) cnt++;
//		} else {
//			for (int i = start; i < nums.length; i++) {
//				if (cursum+nums[i] >= target && nums[i] >= 0) break;
//				cnt = backtrack(nums, target, cursum+nums[i], curnum+1, i+1, cnt);
//			}
//		}
//		return cnt;
//	}
	
	public int threeSumSmaller(int[] nums, int target) {
        int cnt = 0;
		Arrays.sort(nums);
        if (nums.length < 3) return 0;
        for (int i = 0; i < nums.length-2; i++) {
        	int begin = i + 1, end = nums.length - 1;
        	if (nums[i] + nums[i+1] + nums[i+2] >= target) {
        		break;
        	}
        	while (begin < end) {
        		if (nums[begin] + nums[end] + nums[i] < target) {
        			cnt += end-begin;
        			begin++;
        		} else {
        			end--;
        		}
        	}
        }

        return cnt;
    }
	
}
