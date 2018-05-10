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
	// public boolean checkPossibility(int[] nums) {
    //     int size = nums.length;
    //     boolean[] lflag = new boolean[size], rflag = new boolean[size];
    //     int[] lmax = new int[size], rmin = new int[size];
    //     lflag[0] = true;
    //     lmax[0] = nums[0];
    //     for (int i = 1; i < size; i++) {
    //         lflag[i] = lflag[i-1] && (nums[i] >= nums[i-1]);
    //         lmax[i] = Math.max(lmax[i-1], nums[i]);
    //     }
    //     rflag[size-1] = true;
    //     rmin[size-1] = nums[size-1];
    //     for (int i = size-2; i >= 0; i--) {
    //         rflag[i] = rflag[i+1] && (nums[i] <= nums[i+1]);
    //         rmin[i] = Math.min(rmin[i+1], nums[i]);
    //     }
    //     for (int i = 0; i < size; i++) {
    //         if (i == 0) {
    //             if (size == 1 || rflag[i+1]) return true;
    //         } else if (i == size - 1) {
    //             if (lflag[i-1]) return true;
    //         } else {
    //             if (lflag[i-1] && rflag[i+1] && lmax[i-1] <= rmin[i+1]) return true;
    //         }
    //     }
    //     return false;
    // }
    
    public boolean checkPossibility(int[] nums) {
        int size = nums.length, pindex = -1;
        for (int i = 0; i < size-1; i++) {
            if (nums[i] > nums[i+1]) {
                if (pindex != -1) return false;
                pindex = i;
            }
        }
        return (pindex == -1) || (pindex == 0) || (pindex == size-2) || (nums[pindex-1] <= nums[pindex+1]) || (nums[pindex] <= nums[pindex+2]);
    }
}