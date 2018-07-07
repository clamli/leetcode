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
    public int maxSubArrayLen(int[] nums, int k) {
        // method 1     O(N^2)
        // boolean flag = false;
        // int size = nums.length, len = 0;
        // int[] dp = new int[size+1];
        // for (int i = 1; i <= size; i++) {
        //     dp[i] = dp[i-1] + nums[i-1];
        // }
        // for (int i = 0; i < size; i++) {
        //     for (int j = size; j > i; j--) {
        //         if (dp[j] - dp[i] == k) {
        //             len = Math.max(len, j - i);
        //             break;
        //         }
        //     }
        // }
        // return len;
        
        // method 2     O(N)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.putIfAbsent(sum, i);
            int key = sum - k;
            if (map.containsKey(key) && len < i - map.get(key)) {
                len = i - map.get(key);
            }
        }
        return len;
    }
}