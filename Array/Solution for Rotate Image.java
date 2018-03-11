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
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.omg.CORBA.Current;
import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	public void rotate(int[][] matrix) {
		int size = matrix.length;
		for (int i = 0; i < size/2; i++) {
			for (int j = 0; j < size; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[size-i-1][j];
				matrix[size-i-1][j] = tmp;
			}
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}