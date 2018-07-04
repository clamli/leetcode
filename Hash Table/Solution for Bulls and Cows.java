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
    public String getHint(String secret, String guess) {
        int cow = 0, bull = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            int snum = secret.charAt(i) - '0', gnum = guess.charAt(i) - '0';
            if (snum == gnum) bull++;
            else {
                if (map.containsKey(snum) && map.get(snum) < 0) cow++;
                map.put(snum, map.getOrDefault(snum, 0)+1);
                if (map.containsKey(gnum) && map.get(gnum) > 0) cow++;
                map.put(gnum, map.getOrDefault(gnum, 0)-1);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bull);
        sb.append('A');
        sb.append(cow);
        sb.append('B');
        return sb.toString();
    }
}