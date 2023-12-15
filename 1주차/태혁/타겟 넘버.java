import java.util.*;
class Solution {
    public void makemask(ArrayList<int[]> mask, int[] currentMask, int n, int index){
        if(index == n){
            int[] newMask = currentMask.clone();
            mask.add(newMask);
            return;
        }
        currentMask[index] = 1;
        makemask(mask, currentMask, n, index + 1);
        
        currentMask[index] = -1;
        makemask(mask, currentMask, n, index + 1);
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        ArrayList<int[]> mask = new ArrayList<>();
        int n = numbers.length;
        int[] currentMask = new int[n];
        
        makemask(mask, currentMask, n, 0);
        
        for(int[] arr : mask){
            int sum = 0;
            int i = 0;
            for(int k : arr){
                sum += k * numbers[i];
                i++;
            }
            if(sum==target)
                answer++;
        }
        return answer;
    }
}
