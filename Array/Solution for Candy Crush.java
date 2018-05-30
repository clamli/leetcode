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
    public int[][] candyCrush(int[][] board) {
        int row = board.length, col = board[0].length;
        
        while (true) {
            boolean flag1 = true, flag2 = true;
            int[][] dpr = new int[row][col];
            int[][] dpc = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (board[i][j] != 0 && board[i][j] == board[i][j-1])
                        dpr[i][j] = dpr[i][j-1] + 1;
                }
            }
            for (int j = 0; j < col; j++) {
                for (int i = 1; i < row; i++) {
                    if (board[i][j] != 0 && board[i][j] == board[i-1][j])
                        dpc[i][j] = dpc[i-1][j] + 1;
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = col-1; j >= 0; j--) {
                    if (dpr[i][j] >= 2) {
                        flag1 = false;
                        int times = dpr[i][j];
                        while ((times--) >= 0) {
                            board[i][j--] = 0;
                        }
                        j++;
                    }
                }
            }
            for (int j = 0; j < col; j++) {
                for (int i = row-1; i >= 0; i--) {
                    if (dpc[i][j] >= 2) {
                        flag2 = false;
                        int times = dpc[i][j];
                        while ((times--) >= 0) {
                            board[i--][j] = 0;
                        }
                        i++;
                    }
                }
            }
            if (flag1 && flag2)
                break;
            int[][] tmp = new int[row][col];
            for (int j = 0; j < col; j++) {
                int r = row - 1;
                for (int i = row-1; i >= 0; i--) {
                    if (board[i][j] != 0) {
                        tmp[r--][j] = board[i][j];
                    }
                }
            }
            board = tmp;
        }
        
        return board;
    }
}