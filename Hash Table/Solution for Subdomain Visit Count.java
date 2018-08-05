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
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int seq = cpdomain.indexOf(' ');
            int cnt = Integer.parseInt(cpdomain.substring(0, seq));
            String subdomains = cpdomain.substring(seq+1);
            int start = -1;
            do {
                subdomains = subdomains.substring(start+1);
                map.put(subdomains, map.getOrDefault(subdomains, 0)+cnt);
                start = subdomains.indexOf('.');               
            } while (start != -1);
        }
        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(key));
            sb.append(' ');
            sb.append(key);
            res.add(sb.toString());
        }
        return res;
    }
}