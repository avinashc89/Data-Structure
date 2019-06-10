
public class Combination01_
{
    // Find all binary strings that can be formed from given
    // wildcard pattern
    private static void printAllCombinations(char pattern[], int i)
    {
        if (i == pattern.length)
        {
            System.out.println(pattern);
            return;
        }
 
        // if the current character is '?'
        if (pattern[i] == '?')
        {
            for (char ch = '0'; ch <= '1'; ch++)
            {
                // replace '?' with 0 and 1
                pattern[i] = ch;
                // recur for the remaining pattern
                printAllCombinations(pattern, i + 1);
            }
            pattern[i] = '?';
            return;
        }
 
        // if the current character is 0 or 1, ignore it and
        // recur for the remaining pattern
        printAllCombinations(pattern, i + 1);
    }
 
    public static void main(String[] args)
    {
        char[] pattern = "1?11?00?1?".toCharArray();
        printAllCombinations(pattern, 0);
    }
}