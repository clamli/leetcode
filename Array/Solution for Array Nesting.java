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
	public int arrayNesting(int[] nums) {
        if (nums.length == 0)
            return 0;   
        HashSet<Integer> set = new HashSet<Integer>();
        for (Integer i : nums) {
            set.add(i);
        }
        int maxcount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                int turtle = i, hare = i;
                do {
                    turtle = nums[turtle];
                    hare = nums[nums[hare]];
                } while (nums[turtle] != nums[nums[hare]]);
                int start1 = i, start2 = nums[turtle];
                while (start1 != start2) {
                    start1 = nums[start1];
                    start2 = nums[start2];
                }
                int count = 0, start = start1;
                do {
                    count++;
                    start = nums[start];
                    set.remove(start);
                } while (start != start1);
                maxcount = Math.max(count, maxcount);
            } 
        }
        return maxcount;
    }
}