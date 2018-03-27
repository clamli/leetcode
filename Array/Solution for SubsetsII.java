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
import java.util.ArrayList;
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
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //result.add(new ArrayList<>());
        
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        
        return result;
    }
	
	private void backtrack(int[] nums, int start, List<Integer> elem, List<List<Integer>> result) {	
		result.add(new ArrayList<>(elem));
		
		for (int i = start; i < nums.length; i++) {    
			if (i == start || nums[i] != nums[i-1]) {
				elem.add(nums[i]);
				backtrack(nums, i+1, elem, result);
				elem.remove(elem.size()-1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
	}
}