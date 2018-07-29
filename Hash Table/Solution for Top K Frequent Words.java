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
    public List<String> topKFrequent(String[] words, int k) {
        if (k == 0) return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        int size = map.size();
        String[] heap = (String[]) map.keySet().toArray(new String[size]);
        for (int i = size/2 -1; i >= 0; i--) {
            adjust(map, heap, i, size);
        }
        List<String> res = new ArrayList<>();
        while (true) {
            res.add(heap[0]);
            k--;
            if (k == 0) break;
            heap[0] = heap[size-1];
            size--;
            adjust(map, heap, 0, size);
        }
        return res;
    }
    
    private void adjust(Map<String, Integer> map, String[] heap, int pos, int size) {
        while (pos <= size/2 - 1) {
            int left = 2*pos+1, right = 2*pos+2, max = map.get(heap[left]), maxind = left;
            if (right < size && (max < map.get(heap[right]) || (max == map.get(heap[right]) && heap[maxind].compareTo(heap[right]) > 0))) {
                max = map.get(heap[right]);
                maxind = right;
            }
            int curcnt = map.get(heap[pos]);
            if (curcnt < max || (curcnt == max && heap[pos].compareTo(heap[maxind]) > 0)) {
                String tmp = heap[maxind];
                heap[maxind] = heap[pos];
                heap[pos] = tmp;
                pos = maxind;
            } else {
                break;
            }
        }
    }
}