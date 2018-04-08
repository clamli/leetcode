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
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
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
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long diff;
		String string = new String("->");
        List<String> result = new LinkedList<>();
        if (nums.length == 0) {
        	if ((long)upper - (long)lower == 0) {
        		result.add(Integer.toString(lower));
        	} else {
        		result.add(Integer.toString(lower) + string + Integer.toString(upper));
        	}
        	return result;
        }
        
        diff = (long)(nums[0]) - (long)(lower);
        if (diff == 1) {
        	result.add(Integer.toString(lower));
        } else if (diff > 1) {
        	result.add(Integer.toString(lower)+string+Integer.toString(nums[0]-1));
        }
        for (int i = 1; i < nums.length; i++) {
        	diff = (long)(nums[i]) - (long)(nums[i-1]);
        	if (diff == 2) {
        		result.add(Integer.toString(nums[i-1]+1));
        	} else if (diff > 2) {
        		result.add(Integer.toString(nums[i-1]+1)+string+Integer.toString(nums[i]-1));
        	}
        }
        diff = (long)(upper) - (long)(nums[nums.length-1]);
        if (diff == 1) {
        	result.add(Integer.toString(upper));
        } else if (diff > 1) {
        	result.add(Integer.toString(nums[nums.length-1]+1)+string+Integer.toString(upper));
        }
        
        return result;
    }
}
