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
    // method 1
    // public int islandPerimeter(int[][] grid) {
    //     int row = grid.length;
    //     if (row == 0) return 0;
    //     int col = grid[0].length;
    //     int[][] grid_new = new int[row+2][col+2];
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < col; j++) {
    //             grid_new[i+1][j+1] = grid[i][j];
    //         }
    //     }
    //     int res = 0;
    //     for (int i = 1; i <= row; i++) {
    //         for (int j = 1; j <= col; j++) {
    //             if (grid_new[i][j] == 1)
    //                 res += 4 - (grid_new[i-1][j]+grid_new[i+1][j]+grid_new[i][j+1]+grid_new[i][j-1]);
    //         }
    //     }
    //     return res;
    // }
    
    // method 2
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        int island = 0, neighbor = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    island++;
                    if (i < row-1 && grid[i+1][j] == 1) neighbor++;
                    if (j < col-1 && grid[i][j+1] == 1) neighbor++;
                }
            }
        }
        return 4*island - 2*neighbor;
    }
}