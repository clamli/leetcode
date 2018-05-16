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
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        int[] startintv = new int[n-3*k+1];
        for (int i = 1; i < n-3*k+1; i++) {
            if (sum[startintv[i-1]+k]-sum[startintv[i-1]] < sum[i+k]-sum[i])
                startintv[i] = i;
            else
                startintv[i] = startintv[i-1];
        }
        int[] endintv = new int[n-3*k+1];
        endintv[n-3*k] = n-k;
        for (int i = n-3*k-1; i >= 0; i--) {
            if (sum[endintv[i+1]+k]-sum[endintv[i+1]] <= sum[i+3*k]-sum[i+2*k])
                endintv[i] = i+2*k;
            else
                endintv[i] = endintv[i+1];
        }
        int[] result = new int[3];
        int max = Integer.MIN_VALUE;
        for (int i = k; i <= n-2*k; i++) {
            int sum3 = sum[i+k]-sum[i] + sum[startintv[i-k]+k]-sum[startintv[i-k]] + sum[endintv[i-k]+k]-sum[endintv[i-k]];
            if (sum3 > max) {
                max = sum3;
                result[0] = startintv[i-k];
                result[1] = i;
                result[2] = endintv[i-k];
            }
        }
        return result;
    }
}