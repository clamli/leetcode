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
	public int findUnsortedSubarray(int[] nums) {
        boolean flag = false;
        if (nums.length == 0)
            return 0;
        int lbound = 0, rbound = nums.length-1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                lbound = i-1;
                flag = true;
                break;
            }
        }
        if (!flag)
            return 0;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] > nums[i+1]) {
                rbound = i+1;
                break;
            }
        }
        int max = nums[lbound], min = nums[lbound];
        for (int i = lbound+1; i <= rbound; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        for (int i = lbound-1; i >= 0; i--) {
            if (nums[i] > min)
                lbound = i;
        }
        for (int i = rbound+1; i < nums.length; i++) {
            if (nums[i] < max)
                rbound = i;
        }
        return rbound - lbound + 1;
    }
}