package leetcode;

import java.util.List;
import java.lang.reflect.Array;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.naming.ldap.StartTlsRequest;
import javax.naming.spi.DirStateFactory.Result;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
	
	private void backtrack(List<List<Integer>> list, List<Integer> item, int[] candidates, int target, int start) {
		if (target < 0) return;
		else if (target == 0) list.add(new ArrayList<>(item));
		else {
			for (int i = start; i < candidates.length; i++) {
				item.add(candidates[i]);
				backtrack(list, item, candidates, target-candidates[i], i+1);
				item.remove(item.size()-1);
				while (i+1 < candidates.length && candidates[i+1] == candidates[i])
					i++;
			}
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
