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
//	public List<String> summaryRanges(int[] nums) {
//        String string = new String("->");
//        List<String> result = new ArrayList<>();
//        
//        if (nums.length == 0) return result;
//        
//        int start = 0, curnum = nums[0], size = nums.length;
//        for (int i = 1; i < size; i++) {
//        	if ((long)nums[i] - (long)curnum > 1) {
//        		if (i - start > 1) {
//        			result.add(Integer.toString(nums[start])+string+Integer.toString(nums[i-1]));
//        		} else {
//        			result.add(Integer.toString(nums[start]));
//        		}
//        		start = i;
//        	} 
//        	curnum = nums[i];
//        }
//        if (size - 1 - start >= 1) {
//        	result.add(Integer.toString(nums[start])+string+Integer.toString(nums[size-1]));
//        } else {
//        	result.add(Integer.toString(nums[start]));
//        }
//        return result;
//    }
	
	
	public List<String> summaryRanges(int[] nums) {
        String string = new String("->");
        List<String> result = new ArrayList<>();
        int size = nums.length;
        
        if (nums.length == 0) return result;
        
        for (int i = 0; i < size; i++) {
        	int start = i;
        	while (i < size-1 && nums[i+1] - nums[i] == 1) i++;
        	if (i - start >= 1) {
        		result.add(Integer.toString(nums[start])+string+Integer.toString(nums[i]));
        	} else {
        		result.add(Integer.toString(nums[start]));
        	}
        }
        
        return result;
    }
}
