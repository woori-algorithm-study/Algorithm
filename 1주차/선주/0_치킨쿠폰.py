def solution(chicken):
    answer = -1
    coupone = chicken%10 + chicken//10
    service = chicken//10
    
    while(coupone > 9): #치킨을 쿠폰으로 살 수 있을 때
        service += coupone//10 #쿠폰 10개로 치킨 한마리 먹을 수 있음
        coupone = coupone%10 + coupone//10 #쿠폰 사용 후 남은 쿠폰 + 10개 묶음으로 사용한 쿠폰 반영
        
    return service
