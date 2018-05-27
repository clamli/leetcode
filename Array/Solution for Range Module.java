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

class RangeModule {
    
    TreeMap<Integer, Integer> treeMap;
    
    public RangeModule() {
        treeMap = new TreeMap<Integer, Integer>();
    }
    
    public void addRange(int left, int right) {
        Integer lower = treeMap.floorKey(left), higher = treeMap.floorKey(right);
        int front = left, end = right;
        if (lower != null && treeMap.get(lower) >= left) {
            front = lower;
        }
        if (higher != null && treeMap.get(higher) >= right) {
            end = treeMap.get(higher);
        }
        treeMap.put(front, end);
        Map<Integer, Integer> subMap = treeMap.subMap(front, false, end, true);
        Set<Integer> set = new HashSet(subMap.keySet());
        treeMap.keySet().removeAll(set);
    }
    
    public boolean queryRange(int left, int right) {
        Integer lower = treeMap.floorKey(left);
        if (lower != null && treeMap.get(lower) >= right) 
            return true;
        return false;
    }
    
    public void removeRange(int left, int right) {
        Integer lower = treeMap.floorKey(left), higher = treeMap.floorKey(right);
        if (higher != null && treeMap.get(higher) > right) {
            treeMap.put(right, treeMap.get(higher));
        }
        if (lower != null && treeMap.get(lower) > left) {
            treeMap.put(lower, left);
        }
        Map<Integer, Integer> subMap = treeMap.subMap(left, true, right, false);
        Set<Integer> set = new HashSet(subMap.keySet());
        treeMap.keySet().removeAll(set);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */