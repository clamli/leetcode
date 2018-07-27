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
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] element = path.split(" ");
            for (int i = 1; i < element.length; i++) {
                StringBuilder prefix = new StringBuilder(element[0]);
                prefix.append('/');
                int seq = element[i].indexOf('(');
                String content = element[i].substring(seq);
                String fpref = prefix.append(element[i].substring(0, seq)).toString();
                if (!map.containsKey(content)) map.put(content, new ArrayList<>());
                map.get(content).add(fpref);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> value : map.values()) {
            if (value.size() > 1) res.add(value);
        }
        return res;
    }
}