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

class ValidWordAbbr {
    Set<String> set;
    Set<String> removed;
    Set<String> dictSet;

    public ValidWordAbbr(String[] dictionary) {
        set = new HashSet<>();
        removed = new HashSet<>();
        dictSet = new HashSet<>(Arrays.asList(dictionary));
        for (String str : dictSet) {
            String key = retElem(str);
            if (set.contains(key))
                removed.add(key);
            else
                set.add(key);
        }
    }
    
    public boolean isUnique(String word) {
        String ele = retElem(word);
        if (!set.contains(ele) || (dictSet.contains(word)&&!removed.contains(ele))) {
            return true;
        }
        else return false;
    }
    
    private String retElem(String str) {
        StringBuilder ele = new StringBuilder("");
        if (str.length() <= 2) ele.append(str);
        else {
            ele.append(str.charAt(0));
            ele.append(str.length()-2);
            ele.append(str.charAt(str.length()-1));
        }
        return ele.toString();
    }
}