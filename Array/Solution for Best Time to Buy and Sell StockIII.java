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
		
		int size = prices.length;
		if (size == 0) return 0;
		
		int[] dpl = new int[size];
		int[] dpr = new int[size];
		
		dpl[0] = 0;
		int min = prices[0];
		for (int i = 1; i < size; i++) {
			if (prices[i] < prices[i-1]) {
				if (prices[i] < min) min = prices[i];
				dpl[i] = dpl[i-1];
			} else {
				dpl[i] = Math.max(prices[i]-min, dpl[i-1]);
			}
		}
		dpr[size-1] = 0;
		int max = prices[size-1];
		for (int i = size - 2; i >= 0; i--) {
			if (prices[i] > prices[i+1]) {
				if (prices[i] > max) max = prices[i];
				dpr[i] = dpr[i+1];
			} else {
				dpr[i] = Math.max(dpr[i+1], max-prices[i]);
			}
		}
        
        int money = 0;
        int partmax;
        for (int i = 0; i < size; i++) {
        	partmax = dpr[i]+dpl[i];
        	if (partmax > money) money = partmax;
        }
        return money;
    }
}