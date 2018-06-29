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
    public boolean isStrobogrammatic(String num) {
        for (int i = 0, j = num.length()-1; i <= j; i++, j--) {
            if ((num.charAt(i) == '9' && num.charAt(j) == '6') || (num.charAt(i) == '6' && num.charAt(j) == '9')) continue;
            else if ((num.charAt(i) == num.charAt(j)) && (num.charAt(i) =='0' || num.charAt(i) =='1' || num.charAt(i) =='8')) continue;
            else return false;
        }
        return true;
    }
}