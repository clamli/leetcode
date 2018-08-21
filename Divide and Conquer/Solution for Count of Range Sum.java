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

class Solution {
    // method 1: dp O(N^2)
    // public int countRangeSum(int[] nums, int lower, int upper) {
    //     long[] dp = new long[nums.length+1];
    //     for (int i = 1; i <= nums.length; i++) {
    //         dp[i] = dp[i-1] + nums[i-1];
    //     }
    //     int count = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i; j < nums.length; j++) {
    //             long sum = dp[j+1] - dp[i];
    //             if (sum >= lower && sum <= upper) count++;
    //         }
    //     }
    //     return count;
    // }
    
    // method 2: java mergesort solution
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] dp = new long[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }
        return mergeAndSort(dp, 0, nums.length+1, lower, upper);
    }
    
    private int mergeAndSort(long[] dp, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = mergeAndSort(dp, start, mid, lower, upper) + mergeAndSort(dp, mid, end, lower, upper);
        int j = mid, k = mid, t = mid, r = 0;
        long[] cache = new long[end-start];
        for (int i = start; i < mid; i++) {
            while (j < end && dp[j] - dp[i] < lower) j++;
            while (k < end && dp[k] - dp[i] <= upper) k++;
            count += k - j;
            while (t < end && dp[t] < dp[i]) cache[r++] = dp[t++];
            cache[r++] = dp[i];
        }
        System.arraycopy(cache, 0, dp, start, t - start);
        return count;
    }
}