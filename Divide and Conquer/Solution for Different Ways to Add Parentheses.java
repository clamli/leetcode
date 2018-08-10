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
    Map <String, List<Integer>> map = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String input) {
        String[] operands = input.split("\\*|\\+|-");
        int idx = 0;
        while (idx < input.length() && Character.isDigit(input.charAt(idx))) idx++;
        if (idx == input.length()) return new ArrayList<>(Arrays.asList(Integer.parseInt(operands[0])));
        String[] operators = input.substring(idx).split("\\d+");
        return compute(operands, operators, 0, operands.length-1, 0, operators.length-1);
    }
    
    private String prodKey(int s1, int s2) {
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append("#");
        sb.append(s2);
        return sb.toString();
    }
    
    private List<Integer> compute(String[] operands, String[] operators, int s1, int e1, int s2, int e2) {
        List<Integer> res = new ArrayList<>();
        if (s1 == e1) {
            return new ArrayList<>(Arrays.asList(Integer.parseInt(operands[s1])));
        }
        String key = prodKey(s1, e1);
        for (int i = s2; i <= e2; i++) {
            char op = operators[i].charAt(0);
            String key1 = prodKey(s1, i);
            String key2 = prodKey(i+1, e1);
            List<Integer> num1s, num2s;
            if (map.containsKey(key1))
                num1s = map.get(key1);
            else 
                num1s = compute(operands, operators, s1, i, s2, i-1);
            if (map.containsKey(key2)) 
                num2s = map.get(key2);
            else 
                num2s = compute(operands, operators, i+1, e1, i+1, e2);
            
            // use switch will be faster
            if (op == '+') {
                for (int num1 : num1s) {
                    for (int num2 : num2s) {
                        res.add(num1+num2);
                    }
                }
            } else if (op == '-') {
                for (int num1 : num1s) {
                    for (int num2 : num2s) {
                        res.add(num1-num2);
                    }
                }
            } else if (op == '*') {
                for (int num1 : num1s) {
                    for (int num2 : num2s) {
                        res.add(num1*num2);
                    }
                }
            }
        }
        map.put(key, res);
        return res;
    }
}