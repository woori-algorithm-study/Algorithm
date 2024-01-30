class Solution {
    static int count = 0;
    static int result;
    
    public static int solution(String skill, String[] skill_trees) {

        for(String s : skill_trees) {
            if(s.contains(skill)) {
                count++;
            } else {
                check(s, skill, skill_trees);
                if(result == 1) count++;
                else continue;
            }
        }

        return count;
    }

    static void check(String s, String skill, String[] skill_trees) {
        result = 1;

        for(int i = 1; i < skill.length(); i++) {
            if(s.contains("" + skill.charAt(i))) {
                int n = s.indexOf(skill.charAt(i));
                //System.out.println(n);
                if(s.substring(0, n).contains(("" + skill.charAt(i-1)))) {
                    continue;
                } else {
                    result = 0;
                    return;
                }
            }
        }
    }

}
