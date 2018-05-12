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
    public int kEmptySlots(int[] flowers, int k) {
//         int size = flowers.length;
//         int[] flag = new int[size+1];
        
//         for (int i = 0; i < size; i++) {
//             flag[flowers[i]] = 1;
//             int left = flowers[i]-1, right = flowers[i]+1;
//             while (left >= 0 && flag[left] != 1) left--;
//             while (right <= size && flag[right] != 1) right++;
//             if ((left != -1 && flowers[i] - left - 1 == k) || (right != size+1 && right - flowers[i] - 1 == k)) {
//                 return i+1;
//             }
//         }
        
//         return -1;
        
        int size = flowers.length, interval = k + 1, bucketnum = size/interval + 1;
        int[] bucketmax = new int[bucketnum];
        int[] bucketmin = new int[bucketnum];
        
        Arrays.fill(bucketmax, Integer.MIN_VALUE);
        Arrays.fill(bucketmin, Integer.MAX_VALUE);
        
        for (int i = 0; i < size; i++) {
            int bucketindex = flowers[i]/interval;
            if (bucketmax[bucketindex] < flowers[i]) {
                bucketmax[bucketindex] = flowers[i];
                if (bucketindex < bucketnum-1 && bucketmin[bucketindex+1] == flowers[i]+interval) {
                    return i+1;
                }
            }
            if (bucketmin[bucketindex] > flowers[i]) {
                bucketmin[bucketindex] = flowers[i];
                if (bucketindex > 0 && bucketmax[bucketindex-1] == flowers[i]-interval) {
                    return i+1;
                } 
            }
        }
        return -1;
    }
}