package leetcode;

import java.util.List;
import java.awt.font.GraphicAttribute;
import java.awt.font.NumericShaper;
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
import java.util.Stack;
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
	
	public int shortestWordDistance(String[] words, String word1, String word2) {
//        int ind1 = -1, ind2 = -1, min_dist = Integer.MAX_VALUE;
//        if (!word1.equals(word2)) {
//        	for (int i = 0; i < words.length; i++) {
//            	if (words[i].equals(word1)) {
//            		ind1 = i;
//            	} else if (words[i].equals(word2)) {
//            		ind2 = i;
//            	}
//            	if (ind1 == -1 || ind2 == -1) continue;
//            	int dist = Math.abs(ind1 - ind2);
//            	if (dist < min_dist) {
//            		min_dist = dist;
//            	}
//            }
//        } else {
//        	for (int i = 0; i < words.length; i++) {
//    			if (words[i].equals(word1)) {
//    				if (ind1 == -1) ind1 = i;
//    				else if (ind2 == -1) ind2 = i;
//    				else {
//    					if (i - ind1 > i - ind2) { 
//    						ind1 = i;
//    					} else {
//    						ind2 = i;
//    					}
//    				}
//    			}
//    			if (ind1 == -1 || ind2 == -1) continue;
//    			int dist = Math.abs(ind1 - ind2);
//    			if (dist < min_dist) {
//            		min_dist = dist;
//            	}
//    		}
//        }

		long min_dist = Integer.MAX_VALUE, ind1 = -min_dist, ind2 = min_dist;
		boolean same = word1.equals(word2);
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				ind1 = i;
			} 
			if (words[i].equals(word2)) {
				if (same)
					ind1 = ind2;
				ind2 = i;
			}
			min_dist = Math.min(min_dist, Math.abs(ind2 - ind1));
		}
		
		return (int)min_dist;
    }
	
}
