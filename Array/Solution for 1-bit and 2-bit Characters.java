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

public class Solution {
	
    public boolean isOneBitCharacter(int[] bits) {
        int size = bits.length;
        if (size == 1) return (bits[0] == 0);
        boolean[] dp = new boolean[size];
        dp[0] = (bits[0] == 0);
        dp[1] = (bits[0] == 1) || (bits[0] == bits[1]);
        for (int i = 2; i < size-1; i++) {
            dp[i] = (bits[i] == 1 && dp[i-2] && bits[i-1] == 1) || (bits[i] == 0);
        }
        return dp[size-2];
    }
}