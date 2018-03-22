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
	
	public boolean exist(char[][] board, String word) {
		int row = board.length - 1;
		if (row == -1) return false;
		int col = board[0].length - 1;
		
		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= col; j++) {
				if (backtrack(board, word, 0, i, j, row, col)) return true;
			}
		}
        
		return false;
    }
	
	public boolean backtrack(char[][] board, String word, int curind, int currow, int curcol, int row, int col) {
		if (currow > row || curcol > col || currow < 0 || curcol < 0) return false;
		
		if (curind == word.length()-1 && board[currow][curcol] == word.charAt(curind)) return true;
		else if (board[currow][curcol] != word.charAt(curind)) return false;
		
		board[currow][curcol] ^= 256;
		boolean result = backtrack(board, word, curind+1, currow+1, curcol, row, col) ||
						backtrack(board, word, curind+1, currow-1, curcol, row, col) ||
						backtrack(board, word, curind+1, currow, curcol+1, row, col) ||
						backtrack(board, word, curind+1, currow, curcol-1, row, col);
		board[currow][curcol] ^= 256;
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}