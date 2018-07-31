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
//     method 1: memory limited error    
//     Random r;
//     List<Integer> pool;

//     public Solution(int N, int[] blacklist) {
//         r = new Random();
//         Set<Integer> set = new HashSet<>();
//         for (int i = 0; i < N; i++) set.add(i);
//         for (int x : blacklist) set.remove(x);
//         pool = new ArrayList<>(set);
//     }
    
//     public int pick() {
//         return pool.get(r.nextInt(pool.size()));
//     }
    
    // method 2: binary search
//     int tN;
//     int rem;
//     int[] tblacklist;
//     Random r;
    
//     public Solution(int N, int[] blacklist) {
//         r = new Random();
//         tN = N;
//         tblacklist = blacklist;
//         Arrays.sort(tblacklist);
//         rem = tN - tblacklist.length;
//     }
    
//     public int pick() {
//         return getRandomK(r.nextInt(rem));
//     }
    
//     private int getRandomK(int k) {
//         int lo = 0, hi = tblacklist.length-1, mid = 0;
//         if (hi == -1) return k;
//         while (lo < hi) {
//             mid = (lo + hi + 1) / 2;
//             if (tblacklist[mid]-mid > k) hi = mid-1;
//             else if (tblacklist[mid]-mid <= k) lo = mid;
//         }
//         if (tblacklist[lo]-lo > k) return k;
//         else return k + lo + 1;
//     }
    
    // method 3
    int rem;
    Map<Integer, Integer> map;
    Random r;
    
    public Solution(int N, int[] blacklist) {
        map = new HashMap<>();
        r = new Random();
        rem = N - blacklist.length;
        Set<Integer> set = new HashSet<>();
        for (int i = rem; i < N; i++) set.add(i);      // all elements >= rem      N-rem
        for (int i : blacklist) set.remove(i);         // all whitelist elements >= rem         N-rem-B>=
        Iterator<Integer> iter = set.iterator();       // notice : N-rem-B>=   ==   B<
        for (int i : blacklist) {
            if (i < rem) map.put(i, iter.next());
        }
    }
    
    public int pick() {
        int k = r.nextInt(rem);
        return map.getOrDefault(k, k);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */