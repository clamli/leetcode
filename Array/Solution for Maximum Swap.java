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
    public int maximumSwap(int num) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (num != 0) {
            map.put(cnt++, num%10);
            num /= 10;
        }
        int[] dp = new int[cnt];
        dp[0] = 0;
        for (int i = 1; i < cnt; i++) {
            if (map.get(dp[i-1]) >= map.get(i)) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = i;
            }
        }
        for (int i = cnt-1; i >= 0; i--) {
            int cur = map.get(i), chan = map.get(dp[i]);
            if (chan > cur) {
                int tmp = chan;
                map.put(dp[i], cur);
                map.put(i, chan);
                break;
            }
        }
        int sum = 0;
        for (int i = cnt-1; i >= 0; i--) {
            sum = sum*10 + map.get(i);
        }
        return sum;
    }
}