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
    // method 1: O(nlogn)
    // public int findKthLargest(int[] nums, int k) {
    //     Arrays.sort(nums);
    //     return nums[nums.length-k];
    // }

    
    // method 2: quicksort
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1, k);
    }
    
    private int quickSort(int[] nums, int lo, int hi, int k) {
        int i = lo, j = hi, pivot = hi, num;
        while (i < j) {
            if (nums[i++] < nums[pivot]) {
                swap(nums, --i, --j);
            }
        }
        swap(nums, pivot, i);
        num = i + 1;
        if (num == k) return nums[i];
        else if (num > k) return quickSort(nums, lo, i-1, k);
        else return quickSort(nums, i+1, hi, k);
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}