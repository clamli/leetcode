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
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int ans = 0, start = 0, end = -1;
        for (int i = 0; i < A.length; i++) {   
            if (A[i] <= R && A[i] >= L) {
                end = i;
                ans += end - start + 1;
            } else if (A[i] < L && end != -1) {
                ans += end - start + 1;
            } else if (A[i] > R) {
                start = i + 1;
                end = -1;
            }  
        }
        return ans;
    }
}