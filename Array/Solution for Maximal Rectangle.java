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
	
	public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        
        int[] height = new int[col];
        int[] left = new int[col];
        int[] right = new int[col];
        Arrays.fill(right, col);
        
        int maxarea = 0;
        for (int i = 0; i < row; i++) {
        	int curleft = 0, curright = col;
        	
        	for (int j = 0; j < col; j++) {
        		if (matrix[i][j] == '1') {
        			height[j]++;
        			left[j] = Math.max(left[j], curleft);
        		}
        		else {
        			height[j] = 0;
        			left[j] = 0;
        			curleft = j + 1;
        		}
        	}
        	
        	for (int j = col - 1; j >= 0; j--) {
        		if (matrix[i][j] == '1') right[j] = Math.min(right[j], curright);
        		else {
        			right[j] = col;
        			curright = j;
        		}
        	}
        	
        	for (int j = 0; j < col; j++) {
        		maxarea = Math.max(maxarea, (right[j] - left[j])*height[j]);
        	}
        }
        
        return maxarea;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}