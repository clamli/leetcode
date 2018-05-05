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
	public int leastInterval(char[] tasks, int n) {
        // int[] table = new int[26];
        // for (Character c : tasks) {
        //     table[c-'A']++;
        // }
        // Arrays.sort(table);
        // int term = table[25]-1, idle = term * n;
        // for (int i = 24; i >= 0; i--) {
        //     if (table[i] == 0)
        //         break;
        //     idle -= Math.min(table[i], term);
        // }
        // return idle > 0 ?  tasks.length+idle : tasks.length;
        
        // int time = 0;
        // int[] table = new int[26];
        // for (Character c : tasks) {
        //     table[c-'A']++;
        // }
        // Arrays.sort(table);
        // while (table[25] != 0) {
        //     int i = 0;
        //     while (i <= n) {
        //         if (i < 26 && table[25-i] > 0)
        //             table[25-i]--;
        //         i++;
        //         time++;
        //         if (table[25] == 0)
        //             break;
        //     }
        //     Arrays.sort(table);
        // }
        // return time;
        
        int max = 0, maxCount = 0;
        int[] table = new int[26];
        for (Character c : tasks) {
            table[c-'A']++;
        }
        for (int i = 0; i < table.length; i++) {
            if (table[i] > max) {
                max = table[i];
                maxCount = 1;
            } else if (table[i] == max) {
                maxCount++;
            }
        }
        return Math.max(tasks.length, maxCount + (n+1)*(max-1));
    }
}