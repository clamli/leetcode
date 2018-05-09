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
	// public double findMaxAverage(int[] nums, int k) {
    //     double maxavg = 0;
    //     int length = nums.length;
    //     int[] dp = new int[length];
    //     dp[0] = nums[0];
    //     for (int i = 1; i < length; i++) {
    //         dp[i] = dp[i-1] + nums[i];
    //     }
    //     for (int i = k; i <= length; i++) {
    //         int maxsum = Integer.MIN_VALUE;
    //         for (int j = 0; j <= length-i; j++) {
    //             maxsum = Math.max(maxsum, dp[j+i-1] - dp[j] + nums[j]);
    //         }
    //         if (i == k || (maxsum*1.0)/i > maxavg) {
    //             maxavg = (maxsum*1.0)/i;
    //         }
    //     }
    //     return maxavg;
    // }
    
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        double error = Integer.MAX_VALUE, mid = (max+min) * 0.5, prev_mid;
        while (error > 1e-5) {
            if (check(nums, mid, k)) {
                min = mid;
            } else {
                max = mid;
            }
            prev_mid = mid;
            mid = (max+min) * 0.5;
            error = Math.abs(prev_mid - mid);
        }
        return mid;
    }
    
    boolean check(int[] nums, double mid, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - mid;
        }
        if (sum > 0) return true;
        double prev_sum = 0, min_prev_sum = 0;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prev_sum += nums[i-k] - mid;
            min_prev_sum = Math.min(min_prev_sum, prev_sum);
            if (sum > min_prev_sum) return true;
        }
        return false;
    }
}