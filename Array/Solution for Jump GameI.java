package leetcode;

import java.util.List;
import java.lang.reflect.Array;
import java.security.AlgorithmConstraints;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import javax.naming.SizeLimitExceededException;
import javax.naming.ldap.StartTlsRequest;
import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.omg.CORBA.Current;
import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	
	public boolean canJump(int[] nums) {
        int i = 0, currentMax = 0, nextMax = 0, size = nums.length;
        boolean flag = false;
        
        while (!flag && (currentMax - i + 1 > 0)) {
        	for (; i <= currentMax; i++) {
        		nextMax = Math.max(nextMax, nums[i]+i);
        		if (nextMax >= size - 1) {
        			flag = true;
        			break;
        		}
        	}
        	currentMax = nextMax;
        }
        
        return flag;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}