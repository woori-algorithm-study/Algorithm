function solution(lines) {

    var [a,b,c] = lines;

    let answer = 0;

    //선분 시작점에 따라 정렬

    if(a[0]<b[0]){

        lines = (b[0]<c[0])? [a,b,c] : (c[0]<a[0])? [c,a,b]:[a,c,b]; //abc acb cab

    }else{//bac bca cba

        lines = (c[0]<a[0]) ? [c,b,a] : (b[0]<c[0])? [b,a,c]:[b,c,a];

    }

    //console.log(lines);    

    //겹치지 않는 선분들의 경우 거르기

    if(a[1]<=b[0] && b[1]<=c[0])return 0;

    //겹치는 곳의 길이의 합 구하기
    answer += Math.abs(a[1]-b[0]);
    answer += Math.abs(b[1]-c[0]);
    answer += Math.abs(a[1]-c[0]);
    

    return answer;
};