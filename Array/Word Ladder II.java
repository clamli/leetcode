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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import javax.naming.SizeLimitExceededException;
import javax.naming.ldap.StartTlsRequest;
import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import javax.tools.ToolProvider;
import javax.xml.ws.Endpoint;

import org.omg.CORBA.Current;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.css.ElementCSSInlineStyle;

class Solution {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordset = new HashSet<>(wordList);
		HashMap<String, ArrayList<String>> chain = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String string : wordset) {
        	chain.put(string, new ArrayList<>());
        }
        chain.put(beginWord, new ArrayList<>());
        distance.put(beginWord, 0);
        
        bfs(beginWord, endWord, wordset, chain, distance);
        dfs(beginWord, endWord, chain, distance, new ArrayList<>(), result);
        return result;
	}
	
	private void bfs(String start, String end, HashSet<String> wordset, HashMap<String, ArrayList<String>> chain, HashMap<String, Integer> distance) {
		Queue<String> Q = new LinkedList<>();
		Q.offer(start);
		boolean flag = false;
		while (!Q.isEmpty()) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				String cur = Q.poll();
				int curDistance = distance.get(cur);
				ArrayList<String> neighbors = getNeighbor(cur, wordset);
				for (String neighbor : neighbors) {
					chain.get(cur).add(neighbor);
					if (!distance.containsKey(neighbor)) {
						distance.put(neighbor, curDistance+1);
						if (end.equals(neighbor)) {
							flag = true;
							break;
						}
						else Q.offer(neighbor);
					}
				}
			}
			if (flag) break;
		}
	}
	
	private void dfs(String cur, String endWord, HashMap<String, ArrayList<String>> chain, HashMap<String, Integer> distance, List<String> solution, List<List<String>> result) {
		solution.add(cur);
		if (cur.equals(endWord)) {
			result.add(solution);
			return;
		}
		for (String string : chain.get(cur)) {
			if (distance.containsKey(string) && distance.get(string) == distance.get(cur)+1) {
				dfs(string, endWord, chain, distance, new ArrayList<>(solution), result);
			}
		}
		solution.remove(solution.size()-1);
	}
	
	private ArrayList<String> getNeighbor(String cur, HashSet<String> wordset) {
		ArrayList<String> neighbors = new ArrayList<>();
		char[] chs = cur.toCharArray();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			for (int i = 0; i < chs.length; i++) {
				if (chs[i] == ch) continue;
				char tmp = chs[i];
				chs[i] = ch;
				if (wordset.contains(String.valueOf(chs))) {
					neighbors.add(String.valueOf(chs));
				}
				chs[i] = tmp;
			}
		}
//		for (String word : wordset) {
//			if (word.equals(cur)) continue;
//			char[] chs1 = cur.toCharArray();
//			char[] chs2 = word.toCharArray();
//			int cnt = 0;
//			for (int i = 0; i < chs1.length; i++) {
//				if (cnt > 1) break;
//				if (chs1[i] != chs2[i]) cnt++;
//			}
//			if (cnt == 1) {
//				neighbors.add(word);
//			}
//		}
		return neighbors;
	}
}