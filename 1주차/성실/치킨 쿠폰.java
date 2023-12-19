class Solution {
    public int solution(int chicken) {
        int coupon = chicken;
        int service = 0;
        
        while(true) {
            service += coupon / 10;
            coupon = coupon / 10 + coupon % 10;
            
            if (coupon < 10) {
                break;
            }
        }
        
        
        //int answer = -1;
        //return answer;
        return service;
    }
}
