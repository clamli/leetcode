package leetcode;

import java.util.List;
import java.awt.font.GraphicAttribute;
import java.awt.font.NumericShaper;
import java.io.FilterInputStream;
import java.lang.reflect.Array;
import java.security.AlgorithmConstraints;
import java.text.DateFormatSymbols;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.logging.Logger;

import javax.naming.SizeLimitExceededException;
import javax.naming.ldap.StartTlsRequest;
import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.swing.DefaultFocusManager;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import javax.tools.ToolProvider;
import javax.xml.ws.Endpoint;

import org.omg.CORBA.Current;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.css.ElementCSSInlineStyle;

class Solution {
	public int maxAreaOfIsland(int[][] grid) {
        int nrow = grid.length;
        if (nrow == 0) return 0;
        int ncol = grid[0].length;
        int max = 0;
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                if (grid[i][j] == 0) continue;
                max = Math.max(max, dfs(grid, nrow, ncol, i, j));
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid, int nrow, int ncol, int i, int j) {
        if (i == -1 || i == nrow || j == -1 || j == ncol || grid[i][j] == 0) return 0;
        else {
            grid[i][j] = 0;
            return 1 + dfs(grid, nrow, ncol, i-1, j) + dfs(grid, nrow, ncol, i, j-1) + dfs(grid, nrow, ncol, i, j+1) + dfs(grid, nrow, ncol, i+1, j);
        }
    }
}