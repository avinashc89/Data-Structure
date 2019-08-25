package com.tool.java.leetcode;

import java.util.*;

public class SplitwiseOptimalAccountBalancing
{
    
    /*
     Splitwise simplify group
     
     input : [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]   
     Output:1
        Explanation:
        Person #0 gave person #1 $10.
        Person #1 gave person #0 $1.
        Person #1 gave person #2 $5.
        Person #2 gave person #0 $5.
        
        Therefore, person #1 only need to give person #0 $4, and all debt is settled.
        
        
     */

//    public static  int minTransfers(int[][] transactions) {
//        Map<Integer, Integer> debts = new HashMap();
//        for (int[] t : transactions) {        
//            debts.put(t[0], debts.getOrDefault(t[0], 0) - t[2]);            
//            debts.put(t[1], debts.getOrDefault(t[1], 0) + t[2]);
//        }
//        //{0=-4, 1=4, 2=0} ie., At last 0 gave 4$, 1 got 4$.
//        
//        List<Integer> list = new ArrayList(debts.values());
//        Collections.sort(list);
//        int numOfTrans = 0;
//        for (int i = 2; i <= list.size(); i++) {
//            boolean flag = evenUp(list, 0, i);
//            while(flag) 
//                numOfTrans += (i - 1);
//        }
//        
//        return numOfTrans;
//    }
//    
//    static  boolean evenUp(List<Integer> balance, int sum, int num) {
//        if (num == 0) return sum == 0;
//        for (int i = 0; i < balance.size(); i++) {
//            if (balance.get(i) != 0) {
//                int ori = balance.get(i);
//                balance.set(i, 0);
//                if (evenUp(balance, sum - ori, num - 1)) return true;
//                balance.set(i, ori);
//            }
//        }
//        return false;
//    }
    
    public static int minTransfers(int[][] transactions) {
        int[] debt = buildDebtArray(transactions); // Debt amount to balance for each person.
        Arrays.sort(debt);
        
        //opt 2
        //to remove -6 & +6 negative and positive values. traversing from each side and check if sum =0, if sum>0, move r, else move l.
        int l=0, r=debt.length-1, n=0;
        Set<Integer> set = new HashSet<>();
        int ans=0;
        while(l<r){
            if(debt[l]+debt[r]==0){
                ans++;
                set.add(l); set.add(r);
                l++;r--;
            }else if(debt[l]+debt[r]<0) l++;
            else r--;
        }
        int[] target= new int[debt.length- set.size()];
        int index=0;
        for(int i=0;i<debt.length; i++){
            if(!set.contains(i)) target[index++]=debt[i];
        }
        
        return ans+dfs(0, target);
    }
    
    private static int dfs(int id, int[] debt) {
        while (id < debt.length && debt[id] == 0) id++;
        // Base case.
        if (id == debt.length)
            return 0;
        // Recursive case. => using dfs 
        /*
         case 3 is also the really work case is try to find a account whose  balance is opposite from current account.
        then just transfer all the money in current account to the account which has opposite balance. 
        In this way, current account will be balanced and the total unbalanced account will be decreased.
        say:   current balance is 10, you find a account has -5, then you transfer this 10 to the other account, current is 0 and the other will have 5
               current balance is -5, and you find a account has 10, then you transfer -5 yo the other account, current is 0 and the other will have 5,
        in both cases, the un-balanced accounts will decreased by one. and eventually, all accounts will be balanced.
        that's the reason has to find a opposite   balance account aka:  x*y<0  aka:   if (debt[i] * debt[id] < 0) 
         */
        int min = Integer.MAX_VALUE;
        for (int i = id + 1; i < debt.length; i++) {
            if (debt[i] * debt[id] < 0) {
                debt[i] += debt[id];
                min = Math.min(min, 1+dfs(id + 1, debt));
                debt[i] -= debt[id];             // back to original state
            }
        }
        
        return min;
    }
    
    private static int[] buildDebtArray(int[][] transactions) {
        Map<Integer, Integer> debtMap = new HashMap<>(); // Map person ID to debt amount.
        for (int[] transaction : transactions) {
            int giver = transaction[0];
            int taker = transaction[1];
            int amount = transaction[2];
            debtMap.put(giver, debtMap.getOrDefault(giver, 0) + amount);
            debtMap.put(taker, debtMap.getOrDefault(taker, 0) - amount);
        }
        
        //opt 1 remove accounts having 0
        Map<Integer, Integer> ans = new HashMap<>();
        for(Map.Entry<Integer,Integer> e: debtMap.entrySet()){
            if(e.getValue()==0) continue;
            ans.put(e.getKey(), e.getValue());
        }
        
        int[] debt = new int[ans.size()];
        int i = 0;
        for (int amount : ans.values()) {
            debt[i++] = amount;
        }
        
        return debt;
    }
    
    public static void main (String[] args)
    {
        int[][] txn = new int[][]{{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}, {0,3,5}, {3,1,2}};
        System.out.println(minTransfers(txn));
        
    }
    
    
}
