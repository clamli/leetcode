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
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), k, n, 0, 1);
		return result;
    }
	
	private void backtrack(List<List<Integer>> result, List<Integer> ele, int k, int n, int cursum, int start) {
		if (k == 0) {
			if (cursum == n)
				result.add(ele);
			return;
		}
		if (cursum > n) return;
		for (int i = start; i <= 9; i++) {
			ele.add(i);
			cursum += i;
			backtrack(result, new ArrayList<>(ele), k-1, n, cursum, i+1);
			cursum -= i;
			ele.remove(ele.size()-1);
		}
	}
}
