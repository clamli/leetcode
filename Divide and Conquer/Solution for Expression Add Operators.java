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
    public List<String> addOperators(String num, int target) {
        if (num.equals("")) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        compute(num, target, res, 0, 0, 0, "");
        return res;
    }
    
    private void compute(String num, int target, List<String> res, int pos, long eval, long multi, String path) {
        if (pos == num.length() && eval == target) {
            res.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            String item = num.substring(pos, i+1);
            long val = Long.parseLong(item);
            if (pos == 0) {
                compute(num, target, res, i+1, val, val, item);
            } else {
                compute(num, target, res, i+1, eval+val, val, path+"+"+item);
                compute(num, target, res, i+1, eval-val, -val, path+"-"+item);
                compute(num, target, res, i+1, eval-multi+val*multi, val*multi, path+"*"+item);
            }
        }
    }
}