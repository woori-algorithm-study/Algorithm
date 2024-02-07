class Solution {
    String sk;
    public int solution(String skill, String[] skill_trees) {
        sk = skill+"";
        int answer = 0;
        for(int i=0; i<skill_trees.length; i++){//skill_trees의 항목이 가능하면 개수 카운트
            if(is_valid(skill_trees[i])){answer++;
             //System.out.println(skill_trees[i]+"is valid!");
            }
        }
        return answer;
    }
        
    public boolean is_valid(String tree){
        //charAt - 해당 인덱스의 문자 반환:IndexOutOfBoundsException 주의
        //indexOf - 해당하는 문자의 인덱스 반환:해당하는 문자가 없으면 -1 반환
        boolean result = true;
        int skillIdx = 0; //skill 탐색
        for(int i=0; i<tree.length(); i++){
            int idx = sk.indexOf(tree.charAt(i));
            if(idx == -1) continue; //skill과 관련 없는 문자
            else if(idx == skillIdx) skillIdx++; //순서대로 나온 skill의 문자, 다음 skill 문자 탐색
            else{return false;}//순서대로 나오지 않음
        }
        return result;//skill에 있는 모든 문자가 순서대로 포함되어있음 || skill제약조건을 피해가는 문자들만 있음
    }
}
