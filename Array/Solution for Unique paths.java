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
	
//	public int uniquePaths(int m, int n) {
//       int endr = m-1, endc = n-1;
//       
//       int paths = traversePaths(0, 0, endr, endc);
//       
//       return paths;
//    }
//	
//	public int traversePaths(int r, int c, int endr, int endc) { 
//		if (r == endr && c == endc) return 1;
//		if (r == endr) return traversePaths(r, c+1, endr, endc);
//		if (c == endc) return traversePaths(r+1, c, endr, endc);
//		else return traversePaths(r+1, c, endr, endc) + traversePaths(r, c+1, endr, endc);
//	}
	
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m+1][n+1];
		
		dp[1][1] = 1;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 && j == 1) continue;
				dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}
		
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}