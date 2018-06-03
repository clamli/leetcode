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

class Solution {
    
    public boolean isToeplitzMatrix(int[][] matrix) {
        // boolean flag = true;
        // int row = matrix.length, col = matrix[0].length;
        // boolean[][] dp = new boolean[row][col];
        // for (int i = 0; i < row; i++) dp[i][col-1] = true;
        // for (int j = 0; j < col-1; j++) dp[row-1][j] = true;
        // for (int i = row-2; i >= 0; i--) {
        //     for (int j = col-2; j >= 0; j--) {
        //         dp[i][j] = dp[i+1][j+1] && (matrix[i+1][j+1] == matrix[i][j]);
        //     }
        // }
        // for (int i = 0; i < row; i++) flag = flag && dp[i][0];
        // for (int j = 1; j < col; j++) flag = flag && dp[0][j];
        // return flag;
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i-1][j-1])
                    return false;
            }
        }
        return true;
    }
    
}