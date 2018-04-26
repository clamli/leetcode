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
	public int findPairs(int[] nums, int k) {
        int count = 0, start = 0, end = 1;
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        while (end < nums.length) {
            if (nums[end] - nums[start] == k) {
                count++;
                do {
                    start++;
                } while (start < nums.length && nums[start] == nums[start-1]);
                do {
                    end++;
                } while (end < nums.length && nums[end] == nums[end-1]);
                if (end == start) end++;
            } else if (nums[end] - nums[start] > k) {
                start++;
                if (end == start) end++;
            } else if (nums[end] - nums[start] < k) {
                end++;
            }
        }
        return count;
        
        // if (nums.length < 2 || k < 0) return 0;
        // int count = 0;
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if (k == 0) {
        //         if (entry.getValue() >= 2)
        //             count++;
        //     } else {
        //         if (map.containsKey(entry.getKey()+k))
        //             count++;
        //     }
        // }
        // return count;
    }
}