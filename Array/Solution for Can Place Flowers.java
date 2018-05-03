package leetcode;

import java.util.List;
import java.awt.font.GraphicAttribute;
import java.awt.font.NumericShaper;
import java.io.FilterInputStream;
import java.lang.reflect.Array;
import java.security.AlgorithmConstraints;
import java.text.DateFormatSymbols;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.logging.Logger;

import javax.naming.SizeLimitExceededException;
import javax.naming.ldap.StartTlsRequest;
import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.swing.DefaultFocusManager;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import javax.tools.ToolProvider;
import javax.xml.ws.Endpoint;

import org.omg.CORBA.Current;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.css.ElementCSSInlineStyle;

class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // if (n == 0) {
        //     return true;
        // }
        // if (flowerbed.length == 1 && flowerbed[0] == 0) {
        //     n--;
        //     return n == 0;
        // }     
        // int status = -1, ind = 1;
        // while (n > 0 && ind < flowerbed.length) {
        //     if (flowerbed[ind] == 0) {
        //         if (status == -1) {
        //             if (flowerbed[ind-1] == 0)
        //                 n--;
        //             status = 1;
        //         } else if (status == 0) {
        //             status = 1;
        //         } else if (status == 1 && (ind == flowerbed.length - 1 || flowerbed[ind+1] == 0)) {
        //             n--;
        //             ind++;
        //             status = 1;
        //         }
        //     } else {
        //         status = 0;
        //     }
        //     ind++;
        // }
        // return n == 0;
        
        int i = 0, size = flowerbed.length;
        while (n > 0 && i < size) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == size-1 || flowerbed[i+1] == 0) {
                n--;
                i += 2;
            } else {
                i++;
            }
        }
        return n == 0;
    }
}