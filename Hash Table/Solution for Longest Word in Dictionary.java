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
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        String minstr = "";
        for (String word : words) {
            int i;
            if (word.length()<minstr.length() || (word.length()==minstr.length()&&word.compareTo(minstr)>0)) continue;
            for (i = 1; i < word.length(); i++) {
                if (!set.contains(word.substring(0, i))) break;
            }
            if (i == word.length()) {
                minstr = word;
            }
        }
        return minstr;
    }
}