import java.util.Stack;
/*
stack의 의미 : 뒷 큰수를 찾기 위한 대기열.(Last In First Out)
스택에 남아있는 숫자(의 인덱스) : 아직 뒷큰수를 찾지 못한 수
스택이 비었음 :  뒷큰수를 찾고있는 수가 없다.
Stack 메서드 참고 : https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
스택은 Vector와 Collection을 상속받아 clear(), stream() 메서드도 사용 가능하다고 함.
*/
class Solution{
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i =0; i<answer.length; i++){
            answer[i] = -1;//정답의 초기값은 -1
        }
        
        for(int j =0; j<numbers.length; j++){
            int now = numbers[j];//현재 탐색 숫자
            while(!stack.empty()){
                int top = numbers[stack.peek()];//스택의 맨 윗 수
                if(now > top){
                    //현재 탐색 숫자가 스택의 맨 위보다 크면
                    int smallNumIdx = stack.pop();
                    answer[smallNumIdx] = now;// 현재 탐색 숫자가 스택 top의 "뒷큰수"   
                }else if(top == now){//스택의 맨 윗수와 현재 탐색 숫자가 같으면
                    //이후에 나오는 큰 수가 지금 탐색하는 수와 스택의 숫자들의 "뒷 큰수"가 되야 함.
                    stack.push(j); break;
                }else{stack.push(j); break;}//작으면 뒷 큰수를 찾기 위한 대기열에 포함
            }
            stack.push(j);//스택이 비어있으면 대기열에 포함
        }
        return answer;
    }
}
