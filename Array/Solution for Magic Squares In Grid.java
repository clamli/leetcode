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
    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicS(i, j, grid)) ans++;
            }
        }
        return ans;
    }
    private boolean isMagicS(int x, int y, int[][] grid) {
        if (x + 2 >= grid.length || y + 2 >= grid[0].length) return false;
        int[] row = new int[3], col = new int[3], diag = new int[2];
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (grid[x+i][y+j] > 9 || grid[x+i][y+j] < 1) return false;
                row[i] += grid[x+i][y+j];
                col[j] += grid[x+i][y+j];
                if (i == j) diag[0] += grid[x+i][y+j];
                if (i + j == 2) diag[1] += grid[x+i][y+j];
            }
        }
        if (row[0] == row[1] && row[1] == row[2] && row[2] == col[0] && col[0] == col[1] && col[1] == col[2] && col[2] == diag[0] && diag[0] == diag[1]) 
            return true;
        return false;
    }
}