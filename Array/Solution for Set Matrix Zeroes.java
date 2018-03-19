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
	
	public void setZeroes(int[][] matrix) {
		int row = matrix.length, col = matrix[0].length;
		boolean col0 = false;
		
        for (int i = 0; i < row; i++) {
        	if (matrix[i][0] == 0) col0 = true;
        	for (int j = 1; j < col; j++) {
        		if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
        	}
        }
        
        
        for (int i = row - 1; i >= 0; i--) {
        	for (int j = col - 1; j >= 1; j--) {
        		if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
        	}
        	if (col0 == true) matrix[i][0] = 0;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}