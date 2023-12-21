class Solution {

    public int[] solution(String[] wallpaper) {

        int[] answer = new int[4];

        int minx=50,miny =50;//탐색하며 점점 작아짐

        int maxx=0, maxy =0;//탐색하며 점점 커짐

        
        //바탕화면 순회(네모칸의 왼쪽 위가 인덱스 기준)
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

        answer[0] = miny;

        answer[1] = minx;

        answer[2] = maxy+1;//네모칸의 우측 하단

        answer[3] = maxx+1;//네모칸의 우측 하단

        return answer;

    }

}


/*
이차원 배열을 순회할 땐 지금 보고있는 지점이 어디인지 명확하게 생각하기.
문제의 엽력과 출력 형태 확인하기.
*/