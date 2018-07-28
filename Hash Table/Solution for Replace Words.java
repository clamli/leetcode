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
    public String replaceWords(List<String> dict, String sentence) {
        String[] tokens = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(findRoot(dict, tokens[0]));
        for (int i = 1; i < tokens.length; i++) {
            sb.append(" ");
            sb.append(findRoot(dict, tokens[i]));
        }
        return sb.toString();
    }
    
    private String findRoot(List<String> dict, String token) {
        String root = null;
        for (String elem : dict) {
            // if (root != null && root.length() <= elem.length()) continue;
            if (elem.length() < token.length() && elem.equals(token.substring(0, elem.length()))) {
                if (root == null || root.length() > elem.length()) 
                    root = elem;
            }
        }
        return root == null ? token : root;
    }
}