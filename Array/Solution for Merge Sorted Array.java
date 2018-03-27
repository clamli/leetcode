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

public class Solution {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = m + n;
        int index1 = m - 1, index2 = n - 1;
        for (int i = size - 1; i >= 0; i--) {
        	if (index1 < 0) nums1[i] = nums2[index2--];
        	else if (index2 < 0) nums1[i] = nums1[index1--];
        	else nums1[i] = (nums1[index1] > nums2[index2]) ? nums1[index1--] : nums2[index2--];
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}