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
    public int numDistinctIslands(int[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        Set<Set<Integer>> shapes = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Set<Integer> shape = new HashSet<>();
                explore(i, j, i, j, grid, shape);
                if (!shape.isEmpty()) shapes.add(shape);
            }
        }
        return shapes.size();
    }
    
    private void explore(int r, int c, int r0, int c0, int[][] grid, Set<Integer> shape) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
            grid[r][c] = 0;
            shape.add(2*(r-r0)*grid[0].length+(c-c0));
            explore(r-1, c, r0, c0, grid, shape);
            explore(r+1, c, r0, c0, grid, shape);
            explore(r, c-1, r0, c0, grid, shape);
            explore(r, c+1, r0, c0, grid, shape);
        }
    }
}