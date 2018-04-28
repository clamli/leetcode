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
	public int findBlackPixel(char[][] picture, int N) {
        int nrow = picture.length, ncol = picture[0].length;
        int[] col = new int[ncol];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < nrow; i++) {
            String key = scanRow(picture[i], N, col);
            if (key.length() != 0) {
                map.put(key, map.getOrDefault(key, 0)+1);
            }
        }
        
        int count = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == N) {
                for (int i = 0; i < key.length(); i++) {
                    if (key.charAt(i) == 'B' && col[i] == N)
                        count += N;
                }
            }
        }
        
        return count;
    }
    
    private String scanRow(char[] row, int N, int[] col) {
        int rowCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 'B') {
                col[i]++;
                rowCount++;
            }
            sb.append(row[i]);
        }
        if (rowCount == N)
            return sb.toString();
        else
            return "";
    }
}