class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            String s = skill_trees[i];
            String str = s;
            
            for (int j = 0; j < s.length(); j++) {
                String tmp = s.substring(j, j+1);
                
                // System.out.println("tmp: " + tmp);
                if (!skill.contains(tmp)) {
                    str = str.replace(tmp, "");
                }
                // System.out.println("str: " + str);
            }
            // System.out.println("==============");
            
            if (skill.indexOf(str) == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}