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
	//     public int triangleNumber(int[] nums) {
//         Arrays.sort(nums);
//         int start = 0;
//         while (start < nums.length && nums[start] == 0) start++;
//         if (nums.length - start < 3) return 0;
//         return makeTriangle(nums, new ArrayList<Integer>(), start, 0);
//     }
    
//     int makeTriangle(int[] nums, List<Integer> triangle, int start, int count) {
//         if (triangle.size() == 3) {
//             if (triangle.get(0) + triangle.get(1) > triangle.get(2)) return count+1;
//             else return count;
//         }
//         for (int i = start; i < nums.length; i++) {
//             triangle.add(nums[i]);
//             int tmpcnt = makeTriangle(nums, new ArrayList<Integer>(triangle), i+1, count);
//             if (tmpcnt == count && triangle.size() == 3) return count;
//             count = tmpcnt;
//             triangle.remove(triangle.size()-1);
//         }
//         return count;
//     }
    
    
//     public int triangleNumber(int[] nums) {
//         Arrays.sort(nums);
//         int start = 0;
//         while (start < nums.length && nums[start] == 0) start++;
//         int count = 0;
//         for (int i = start; i < nums.length-2; i++) {
//             int k = i + 2;
//             for (int j = i+1; j < nums.length-1; j++) {
//                 k = findK(nums, k, nums.length-1, nums[i] + nums[j]);
//                 count += k - j;
//             }
//         }
//         return count;
//     }
    
//     private int findK(int[] nums, int lo, int hi, int sum) {
//         while (lo <= hi) {
//             int mid = (lo + hi)/2;
//             if (nums[mid] < sum) {
//                 lo = mid + 1;
//             } else {
//                 hi = mid - 1;
//             }
//         }
//         return hi;
//     }
    
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        while (start < nums.length && nums[start] == 0) start++;
        int count = 0;
        for (int i = start; i < nums.length-2; i++) {
            int k = i + 2;
            for (int j = i+1; j < nums.length-1; j++) {
                while (k < nums.length && nums[i]+nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }
}