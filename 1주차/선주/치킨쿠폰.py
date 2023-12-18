def solution(chicken):
    answer = -1
    coupone = chicken%10 + chicken//10
    service = chicken//10
    
    while(coupone > 9):
        service += coupone//10
        coupone = coupone%10 + coupone//10
        
    return service
