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



/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    // method 1
    // public int maxPoints(Point[] points) {
    //     if (points.length == 0) return 0;
    //     Map<Integer, Integer> mapV = new HashMap<>();
    //     Map<Integer, Integer> mapH = new HashMap<>();
    //     Map<Double, Integer> mapR = new HashMap<>();
    //     int maxT = 0;
    //     for (int i = 0; i < points.length; i++) {
    //         int cnt = 0, val = 0, max = 0;
    //         for (int j = 0; j < points.length; j++) {
    //             if (points[i].x == points[j].x && points[i].y == points[j].y) {
    //                 cnt++;
    //             } else if (points[i].x == points[j].x) {
    //                 mapV.put(points[i].x, mapV.getOrDefault(points[i].x, 0)+1);
    //                 val = mapV.get(points[i].x);
    //             } else if (points[i].y == points[j].y) {
    //                 mapH.put(points[i].y, mapH.getOrDefault(points[i].y, 0)+1);
    //                 val = mapH.get(points[i].y);
    //             } else {
    //                 double k = ((double)points[j].y - points[i].y)*100 / ((double)points[j].x - points[i].x);
    //                 mapR.put(k, mapR.getOrDefault(k, 0)+1);
    //                 val = mapR.get(k);
    //             }
    //             max = Math.max(max, val);
    //         }
    //         maxT = Math.max(maxT, max + cnt);
    //         mapV.clear();
    //         mapH.clear();
    //         mapR.clear();
    //     }
    //     return maxT;
    // }
    
    // method 2
    public int maxPoints(Point[] points) {
        int size = points.length;
        if (size <= 2) return points.length;
        int max = 0;
        for (int i = 1; i < size; i++) {
            double k = getSlot(points[i-1], points[i]);
            int count = 2;
            for (int j = 0; j < size; j++) {
                if (j == i || j == i-1) continue;
                if ((points[j].x == points[i].x && points[j].y == points[i].y) || (points[j].x == points[i-1].x && points[j].y == points[i-1].y) || k == getSlot(points[i], points[j])) count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
    
    private double getSlot(Point a, Point b) {
        if (b.x - a.x == 0) return Double.POSITIVE_INFINITY;
        else return ((double)b.y - (double)a.y) / ((double)b.x - (double)a.x);
    }
}