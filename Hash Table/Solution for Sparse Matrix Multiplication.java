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
        // Map<Integer, Map<Integer, Integer>> mapA = new HashMap<>();
        // Map<Integer, Map<Integer, Integer>> mapB = new HashMap<>();
        // for (int i = 0; i < A.length; i++) {
        //     mapA.put(i, new HashMap<>());
        //     for (int j = 0; j < A[0].length; j++) {
        //         if (A[i][j] != 0)
        //             mapA.get(i).put(j, A[i][j]);
        //     }
        // }
        // for (int i = 0; i < B[0].length; i++) {
        //     mapB.put(i, new HashMap<>());
        //     for (int j = 0; j < B.length; j++) {
        //         if (B[j][i] != 0)
        //             mapB.get(i).put(j, B[j][i]);
        //     }
        // }
        // int r = 0, c = 0;
        // int[][] res = new int[A.length][B[0].length];
        // for (Map<Integer, Integer> valA : mapA.values()) {
        //     c = 0;
        //     for (Map<Integer, Integer> valB : mapB.values()) {
        //         for (Integer key : valA.keySet()) {
        //             if (valB.containsKey(key)) res[r][c] += valA.get(key)*valB.get(key);
        //         }
        //         c++;
        //     }
        //     r++;
        // }
        // return res;
        
        // method 2
        // int[][] res = new int[A.length][B[0].length];
        // for (int i = 0; i < A.length; i++) {
        //     for (int j = 0; j < B[0].length; j++) {
        //         for (int t = 0; t < A[0].length; t++) res[i][j] += A[i][t]*B[t][j];
        //     }
        // }
        // return res;
        
        // method 3
        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    for (int t = 0; t < B[0].length; t++) res[i][t] += A[i][j]*B[j][t];
                }
            }
        }
        return res;
    }
}