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
	public int findShortestSubArray(int[] nums) {
        int size = nums.length, max = 0, maxstart = 0, mindist = size;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> start = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                start.put(nums[i], i);
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
            int cnt = map.get(nums[i]);
            int startind = start.get(nums[i]);
            if (cnt > max) {
                max = cnt;
                maxstart = startind;
                mindist = i - maxstart;
            } else if (cnt == max) {
                if (i - startind < mindist) {
                    maxstart = startind;
                    mindist = i - maxstart;
                }
            }
        }
        return mindist+1;
    }
}