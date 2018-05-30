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

class RangeModule {
    
    public int smallestDistancePair(int[] nums, int k) {
        // method 1 O(N + N*log(N) + W+N + N*log(W))
        // Arrays.sort(nums);
        // int size = nums.length;
        // int[] multiplicity = new int[size];
        // for (int i = 1; i < size; i++) {
        //     if (nums[i] == nums[i-1]) {
        //         multiplicity[i] = multiplicity[i-1] + 1;
        //     }
        // }
        // int left = 0, WIDTH = 2*nums[size-1];
        // int[] prefix = new int[WIDTH];
        // for (int i = 0; i < WIDTH; i++) {
        //     while (left < size && nums[left] == i) left++;
        //     prefix[i] = left;
        // }
        // int lo = 0, hi = nums[size-1] - nums[0];
        // while (lo < hi) {
        //     int mid = (lo + hi) / 2;
        //     int count = 0;
        //     for (int i = 0; i < size; i++) {
        //         count += prefix[nums[i]+mid] - prefix[nums[i]] + multiplicity[i];
        //     }
        //     if (count >= k) {
        //         hi = mid;
        //     } else {
        //         lo = mid + 1;
        //     }
        // }
        // return hi;
        
        
        // method 2  O(N*log(W) + N*log(N))
        Arrays.sort(nums);
        int size = nums.length, lo = 0, hi = nums[size-1] - nums[0];
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int right = 1, count = 0;
            for (int left = 0; left < size-1; left++) {
                while (right < size && nums[right] - nums[left] <= mid) {
                    right++;
                }
                count += right - left - 1;
            }
            if (count >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}