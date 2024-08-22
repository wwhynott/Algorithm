class Solution {
    public int[] solution(int[] prices) {
        // for문 돌면서 pricex[idx] 값보다 작은 값이 나올때까지 cnt ++
        // for문 중간에 작은 값이 나오면 끊기
        // answer[idx] = cnt
        int len = prices.length;
        int[] answer = new int[len];
        
        for (int i=0; i<len; i++) {
            int cnt = 0;
            int n = prices[i];
            
            if (i == len-1) {
                answer[i] = 0;
                break;
            }
            
            for (int j=i+1; j<len; j++) {
                cnt++;
                if (prices[j] < n || j == len-1) {
                    answer[i] = cnt;
                    break;
                }
            }
        }
        
        
        return answer;
    }
}