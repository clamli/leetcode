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
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if (numerator<0 ^ denominator<0) {
            sb.append('-');
        }
        long dividend = Math.abs((long)numerator);
        long divisor = Math.abs((long)denominator);
        sb.append(dividend / divisor);
        if (dividend % divisor == 0) /* 能整除 */ {
            return sb.toString();
        } else /* 不能整除 */ {
            sb.append('.');
            long remain = dividend % divisor;
            Map<Long, Integer> map = new HashMap<>();
            do {
                remain *= 10;
                if (map.containsKey(remain)) {
                    sb.insert((int)map.get(remain), '(');
                    sb.append(')');
                    return sb.toString();
                }
                long num = remain/divisor;
                map.put(remain, sb.length());
                sb.append(num);
                remain %= divisor;
            } while (remain != 0);
        }
        return sb.toString();
    }
}