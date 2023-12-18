def solution(chicken):
    answer = -1
    coupone = chicken/10
    service = 0
    while (coupone >0):
        service += coupone
        coupone //=10   
    
    return service # 실행한 결괏값 119.1이 기댓값 120과 다릅니다.
