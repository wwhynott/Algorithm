import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        // 2차원배열
        char[][] wpArr = new char[wallpaper.length][wallpaper[0].length()]; 
        
        for (int i=0; i<wallpaper.length; i++) {
        	wpArr[i] = wallpaper[i].toCharArray();
        }
        
        // 파일들의 행 위치 모음
        List<Integer> rList = new ArrayList<>();
        
        // 파일들의 열 위치 모음
        List<Integer> cList = new ArrayList<>();
        
        // 파일들의 행, 열 위치 저장
        for (int i=0; i<wallpaper.length; i++) {
        	for (int j=0; j<wallpaper[0].length(); j++) {
        		if (wpArr[i][j] == '#') {
        			rList.add(i);
        			cList.add(j);
        		}
        	}
        }
        
        // 행, 열의 최소값, 최대값 구하기
        int rMin = Integer.MAX_VALUE;
        int cMin = Integer.MAX_VALUE;
        int rMax = Integer.MIN_VALUE;
        int cMax = Integer.MIN_VALUE;
        
        for (int i=0; i<rList.size(); i++) {
        	if (rList.get(i) < rMin) {
        		rMin = rList.get(i);
        	}
        	if (rList.get(i) > rMax) {
        		rMax = rList.get(i);
        	}
        	
        	if (cList.get(i) < cMin) {
        		cMin = cList.get(i);
        	}
        	if (cList.get(i) > cMax) {
        		cMax = cList.get(i);
        	}
        }
        
        answer[0] = rMin;
        answer[1] = cMin;
        answer[2] = rMax+1;
        answer[3] = cMax+1;
        
        return answer;
    }
}