function solution(today, terms, privacies) {
    var answer = [];
    const contractMonth = {} //contractMonth{약정종류 : 약정 기간}
    for(let term of terms){
        let contract = term[0]
        let month = Number(term.substring(2))
        contractMonth[contract]= month
    }
    const customerinformation = [] //약정 종류
    const contractdate = [] //가입 날짜
    for(let privacy =0 ; privacy<privacies.length; privacy++){
        let contract = privacies[privacy].slice(privacies[privacy].indexOf(' ')+1)
        let date = privacies[privacy].slice(0,privacies[privacy].indexOf(' '))
        customerinformation.push(contract) //약정 종류 push
        contractdate.push(date) //가입 날짜 push
    }
    const caculMonth = [] //약정 종류 별 약정 기간 넣을 arr 
    for(let customercontractdate of customerinformation) { //약정 기간 뽑아오기
        caculMonth.push(contractMonth[customercontractdate]) //약정 기간 push        
    }
    for(let i =0; i <contractdate.length; i++){
        let passMonth = Number(contractdate[i].slice(5,7)) + Number(caculMonth[i]%12)
        let passYear = Number(contractdate[i].slice(2,4)) + parseInt(caculMonth[i]/12)
        if (passMonth > 12) { 
            passYear = passYear + parseInt(passMonth / 12)
            passMonth = passMonth % 12
            // 여기서 if month ==0을 처리하게 되는 이유는 month가 12 초과하는 12의 배수인 경우에 해당하므로, 위에서 처리
            // 위에서 미리 나눴으므로 23이 최대치이므로 예외가 발생하지 않게 된다.
          }
        if(passMonth < 10) {
            passMonth = "0" + passMonth
        }
        if (Number(contractdate[i].slice(2,4))+passYear < 10) {
            contractdate[i] = contractdate[i].slice(0,2) + "0" + passYear + "." + passMonth + contractdate[i].slice(7)
        } else {
            contractdate[i] = contractdate[i].slice(0,2) + passYear + "." + passMonth + contractdate[i].slice(7)
        }
        
        
    }
    console.log(contractdate)
    for(let endDate=0; endDate < contractdate.length; endDate++){
        let compareNum = contractdate[endDate].slice(2).replaceAll('.','')
        let todayNum = today.slice(2).replaceAll('.' , '')
        console.log(compareNum,"compareNum")
        console.log(todayNum,"todayNum")
        if (Number(compareNum) <= Number(todayNum)) {
            answer.push(endDate + 1)
        }
    }
    
    return answer;
}
