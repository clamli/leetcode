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
    public int movesToChessboard(int[][] board) {
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        for (int[] row : board) {
            int value = 0;
            for (int num : row) {
                value = 2*value + num;
            }
            map1.put(value, map1.getOrDefault(value, 0)+1);
        }
        int k1 = cntSwap(map1, board);
        if (k1 == -1) return -1;
        
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        int N = board.length;
        for (int i = 0; i < N; i++) {
            int value = 0;
            for (int j = 0; j < N; j++) {
                value = 2*value + board[j][i];
            }
            map2.put(value, map2.getOrDefault(value, 0)+1);
        }
        int k2 = cntSwap(map2, board);
        
        return k2 == -1 ? -1 : k1+k2;
    }
    
    private int cntSwap(Map<Integer, Integer> m, int[][] b) {
        int N = b.length;
        List<Integer> list = new ArrayList(m.keySet());
        if (list.size() != 2) return -1;
        int key1 = list.get(0), key2 = list.get(1);
        if (!((m.get(key1) == N/2 && m.get(key2) == (N+1)/2) || (m.get(key2) == N/2 && m.get(key1) == (N+1)/2))) return -1;
        if ((key1 ^ key2) != ((1<<N) - 1)) return -1;
        
        int None = (1<<N) - 1;
        int minswap = Integer.MAX_VALUE;
        int ones = Integer.bitCount(key1);
        if (N%2 == 0) minswap = Math.min(Integer.bitCount(key1 ^ 0x55555555 & None)/2, Integer.bitCount(key1 ^ 0xAAAAAAAA & None)/2);
        else if (ones > N/2) minswap = Integer.bitCount(key1 ^ 0x55555555 & None) / 2;
        else minswap = Integer.bitCount(key1 ^ 0xAAAAAAAA & None) / 2;
        return minswap;
    }
}