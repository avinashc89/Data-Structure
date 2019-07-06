package com.tool.java.leetcode;

import java.util.*;
import com.tool.java.Util;

public class EvaluateDivision
{

    /*
     Given a / b = 2.0, b / c = 3.0.
    queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
    return [6.0, 0.5, -1.0, 1.0, -1.0 ].

    equations = [ ["a", "b"], ["b", "c"] ],
    values = [2.0, 3.0],
    queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 

     */
    //Using unionfind
    
    class Node {
        public String parent;
        public double ratio;
        public Node(String parent, double ratio) {
          this.parent = parent;
          this.ratio = ratio;
        }
        @Override
        public String toString ()
        {
            // TODO Auto-generated method stub
            return parent+"-"+ratio;
        }
    }
    
    
    class UnionFindSet {
        private Map<String, Node> parents = new HashMap<>();
        
        public Node find(String s) 
        {
          if (!parents.containsKey(s)) return null;
          Node n = parents.get(s);
          if (!n.parent.equals(s)) {
            Node p = find(n.parent);
            n.parent = p.parent;
            n.ratio *= p.ratio;
          }
          return n;
        }
        
        public void union(String s, String p, double ratio)
        {
          boolean hasS = parents.containsKey(s);
          boolean hasP = parents.containsKey(p);
          if (!hasS && !hasP) {
            parents.put(s, new Node(p, ratio));
            parents.put(p, new Node(p, 1.0));
          } else if (!hasP) {
            parents.put(p, new Node(s, 1.0 / ratio));
          } else if (!hasS) {
            parents.put(s, new Node(p, ratio));
          } else {
            Node rS = find(s);
            Node rP = find(p);
            rS.parent = rP.parent;
            rS.ratio = ratio / rS.ratio * rP.ratio;
          }
        }
      }
    
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFindSet u = new UnionFindSet();
        
        //union all the equation
        for (int i = 0; i < equations.size(); ++i)
          u.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        
        double[] ans = new double[queries.size()];
        
        //evaluate queries
        for (int i = 0; i < queries.size(); ++i) 
        {      
          Node rx = u.find(queries.get(i).get(0));
          Node ry = u.find(queries.get(i).get(1));
          if (rx == null || ry == null || !rx.parent.equals(ry.parent))
            ans[i] = -1.0;        
          else
            ans[i] = rx.ratio / ry.ratio;
        }
        Util.printArray(ans);
        return ans;
      }
        
       
    
    public static void main (String[] args)
    {
        EvaluateDivision e = new EvaluateDivision();
        List<List<String>> equations = new ArrayList<List<String>>();
        equations.add( new ArrayList<String>(){{ add("a");add("b"); }});
        equations.add( new ArrayList<String>(){{ add("b");add("c"); }});
//        equations.add( new ArrayList<String>(){{ add("a");add("d"); }});
//        equations.add( new ArrayList<String>(){{ add("b");add("d"); }});
        
        double[] values = {2.0, 3.0, 4.0 , 5.0};
        
        List<List<String>> queries = new ArrayList<List<String>>();
        queries.add(new ArrayList<String>(){{ add("a");add("c"); }});
        queries.add(new ArrayList<String>(){{ add("b");add("a"); }});
        queries.add(new ArrayList<String>(){{ add("a");add("e"); }});
        queries.add(new ArrayList<String>(){{ add("a");add("a"); }});
        queries.add(new ArrayList<String>(){{ add("x");add("x"); }});
        
        e.calcEquation(equations , values , queries);
    }
}
