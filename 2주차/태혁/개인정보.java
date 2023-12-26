import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        Map<String,Integer> term = new HashMap<>();
        String[] split = today.split("\\.");
        int today_year = Integer.parseInt(split[0]);
        int today_month =Integer.parseInt(split[1]);
        int today_day =Integer.parseInt(split[2]);
        
        for(int i = 0; i < terms.length; i++){
            String[] sp = terms[i].split(" ");
            term.put(sp[0],Integer.parseInt(sp[1]));
        }
        
        Vector<Integer> a = new Vector<>();
        for(int i = 0; i<privacies.length; i++){
            String[] sp = privacies[i].split(" ");
            String[] days= sp[0].split("\\.");
            int year = Integer.parseInt(days[0]);
            int month = Integer.parseInt(days[1]);
            int day = Integer.parseInt(days[2]);
            
            int num = term.get(sp[1]);
            day--;
            if(day<1){
                day = 28;
                month--;
                if(month>12)
                    year++;
            }
            month += num;
            while(month>12){
                month -= 12;
                year++;
            }
            System.out.printf("%d.%d.%d\n",year,month,day);
            if(today_year > year){
                a.add(i+1);
            }else if(today_year==year){
                if(today_month>month)
                    a.add(i+1);
                else if(today_month==month)
                    if(today_day>day)
                        a.add(i+1);
            }
            
        }
        answer = new int[a.size()];
        for(int i = 0; i<a.size();i++){
            answer[i] = a.get(i);
        }
        return answer;
    }
}
