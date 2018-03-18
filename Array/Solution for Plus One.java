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
	
	public int[] plusOne(int[] digits) {
		int n = digits.length;
		
        for (int i = n - 1; i >= 0; i--) {
        	if (digits[i] != 9) {
        		digits[i]++; 
        		return digits;
        	}
        	
        	digits[i] = 0;
        }
        
        int[] result = new int[n+1];
        result[0] = 1;
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}