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
	
	public int minPathSum(int[][] grid) {
		if (grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        
        int[][] dp = new int[row+1][col+1];
        dp[1][1] = grid[0][0];
        
        for (int i = 1; i <= row; i++) {
        	for (int j = 1; j <= col; j++) {
        		if (i - 1 == 0) {
        			dp[i][j] = dp[i][j-1] + grid[i-1][j-1];
        		} else if (j - 1 == 0) {
        			dp[i][j] = dp[i-1][j] + grid[i-1][j-1];
        		} else {
        			dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i-1][j-1];
        		}
        	}
        }
        
        return dp[row][col];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}