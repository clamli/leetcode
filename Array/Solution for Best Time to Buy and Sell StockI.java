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
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

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
	public int maxProfit(int[] prices) {
//		int size = prices.length;
//		int max = 0;
//		if (size == 0) return max;
//		
//		int[] dpl = new int[size];
//		int[] dpr = new int[size];
//		dpl[0] = prices[0];
//		dpr[size-1] = prices[size-1];
//		
//		for (int i = 1; i < size; i++) {
//			dpl[i] = Math.min(dpl[i-1], prices[i]);
//			dpr[size-i-1] = Math.max(dpr[size-i], prices[size-i-1]);
//		}
//		
//		for (int i = 0; i < size; i++) {
//			if (dpr[i] - dpl[i] > max) max = dpr[i] - dpl[i];
//		}
//        return max;
        
        
        int size = prices.length;
		int max = 0, min = 0;
		if (size == 0) return max;
		
		min = prices[0];
		for (int i = 1; i < size; i++) {
			int diff = prices[i] - min;
			if (diff < 0) min = prices[i];
			else if (diff > max) max = diff;
		}
		
		
		return max;
    }
}