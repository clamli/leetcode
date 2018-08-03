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
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int map[] = new int[26];
        for (char ch : licensePlate.toCharArray()) {
            if (Character.isLetter(ch))
                map[Character.toLowerCase(ch)-'a']++;
        }
        String ans = "";
        for (String word : words) {
            if (!ans.equals("") && word.length() >= ans.length()) continue;
            int tmap[] = new int[26];
            word = word.toLowerCase();
            for (char ch : word.toCharArray()) {
                tmap[ch-'a']++;
            }
            int i;
            for (i = 0; i < 26; i++) {
                if (tmap[i] < map[i]) break;
            }
            if (i == 26) ans = word;
        }
        return ans;
    }
}