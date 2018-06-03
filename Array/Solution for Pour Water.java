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
    
    public int[] pourWater(int[] heights, int V, int K) {
        int left = K-1, right = K+1;
        while (V-- != 0) {
            int i, j, min, leftind = -1, rightind = -1;
            int curhigh = heights[K];
            min = curhigh;
            for (i = left; i >= 0; i--) {
                if (heights[i] > min) break;
                if (heights[i] < min) {
                    min = heights[i];
                    leftind = i;
                }
            }
            if (leftind != -1) {
                heights[leftind]++;
                continue;
            }
            for (j = right; j < heights.length; j++) {
                if (heights[j] > min) break;
                if (heights[j] < min) {
                    min = heights[j];
                    rightind = j;
                }
            }
            if (rightind != -1) heights[rightind]++;
            else heights[K]++;
        }
        return heights;
    }
    
}