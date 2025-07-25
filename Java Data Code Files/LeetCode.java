/*import java.lang.*;
class Solution {
    public int myAtoi(String s) {
        s.trim();
        String[] Arr=new String[s.length()];
        for (int i=0;i<s.length();i++){
            Arr[i]=String.valueOf(s.charAt(i));
        }
        StringBuilder str=new StringBuilder();
        for (String elemString:Arr){
            if (elemString.equals("-")){
                str.append("-");
            }
        }
        for (int i=0;i<Arr.length;i++){
            if (Arr[i].equals("0") || Arr[i].equals("1") || Arr[i].equals("2") || Arr[i].equals("3") || Arr[i].equals("4") || Arr[i].equals("5") || Arr[i].equals("6") || Arr[i].equals("7") || Arr[i].equals("8") || Arr[i].equals("9")){
                str.append(Arr[i]);
            }
        }
        return Integer.parseInt(str.toString());
    }    
    public static void main(String[] args) {
        Solution obj=new Solution();
        System.out.println(obj.myAtoi("1337c0d3"));
    }
}*/

/*import java.util.*;
class Solution {
    public static int numberOfSubstrings(String s) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder store = new StringBuilder();
            int countA = 0, countB = 0, countC = 0;
            for (int j = i; j < s.length(); j++) {
                store.append(s.charAt(j));
                if (s.charAt(j) == 'a') countA++;
                if (s.charAt(j) == 'b') countB++;
                if (s.charAt(j) == 'c') countC++;
                if (countA > 0 && countB > 0 && countC > 0) {
                    pq.add(store.toString());
                }
            }
        }
        return pq.size();
    }

    public static void main(String args[]) {
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaacb"));
        System.out.println(numberOfSubstrings("abc"));
    }
}*/

/*import java.util.*;
class Solution {
    public static int maximumCandies(int[] candies, long k) {
        long Sum = 0;
        int Max = 0;
        for (int candy : candies) {
            Sum += candy;
            Max = Math.max(Max, candy);
        }
        if (Sum < k) 
        return 0;
        int left = 1, right = Max, result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long count = 0;
            for (int candy : candies) {
                count += candy / mid;
            }
            if (count >= k) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}*/

/*import java.util.*;
class Solution {
    public int minCapability(int[] nums, int k) {
        int Min = 1;
        int Max = Arrays.stream(nums).max().getAsInt();
        while (Min < Max) {
            int Mid = (Min + Max) / 2;
            int Temp = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] <= Mid) {
                    Temp += 1;
                    i++;
                }
            }
            if (Temp >= k) 
            Max = Mid;
            else 
            Min = Mid + 1;
        }
        return Min;
    }
}*/

/*class Solution {
    class Solution {
        public long minTime(int[] skill, int[] mana) {
            int n = skill.length;
            int m = mana.length;
            int[][] store = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    store[i][j] = skill[i] * mana[j];
                }
            }
            long[][] time = new long[n][m];
            for (int j = 0; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    if (i == 0 && j == 0) {
                        time[i][j] = store[i][j];
                    } else if (i == 0) {
                        time[i][j] = time[i][j - 1] + store[i][j];
                    } else if (j == 0) {
                        time[i][j] = time[i - 1][j] + store[i][j];
                    } else {
                        time[i][j] = Math.max(time[i - 1][j], time[i][j - 1]) + store[i][j];
                    }
                }
            }
            return time[n - 1][m - 1];
        }
    }
}*/

/*import java.util.TreeSet;
import java.util.Arrays;
import java.util.List;
class Solution {
    public static int countDays(int days, int[][] meetings) {
        TreeSet<Integer> list = new TreeSet<>();
        for (int[] meeting : meetings) {
            for (int i=meeting[0];i<=meeting[1];i++) {
                list.add(i);
            }
        }
        int Count=0;
        for (int i=1;i<=days;i++){
            if (!list.contains(i)){
                Count++;
            }
        }
        return Count;
    }
    public static void main(String[] args) {
        int[][] arr = {{5, 7}, {1, 3}, {9, 10}};
        System.err.println(countDays(10, arr));
    }
}*/

/*import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner Sc=new Scanner(System.in);
        int Number=Sc.nextInt();
        if (Number<1) return;
        int Store=Term(Number);
        System.out.println(Store);
    }
    public static int Term(int Number){
        int Count=0;
        int Num=2;
        while(true){
            if (Prime(Number)){
                Count++;
                if (Count==Number) {
                    return Num*Num;
                }
            }
            Num++;
        }
    }
    public static boolean Prime(int Num){
        if(Num<=1) return false;
        if(Num==2) return true;
        if(Num%2==0) return false;
        for (int i=3;i*i<=Num;i+=2){
            if (Num%i==0)
                return false;
        }
        return true;
    }
}*/

