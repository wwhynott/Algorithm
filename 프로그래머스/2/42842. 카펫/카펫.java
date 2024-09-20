class Solution {
    
    public int[] solution(int brown, int yellow) {
        // brown + yellow = R * C
        // brown = 2R + 2C - 4
        // R, C는 최소 3 이상 (노란색 격자가 생기는 최소한의 길이) 
        int s = 3;
        int e = (brown + yellow)/3; // 한 변의 길이가 최소 3이기 때문에 넓이를 3으로 나눈 길이까지만 탐색 
        
        int[] answer = new int[2];
        
        label:
        for (int r=3; r<=e; r++) {
            for (int c=3; c<=e; c++) {
                if (r*c == brown+yellow) {
                    if ((2*r)+(2*c)-4 == brown) {
                       answer[0] = c;
                        answer[1] = r;
                        break label; 
                    }
                }
            }
        }
        
        return answer;
    }
}