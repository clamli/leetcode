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
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        // row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        // col
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        // block
        for (int i = 0; i < 7; i+=3) {
            for (int j = 0; j < 7; j+=3) {
                
                for (int x = i; x < i+3; x++) {
                    for (int y = j; y < j+3; y++) {
                        if (board[x][y] != '.') {
                            if (set.contains(board[x][y])) return false;
                            set.add(board[x][y]);
                        }
                    }
                }
                set.clear();
                
            }
        }
        return true;
    }
}