/*import java.util.*;
class Solution{
    public static void main(String args[]){
        try(Scanner Sc=new Scanner(System.in)){
            int Number=Sc.nextInt();
            System.out.print(Count(Number));
        }
    }
    public static int Count(int Number){
        int Count=0;
        for (int i=1;i<=Number;i++){
            if (Prime(i)){
                Count++;
            }
        }
        return Count;
    }
    public static boolean Prime(int Num){
        if(Num<=1) return false;
        if(Num==2) return true;
        if(Num%2==0) return false;
        for (int i=3;i*i<=Num;i+=2){
            if (Num%i==0)
                return false;
        }
        return true;
    }
}*/

/*class LeetCode{
    public static void main(String args[]){
        int[] nums={999,997,980,976,948,940,938,928,924,917,907,907,881,878,864,862,859,857,848,840,824,824,824,805,802,798,788,777,775,766,755,748,735,732,727,705,700,697,693,679,676,644,634,624,599,596,588,583,562,558,553,539,537,536,509,491,485,483,454,449,438,425,403,368,345,327,287,285,270,263,255,248,235,234,224,221,201,189,187,183,179,168,155,153,150,144,107,102,102,87,80,57,55,49,48,45,26,26,23,15};
        System.out.println(Get(nums));
    }
    public static int Get(int nums[]){
        int Max=-1;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length&&i!=j;j++){
                int Value=nums[j]-nums[i];
                if (Value>Max){
                    Max=Value;
                }
            }
        }
        return Max;
    }
}*/

/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeetCode {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 8, 7, 9, 3, 5, 1 };
        Arrays.sort(arr);
        int k = 2;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i += 3) {
            int val1 = arr[i];
            int val2 = arr[i + 1];
            int val3 = arr[i + 2];
            if (Math.abs(val1 - val2) <= k && Math.abs(val1 - val3) <= k && Math.abs(val2 - val3) <= k) {
                List<Integer> store = Arrays.asList(val1, val2, val3);
                result.add(store);
            }
        }
        System.out.println(result);
        if (result.size()%3!==0)
        return new List();
    }
}*/

/*import java.util.ArrayList;

class LeetCode {
    public static int partitionArray(int[] nums, int k) {
        ArrayList<Integer> store=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            int Max=Math.max(nums[i], nums[i+1]);
            int Min=Math.min(nums[i], nums[i+1]);
            if ((Max-Min)<=k){
                store.add(nums[i]);store.add(nums[i+1]);
                i=i+2;
            }
            int[] temp=store.toArray();
        }
    }
    public static void main(String[] args) {
        System.err.println(partitionArray(new int[]{3,6,1,2,5},2));
    }
}*/

/*import java.util.*;
class LeetCode{
    public static void main(String args[]){
        String s="NSWE";
        int[] store=new int[s.length()];
        for(int i=0;i<store.length;i++){
            if (s.charAt(i)=='N') store[i]=1;
            if (s.charAt(i)=='S') store[i]=-1;
            if (s.charAt(i)=='W') store[i]=-1;
            if (s.charAt(i)=='E') store[i]=1;
        }
        int dist=Math.abs(0)+Math.abs(store[0]);
        for (int i=1;i<s.length();i++){
            if ()
            for (int j=0;j<4;j++){
                
            }
        }
    }
}*/

/*import java.util.*;
class LeetCode{
    public static void main(String args[]){
        char[] store="aabcaba".toCharArray();
        HashSet<Character> uniques=new HashSet<>();
        for(char check:store){ uniques.add(check); };
        List<Integer> frequency=new ArrayList<>();
        for(char elemString:uniques){
            int count=0;
            for (char check:store){
                if (elemString==check)
                count++;
            }
            frequency.add(count);
        }
        ArrayList<Integer> Match=new ArrayList<>();
    }
}*/

// import java.util.*;
// class LeetCode {
//     public static String[] divideString(String s, int k, char fill) {
//         ArrayList<String> store=new ArrayList<>();
//         for (int i=1;i<=k;i++){
//             int count=0;
//             String substring=s.substring(i*count,k*i);
//             if (substring.length()==k)
//             store.add(substring);
//             else
//             store.add(substring+"x");
//             count++;
//         }
//         String[] result=new String[k];
//         int Counter=0;
//         for (String eleString:store){
//             result[Counter++]=eleString;
//         }
//         return result.toString();
//     }
//     public static void main(String[] args) {
//         System.err.println(divideString("abcdefghi", 3, 'x'));
//     }
// }

import java.util.*;
class LeetCode {
    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long[] arr=new long[nums1.length*nums2.length];
        long count=0L;
        for (int element1:nums1){
            for (int element2:nums2){
                arr[count++]=element1*element2;
            }
        }
        return arr[k];
    }
    public static void main(String[] args) {
        System.err.println(kthSmallestProduct(new int[]{-2,-1,0,1,2},new int[]{-3,-1,2,4,5},3));
    }
}