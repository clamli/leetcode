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
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    public boolean solve(char[][] board, int sr) {
        for (int i = sr; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int t = 1; t <= 9; t++) {
                        char num = (char)(t + '0');
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (solve(board, i)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char num) {
        // row & col
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == num) return false;
            if (i != row && board[i][col] == num) return false;
        }
        // block
        int srow = (row/3)*3, scol = (col/3)*3;
        for (int i = srow; i < srow+3; i++) {
            for (int j = scol; j < scol+3; j++) {
                if (!(i == row && j == col) && board[i][j] == num) return false;
            }
        }
        return true;
    }
}