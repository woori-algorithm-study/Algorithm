class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int[][] wall = new int[wallpaper.length][wallpaper[0].length()];
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='.')
                    wall[i][j] = 0;
                if(wallpaper[i].charAt(j)=='#')
                    wall[i][j] = 1;
            }
        }
        
        int min_x = wallpaper.length; 
        int min_y = wallpaper[0].length();
        int max_x = 0;
        int max_y = 0;
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j<wallpaper[i].length();j++){
                if(wall[i][j]==1){
                    if(i<min_x)
                        min_x = i;
                    if(j<min_y)
                        min_y = j;
                    if(i>max_x)
                        max_x = i;
                    if(j>max_y)
                        max_y = j;
                }
            }
        }
        answer[0] = min_x;
        answer[1] = min_y;
        answer[2] = max_x+1;
        answer[3] = max_y+1;
        return answer;
    }
}
