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
    
    // public int pivotIndex(int[] nums) {
    //     int size = nums.length;
    //     int[] dp = new int[size+2];
    //     for (int i = 1; i <= size; i++) {
    //         dp[i] = dp[i-1] + nums[i-1];
    //     }
    //     dp[size+1] = dp[size];
    //     for (int i = 1; i <= size; i++) {
    //         if(dp[i-1] == dp[size+1] - dp[i]) return i-1;
    //     }
    //     return -1;
    // }
    
    
    public int pivotIndex(int[] nums) {
        if (0 == nums.length) return -1;
        int sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];        
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) left += nums[i - 1];
            if (sum - left - nums[i] == left) return i;
        }
        
        return -1;
    }
}