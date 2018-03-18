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
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length, col = obstacleGrid[0].length;
		if (row == 0) return 0;
		int[][] dp = new int[row+1][col+1];
		
		dp[1][1] = 1 - obstacleGrid[0][0];
        for (int i = 1; i <= row; i++) {
        	for (int j = 1; j <= col; j++) {
        		if (i == 1 && j == 1) continue;
        		if (obstacleGrid[i-1][j-1] == 1) dp[i][j] = 0;
        		else dp[i][j] = dp[i-1][j] + dp[i][j-1];
        	}
        }
        
        return dp[row][col];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}