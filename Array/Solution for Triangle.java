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
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

import javax.naming.SizeLimitExceededException;
import javax.naming.ldap.StartTlsRequest;
import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import javax.tools.ToolProvider;
import javax.xml.ws.Endpoint;

import org.omg.CORBA.Current;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.css.ElementCSSInlineStyle;

class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] minsum = new int[triangle.size()];
		for (int i = 0; i < triangle.get(triangle.size()-1).size(); i++) {
			minsum[i] = triangle.get(triangle.size()-1).get(i);
		}	
		
		for (int i = triangle.size()-2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				minsum[j] = Math.min(minsum[j], minsum[j+1]) + triangle.get(i).get(j);
			}
		}
		
		return minsum[0];
    }
}