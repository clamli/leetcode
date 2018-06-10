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
    public String shiftingLetters(String S, int[] shifts) {
        int size = shifts.length;
        int[] dp = new int[size];
        dp[size-1] = shifts[size-1] % 26;
        for (int i = size-2; i >= 0; i--) {
            dp[i] = (dp[i+1] + shifts[i]) % 26;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char tmp = S.charAt(i);
            tmp = (char)(tmp + dp[i]);
            if (tmp > 'z') {
                tmp = (char)('a' + tmp - 'z' - 1);
            }
            stringBuilder.append(tmp);
        }
        return stringBuilder.toString();
    }
}