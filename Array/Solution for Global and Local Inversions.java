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
    public boolean isIdealPermutation(int[] A) {
        // method 1
        // int size = A.length;
        // int[] rightmin = new int[size];
        // rightmin[size-1] = A[size-1];
        // for (int i = size-2; i >= 0; i--) {
        //     rightmin[i] = Math.min(rightmin[i+1], A[i]);
        // }
        // int max = A[0];
        // for (int i = 1; i < size-1; i++) {
        //     if (max > rightmin[i+1]) return false;
        //     max = Math.max(max, A[i]);
        // }
        // return true;
        
        // method 2
        int size = A.length;
        for (int i = 0; i < size; i++) {
            int diff = A[i] - i;
            if (diff > 1 || diff < -1) return false;
        }
        return true;
    }
}