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
    // method 1
    // public int numFriendRequests(int[] ages) {
    //     Arrays.sort(ages);
    //     int ans = 0, end = ages.length - 1;
    //     for (int i = ages.length - 1; i >= 1; i--) {
    //         int tmpend = i;
    //         if (ages[i] == ages[i-1] && ages[i-1] > 0.5*ages[i]+7) {
    //             tmpend = i-1;
    //             ans++;
    //             while (tmpend > 0 && ages[tmpend-1] == ages[i]) {
    //                 tmpend--;
    //                 ans++;
    //             }
    //         }
    //         end = Math.min(end, tmpend);
    //         while (end > 0 && ages[end-1] > 0.5*ages[i]+7) {
    //             end--;
    //         }
    //         ans += i - end;
    //     }
    //     return ans;
    // }
    
    // method 2
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age: ages) count[age]++;

        int ans = 0;
        for (int ageA = 0; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 0; ageB <= ageA; ageB++) {
                int countB = count[ageB];
                if (ageA * 0.5 + 7 >= ageB) continue;
                ans += countA * countB;
                if (ageA == ageB) ans -= countA;
            }
        }

        return ans;
    }
}