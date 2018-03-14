package leetcode;

import java.util.List;
import java.lang.reflect.Array;
import java.security.AlgorithmConstraints;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import javax.naming.SizeLimitExceededException;
import javax.naming.ldap.StartTlsRequest;
import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.omg.CORBA.Current;
import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix.length == 0) return result;
		
		int rownum = matrix.length, colnum = matrix[0].length;
        int iternum = (int)Math.ceil((Math.min(rownum, colnum)/2.0));
        
        if (rownum == 1) {
        	for (int i = 0; i < colnum; i++) result.add(matrix[0][i]);
        } else if (colnum == 1) {
        	for (int i = 0; i < rownum; i++) result.add(matrix[i][0]);
        } else {
        	for (int i = 0; i < iternum; i++) {
            	output(result, matrix, i, rownum, colnum);
            }
        }

        return result;
    }
	
	private void output(List<Integer> result, int[][] matrix, int iter, int rownum, int colnum) {
		int left = iter, right = iter;
		do {
			result.add(matrix[left][right]);
			if ((colnum - iter - 1 == iter && left == rownum - iter - 1) || 
 					(rownum - iter - 1 == iter && right == colnum - iter - 1))
 				break;
			if (left == iter && right < colnum - iter - 1) right++;
			else if (left < rownum - iter - 1 && right == colnum - iter - 1) left++;
			else if (left == rownum - iter - 1 && right > iter ) right--;
			else if (left > iter && right == iter) left--;
		} while (!(left == iter && right == iter));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}