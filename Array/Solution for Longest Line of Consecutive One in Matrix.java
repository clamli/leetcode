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
	public boolean splitArray(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];
        for (int i = 1; i < size; i++) {
            dp[i] = dp[i-1] + nums[i];
        }
        
        for (int j = 1; j < size-3; j++) {
            if (testPart(nums, dp, j, size)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean testPart(int[] nums, int[] dp, int mid, int size) {
        // i < mid-1
        HashSet<Integer> mid1 = new HashSet<Integer>();
        for (int i = 1; i < mid-1; i++) {
            if (dp[i-1]*2 + nums[i] == dp[mid-1]) {
                mid1.add(dp[i-1]);
            }
        }
        if (mid1.size() == 0)
            return false;
        
        // k < size - 1
        HashSet<Integer> mid2 = new HashSet<Integer>();
        for (int k = mid+2; k < size-1; k++) {
            if ((dp[k-1]-dp[mid])*2 + nums[k] == dp[size-1] - dp[mid]) {
                mid2.add(dp[k-1]-dp[mid]);
            }
        }
        if (mid2.size() == 0)
            return false;
        
        for (Integer integer : mid1) {
        	if (mid2.contains(integer))
        		return true;
        }
        
        return false;
    }
}