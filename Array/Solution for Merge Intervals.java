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
import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	
//	private HashMap<Interval, List<Interval> > graph = new HashMap<>();
//	private HashMap<Integer, List<Interval> > component = new HashMap<>();
//	private HashMap<Interval, Boolean> visit = new HashMap<>();
//	
//	private boolean overlap(Interval a, Interval b) {
//		return (a.end >= b.start && a.start <= b.end);
//	}
//	
//	private void buildGraph(List<Interval> intervals) { 
//		for (Interval interval: intervals) {
//			graph.put(interval, new LinkedList<>());
//		}
//		
//		for (Interval interval1: intervals) {
//			for (Interval interval2: intervals) {
//				if (overlap(interval1, interval2)) graph.get(interval1).add(interval2);
//			}
//		}
//	}
//	
//	private void DFS(Interval interval, int seqnum) {
//		Stack<Interval> S = new Stack<>();
//		S.push(interval);
//		while (!S.empty()) {
//			Interval top = S.pop();
//			if (!visit.containsKey(top)) {
//				visit.put(top, true);
//				if (!component.containsKey(seqnum)) {
//					component.put(seqnum, new LinkedList<>());
//				}
//				component.get(seqnum).add(top);
//				for (Interval ele: graph.get(top)) {
//					S.push(ele);
//				}
//			}
//		}
//	}
//	
//	private void buildComponent(List<Interval> intervals) {
//		int seqnum = 0;
//		for (Interval interval: intervals) {
//			if (!visit.containsKey(interval)) {
//				DFS(interval, seqnum++);
//			}
//		}
//	}
//	
//	Interval mergeInterval(List<Interval> list) {
//		int left = list.get(0).start;
//		for (Interval interval: list) {
//			if (interval.start < left) left = interval.start;
//		}
//		
//		int right = list.get(0).end;
//		for (Interval interval: list) {
//			if (interval.end > right) right = interval.end;
//		}
//		
//		return new Interval(left, right);
//	}
//	
//	public List<Interval> merge(List<Interval> intervals) {
//		List<Interval> result = new LinkedList<>();
//		
//		buildGraph(intervals);
//		buildComponent(intervals);
//		
//		
//		for (int i = 0; i < component.size(); i++) {
//			result.add(mergeInterval(component.get(i)));
//		}
//		
//		return result;
//	}
	
	private class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval a, Interval b) {
			return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
		}
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		LinkedList<Interval> result = new LinkedList<>();
		
		Collections.sort(intervals, new IntervalComparator());
		
		for (Interval interval: intervals) {
			if (result.isEmpty() || result.getLast().end < interval.start) {
				result.add(new Interval(interval.start, interval.end));
			} else {
				result.getLast().end = Math.max(result.getLast().end, interval.end);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}