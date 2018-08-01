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
    
    int row;
    int col;
    int[][] grid;
    Set<Integer> shape;
    Set<String> shapes;
    
    public int numDistinctIslands2(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        this.grid = grid;
        shapes = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                shape = new HashSet<>();
                explore(i, j, i, j);
                if (!shape.isEmpty()) shapes.add(norm(shape));
            }
        }
        return shapes.size();
    }
    
    private void explore(int i, int j, int r0, int c0) {
        if (i >= 0 && i < row && j >= 0 && j < col && grid[i][j] != 0) {
            grid[i][j] = 0;
            shape.add(i * col + j);
            explore(i-1, j, r0, c0);
            explore(i+1, j, r0, c0);
            explore(i, j-1, r0, c0);
            explore(i, j+1, r0, c0);
        }
    }
    
    private String norm(Set<Integer> shape) {
        String max = "";
        int xs[] = new int[shape.size()], ys[] = new int[shape.size()];
        // x  x -x -x y  y -y -y
        // y -y  y -y x -x  x -x
        for (int i = 0; i < 8; i++) {
            int idx = 0;
            for (int s : shape) {
                if (i <= 1) xs[idx] = s/col;
                else if (i <= 3) xs[idx] = -s/col;
                else if (i <= 5) xs[idx] = s%col;
                else xs[idx] = -s%col;
                if (i == 0 || i == 2) ys[idx] = s%col;
                else if (i == 1 || i == 3) ys[idx] = -s%col;
                else if (i == 4 || i == 6) ys[idx] = s/col;
                else ys[idx] = -s/col;
                idx++;
            }
            String candi = combine(xs, ys);
            if (max.compareTo(candi) < 0) max = candi;
        }
        return max;
    }
    
    private String combine(int[] xs, int[] ys) {
        int r0 = xs[0], c0 = ys[0];
        for (int i = 1; i < xs.length; i++) r0 = Math.min(r0, xs[i]);
        for (int i = 1; i < ys.length; i++) c0 = Math.min(c0, ys[i]);
        int[] arr = new int[xs.length];
        for (int i = 0; i < xs.length; i++) {
            arr[i] = 2*(xs[i]-r0)*col + (ys[i]-c0);
        }
        Arrays.sort(arr);
        return Arrays.toString(arr);
    }
}