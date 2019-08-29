package com.tool.java.leetcode;

import java.util.*;

public class ItineraryReconstruction
{
    
    // build the graph. with neighbors in sorted list. 
    // Back track it. 
    // since we have already sorted the neighbors, the first encounter of numTickets == numTicketsUsed => ie., used all tickets, will already be sorted.

    HashMap<String, LinkedList<String>> map = new   HashMap<String, LinkedList<String>>();
    LinkedList<String> result = new LinkedList<String>();
    
    int numTickets = 0;
    int numTicketsUsed = 0;
    
    public List<String> findItinerary(List<List<String>> tickets) 
    {
        
        if(tickets == null || tickets.size() == 0)
        {
            return result;
        }
        
        numTickets = tickets.size();
        
        for(List<String> ticket : tickets)
        {
            if(map.containsKey(ticket.get(0))){
                 map.get(ticket.get(0)).add(ticket.get(1));
            }
            else{
                LinkedList<String> tmp = new LinkedList<String>();
                tmp.add(ticket.get(1));
                map.put(ticket.get(0), tmp);
            }
        }
        
        for (Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        
        result.add("JFK");
        
        itineraryHelper("JFK");
        
        return result;
    }

    private void itineraryHelper (String currCity)
    {
       if(!map.containsKey(currCity))
           return;
       LinkedList<String> list = map.get(currCity);
       
       for(int i=0; i<list.size(); i++)
       {
           String nextCity = list.get(i);
           
           list.remove(i);
           result.add(nextCity);
           numTicketsUsed++;
           
           itineraryHelper(nextCity);
           
           if (numTickets == numTicketsUsed) return;
           
           list.add(i,nextCity);
           numTicketsUsed--;
           result.removeLast();
       }
    }
    
    public static void main (String[] args)
    {
        ItineraryReconstruction i = new ItineraryReconstruction();
        
        //[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        List<List<String>> tickets = new ArrayList<List<String>>();
        tickets.add(Arrays.asList(new String[]{"MUC","LHR"}));
        tickets.add(Arrays.asList(new String[]{"JFK","MUC"}));
        tickets.add(Arrays.asList(new String[]{"SFO","SJC"}));
        tickets.add(Arrays.asList(new String[]{"LHR","SFO"}));
        
       System.out.println(i.findItinerary(tickets));
    }
}
