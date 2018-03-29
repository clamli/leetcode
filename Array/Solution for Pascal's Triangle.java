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
import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import javax.tools.ToolProvider;
import javax.xml.ws.Endpoint;

import org.omg.CORBA.Current;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.css.ElementCSSInlineStyle;

class Solution {
    public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		
        for (int i = 0; i < numRows; i++) {
        	if (result.isEmpty()) result.add(new ArrayList<>(Arrays.asList(1)));
        	else if (result.size() == 1) result.add(new ArrayList<>(Arrays.asList(1,1)));
        	else {
        		List<Integer> tmp = new ArrayList<>();
        		tmp.add(1);
        		List<Integer> last = result.get(result.size()-1);
        		for (int j = 0; j < last.size()-1; j++) {
        			tmp.add(last.get(j)+last.get(j+1));
        		}
        		tmp.add(1);
        		result.add(tmp);
        	}
        }
        
        return result;
    }
}