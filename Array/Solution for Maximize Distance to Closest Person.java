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
    public int maxDistToClosest(int[] seats) {
        int size = seats.length;
        int[] leftone = new int[size];
        if (seats[0] == 1) leftone[0] = 0;
        else leftone[0] = -1;
        for (int i = 1; i < size; i++) {
            if (seats[i] == 1) leftone[i] = 0;
            else if (leftone[i-1] == -1) leftone[i] = -1;
            else leftone[i] = leftone[i-1] + 1;
        }
        int[] rightone = new int[size];
        if (seats[size-1] == 1) rightone[size-1] = 0;
        else rightone[size-1] = -1;
        for (int i = size-2; i >= 0; i--) {
            if (seats[i] == 1) rightone[i] = 0;
            else if (rightone[i+1] == -1) rightone[i] = -1;
            else rightone[i] = rightone[i+1] + 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (seats[i] == 1) continue;
            int curmax;
            if (leftone[i] == -1) curmax = rightone[i];
            else if (rightone[i] == -1) curmax = leftone[i];
            else curmax = Math.min(leftone[i], rightone[i]);
            max = Math.max(max, curmax);
        }
        return max;
    }
}