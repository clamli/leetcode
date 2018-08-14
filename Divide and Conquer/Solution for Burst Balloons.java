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
    //     method 1
//     public int maxCoins(int[] nums) {
//         List<Integer> nums_lst = new ArrayList<>();
//         for (int num : nums)
//             nums_lst.add(num);
//         return findMax(nums_lst, -1);
//     }
    
//     private int findMax(List<Integer> nums_lst, int removed) {
//         if (removed != -1) nums_lst.remove(removed);
//         int max = 0;
//         for (int i = 0; i < nums_lst.size(); i++) {
//             int coin = nums_lst.get(i);
//             if (i != 0) coin *= nums_lst.get(i-1);
//             if (i != nums_lst.size()-1) coin *= nums_lst.get(i+1);
//             max = Math.max(max, coin + findMax(new ArrayList<>(nums_lst), i));
//         }
//         return max;
//     }
    
    // method 2 : divide and conquer
//     public int maxCoins(int[] nums) {
//         int[] newNums = new int[nums.length+2];
//         int idx = 1;
//         newNums[0] = 1;
//         for (int num : nums) {
//             if (num != 0)
//                 newNums[idx++] = num;
//         }
//         newNums[idx++] = 1;
//         int[][] cached = new int[idx][idx];
//         return findMax(cached, newNums, 0, idx-1);
//     }
    
//     private int findMax(int[][] cached, int[] newNums, int start, int end) {
//         int max = 0, multi = newNums[start]*newNums[end];
//         if (cached[start][end] != 0) return cached[start][end];
//         // if (start+1 == end) return 0;
//         for (int i = start + 1; i < end; i++) {
//             max = Math.max(max, newNums[i]*multi+findMax(cached, newNums, start, i)+findMax(cached, newNums, i, end));
//         }
//         cached[start][end] = max;
//         return max;
//     }
    
    // method 3 : dp
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length+2];
        int idx = 1;
        newNums[0] = 1;
        for (int num : nums) {
            if (num != 0)
                newNums[idx++] = num;
        }
        newNums[idx++] = 1;
        int[][] dp = new int[idx][idx];
        for (int k = 2; k < idx; k++) {
            for (int left = 0; left < idx-k; left++) {
                int right = left+k;
                for (int i = left+1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], newNums[left]*newNums[i]*newNums[right]+dp[left][i]+dp[i][right]);
                }
            }
        }
        return dp[0][idx-1];
    }
}