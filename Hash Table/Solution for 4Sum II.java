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
    // method 1 : time limited error O(N^3)
    // public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    //     Arrays.sort(C);
    //     Arrays.sort(D);
    //     int N = A.length, res = 0;
    //     for (int i = 0; i < N; i++) {
    //         for (int j = 0; j < N; j++) {
    //             int target = -(A[i]+B[j]);
    //             int didx = N-1;
    //             for (int t = 0; t < N; t++) {
    //                 int pairs = 0;
    //                 while (didx >= 0) {
    //                     if (C[t]+D[didx] < target) break;
    //                     else if (C[t]+D[didx] > target) didx--;
    //                     else {
    //                         pairs++;
    //                         didx--;
    //                     }
    //                 }
    //                 do {
    //                     res += pairs;
    //                     t++;
    //                 } while (t < N && C[t] == C[t-1]);
    //                 t--;
    //             }
    //         }
    //     }
    //     return res;
    // }
    
    // method 2     O(N^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int N = A.length, res = 0;
        HashMap<Integer, Integer> abMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int key = A[i]+B[j];
                abMap.put(key, abMap.getOrDefault(key, 0)+1);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int key = -(C[i]+D[j]);
                if (abMap.containsKey(key)) res += abMap.get(key);
            }
        }
        return res;
    }
}