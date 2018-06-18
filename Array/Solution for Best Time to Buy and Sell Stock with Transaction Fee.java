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
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
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
	// method 1
    public int maxProfit(int[] prices, int fee) {
        int start = 0, end = 0, profit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[end] - prices[i+1] > fee) {
                profit += Math.max(prices[end] - prices[start] - fee, 0);  
                start = i+1;
                end = start;
            } else if (prices[start] > prices[i+1]) {
                start = i+1;
                end = start;
            } else if (prices[end] < prices[i+1]) {
                end = i+1;
            }
        }
        if (start != prices.length - 1) {
            profit += Math.max(prices[end] - prices[start] - fee, 0);
        }
        return profit;
    }
    
    // method 2
    // public int maxProfit(int[] prices, int fee) {
    //     int cash = 0, hold = -prices[0];
    //     for (int i = 1; i < prices.length; i++) {
    //         cash = Math.max(cash, hold + prices[i] - fee);
    //         hold = Math.max(hold, cash - prices[i]);
    //     }
    //     return cash;
    // }
}