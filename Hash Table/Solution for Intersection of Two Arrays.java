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
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1_set = new HashSet<>();
        Set<Integer> nums2_set = new HashSet<>();
        for (int num : nums1) {
            nums1_set.add(num);
        }
        for (int num : nums2) {
            nums2_set.add(num);
        }
        Set<Integer> res = new HashSet<>();
        for (int num : nums1_set) {
            if (nums2_set.contains(num)) res.add(num);
        }
        int[] res_arr = new int[res.size()];
        int idx = 0;
        for (int num : res) {
            res_arr[idx++] = num;
        }
        return res_arr;
    }
}