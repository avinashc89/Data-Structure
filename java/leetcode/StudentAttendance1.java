package com.tool.java.leetcode;

public class StudentAttendance1
{
    
    /*
     
     A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
     
     Input: "PPALLP"
    Output: True
    
    Input: "PPALLL"
    Output: False
      
     */
    public boolean checkRecord(String s) {
        
     if(s == null || s.isEmpty())
         return true;
     
     int countA = 0;
     int countL = 0 ;
     for(int i=0; i< s.length() ; i++)
     {
         if(s.charAt(i) == 'A'){
             countL=0;
             countA++;
             if(countA >1)
                 return false;
         }
         else if(s.charAt(i) == 'L'){
             countL++;
             if(countL>2)
                 return false;
         }
         else
         {
             countL=0;
         }
     }
     return true;
    }
    
    public static void main (String[] args)
    {
        StudentAttendance1 a = new StudentAttendance1();
        
        System.out.println(a.checkRecord("PPALLP"));
        System.out.println(a.checkRecord("PPALLL"));
    }
}
