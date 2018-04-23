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
    public int thirdMax(int[] nums) {
        // TreeSet<Integer> treeset = new TreeSet<Integer>();
        // treeset.add(nums[0]);
        // for (int i = 1; i < nums.length; i++) {
        //     if (treeset.size() < 3) {
        //         treeset.add(nums[i]);
        //     } else {
        //         if (nums[i] > treeset.first() && !treeset.contains(nums[i])) {
        //             treeset.pollFirst();
        //             treeset.add(nums[i]);
        //         }
        //     }
        // }
        // return (treeset.size() == 3) ? treeset.first() : treeset.last();
        
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int n : nums) {
            if (n == first || n == second || n == third) {
                continue;
            }
            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n > second) {
                third = second;
                second = n;
            } else if (n > third) {
                third = n;
            }
        }
        
        if (third == Long.MIN_VALUE) {
            return (int)first;
        } else {
            return (int)third;
        }
    }
}