class Solution {

    public int[] solution(String[] wallpaper) {

        int[] answer = new int[4];

        int minx=50,miny =50;

        int maxx=0, maxy =0;

        

        for(int i =0; i<wallpaper.length; i++){

            for(int j=0; j<wallpaper[0].length(); j++){

                if(wallpaper[i].charAt(j) == '#'){

                    if(miny > i){miny = i;}

                    if(minx> j){minx=j;}

                    if(maxy<i){maxy = i;}

                    if(maxx<j){maxx=j;}

                }

            }

        }

        answer[0] = minx;

        answer[1] = miny;

        answer[2] = maxx;

        answer[3] = maxy;

        return answer;

    }

}