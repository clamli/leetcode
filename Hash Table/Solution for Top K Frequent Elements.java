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
    //     method 1 Heap
//     public List<Integer> topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0)+1);
//         }
//         int size = map.size();
//         Integer[] non_ov_num = new Integer[size];
//         map.keySet().toArray(non_ov_num);
//         for (int i = size/2-1; i >= 0; i--) {
//             adjust(i, size, non_ov_num, map);
//         }
//         List<Integer> res = new ArrayList<>();
//         for (int i = 0; i < k; i++) {
//             res.add(non_ov_num[0]);
//             int tmp = non_ov_num[0];
//             non_ov_num[0] = non_ov_num[size-1];
//             non_ov_num[size-1] = tmp;
//             size--;
//             adjust(0, size, non_ov_num, map);
//         }
//         return res;
//     }
    
//     private void adjust(int idx, int size, Integer[] non_ov_num, Map<Integer, Integer> map) {
//         while (idx <= size/2-1) {
//             int maxidx = 2*idx+1;
//             if (2*idx+2 <= size-1 && map.get(non_ov_num[maxidx]) < map.get(non_ov_num[2*idx+2]))
//                 maxidx = 2*idx+2;
//             if (map.get(non_ov_num[idx]) < map.get(non_ov_num[maxidx])) {
//                 int tmp = non_ov_num[idx];
//                 non_ov_num[idx] = non_ov_num[maxidx];
//                 non_ov_num[maxidx] = tmp;
//             }
//             idx = maxidx;
//         }
//     }
    
    // method 2 TreeMap Sort
    // public List<Integer> topKFrequent(int[] nums, int k) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int num : nums) {
    //         map.put(num, map.getOrDefault(num, 0)+1);
    //     }
    //     Map<Integer, List<Integer>> map_cnt = new TreeMap<>(new Comparator<Integer>(){
    //         public int compare(Integer a,Integer b){
    //                 return b-a;  
    //         }
    //     });
    //     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         int key = entry.getValue(), value = entry.getKey();
    //         if(!map_cnt.containsKey(key)) map_cnt.put(key, new ArrayList<>());
    //         map_cnt.get(key).add(value);
    //     }
    //     int num = 0;
    //     List<Integer> res = new ArrayList<>();
    //     for (Map.Entry<Integer, List<Integer>> entry : map_cnt.entrySet()) {
    //         List<Integer> tmp = entry.getValue();
    //         num += tmp.size();
    //         res.addAll(tmp);
    //         if (num == k) break;
    //     }
    //     return res;
    // }
    
    // method 3 Bucket Sort
    public List<Integer> topKFrequent(int[] nums, int k) {
        int max_num = Integer.MIN_VALUE;
        int min_num = Integer.MAX_VALUE;
        for (int num : nums) {
            max_num = Math.max(max_num, num);
            min_num = Math.min(min_num, num);
        }
        int[] map_cnt = new int[max_num-min_num+1];
        for (int num : nums) {
            map_cnt[num-min_num]++;
        }
        List<Integer>[] buckets = new List[nums.length+1];
        for (int i = 0; i < map_cnt.length; i++) {
            if (buckets[map_cnt[i]] == null) buckets[map_cnt[i]] = new ArrayList<>();
            buckets[map_cnt[i]].add(i+min_num);
        }
        List<Integer> res = new ArrayList<>();
        int num = 0;
        for (int i = buckets.length-1; i >= 0; i--) {
            if (buckets[i] != null) {
                num += buckets[i].size();
                res.addAll(buckets[i]);
                if (num == k) break;
            }
        }
        return res;
    }
}