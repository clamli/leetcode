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
    public int maxChunksToSorted(int[] arr) {
        // int size = arr.length;
        // int[] sorted = new int[size];
        // System.arraycopy(arr, 0, sorted, 0, size);
        // Arrays.sort(sorted);
        // int max = -1, count = 0, ans = 0, sum = 0;
        // for (int i = 0; i < size; i++) {
        //     if (arr[i] > max) {
        //         max = arr[i];
        //         count = 1;
        //     } else if (arr[i] == max) {
        //         count++;
        //     }
        //     if (max == sorted[i]) { 
        //         ans++;
        //         i += count - 1;
        //         sum += count - 1;
        //         count = 0;
        //     }
        // }
        // return ans;
        
        // method 1
        // int cnt = 0, size = arr.length;
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // List<Pair> list = new ArrayList<Pair>();
        // for (int i = 0; i < size; i++) {
        //     map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        //     list.add(new Pair(arr[i], map.get(arr[i])));
        // }
        // List<Pair> sorted = new ArrayList<Pair>(list);
        // Collections.sort(sorted, (a,b) -> a.compare(b));
        // Pair max = sorted.get(0);
        // for (int i = 0; i < size; i++) {
        //     if (list.get(i).compare(max) > 0) max = list.get(i);
        //     if (max.compare(sorted.get(i)) == 0) cnt++;
        // }
        // return cnt;
        
        //method 2
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // int size = arr.length, ans = 0;
        // int[] sorted = arr.clone();
        // Arrays.sort(sorted);
        // int nonzero = 0;
        // for (int i = 0; i < size; i++) {
        //     int varr = arr[i];
        //     map.put(varr, map.getOrDefault(varr, 0)+1);
        //     if (map.get(varr) == 0) nonzero--;
        //     else if (map.get(varr) == 1) nonzero++;
        //     int vsorted = sorted[i];
        //     map.put(vsorted, map.getOrDefault(vsorted, 0)-1);
        //     if (map.get(vsorted) == 0) nonzero--;
        //     else if (map.get(vsorted) == -1) nonzero++;
        //     if (nonzero == 0) ans++;
        // }
        // return ans;
        
        //method 3
        int size = arr.length, ans = 0;
        int[] rightmin = new int[size];
        rightmin[size-1] = arr[size-1];
        for (int i = size-2; i >= 0; i--) {
            rightmin[i] = Math.min(arr[i], rightmin[i+1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, arr[i]);
            if (i == size-1 || max <= rightmin[i+1]) ans++;
        }
        return ans;
    }
}





// method 1
// class Pair {
//     int v;
//     int c;
//     Pair(int o_v, int o_c) {
//         v = o_v;
//         c = o_c;
//     }     
//     int compare(Pair o) {
//         return v != o.v ? v-o.v : c-o.c;
//     }
// }