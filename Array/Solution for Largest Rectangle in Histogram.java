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
	
//	public int largestRectangleArea(int[] heights) {
//		int maxarea = 0;
//        for (int i = 0; i < heights.length; i++) {
//        	int minheight = heights[i];
//        	int maxpartarea = heights[i];
//        	for (int j = i-1; j >= 0; j--) {
//        		minheight = Math.min(minheight, heights[j]);
//        		int curarea = minheight * (i - j + 1);
//        		if (curarea > maxpartarea) maxpartarea = curarea;
//        	}
//        	maxarea = Math.max(maxarea, maxpartarea);
//        }
//        
//        return maxarea;
//    }
	
	public int largestRectangleArea(int[] heights) {
		int index = 0, maxarea = 0;
		Stack<Integer> S_h = new Stack<>();
		Stack<Integer> S_p = new Stack<>();
		if (heights.length == 0) return 0;
		
		S_h.push(heights[0]);
		S_p.push(0);
		index++;
		while (!S_h.isEmpty()) {
			if (index == heights.length) {
				maxarea = Math.max(maxarea, S_h.pop() * (index - S_p.pop()));
			} else {
				if (heights[index] > S_h.peek()) {
					S_h.push(heights[index]);
					S_p.push(index);
				} else if (heights[index] < S_h.peek()) {
					maxarea = Math.max(maxarea, S_h.pop() * (index - S_p.peek()));
					if (S_h.isEmpty() || heights[index] > S_h.peek()) {
						S_h.push(heights[index]);
					} else if (heights[index] == S_h.peek()) {
				    	S_p.pop();
				    } else if (heights[index] < S_h.peek()) {
				    	index--;
				    	S_p.pop();
				    }
				}
				index++;
			}
		}
		
		return maxarea;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}