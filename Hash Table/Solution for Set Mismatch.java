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
    public int[] findErrorNums(int[] nums) {
        int size = nums.length, dup = 0;
        boolean[] map = new boolean[size+1];
        for (int num : nums) {
            if (map[num] == false) map[num] = true;
            else {
                dup = num;
            }
        }
        int loss = 0;
        for (int i = 1; i <= size; i++) {
            if (map[i] == false) loss = i;
        }
        return new int[] {dup, loss};
    }
}