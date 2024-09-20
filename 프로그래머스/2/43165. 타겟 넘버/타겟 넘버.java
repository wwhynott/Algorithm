class Solution {
    
    static int[] nums;
    static int len;
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        // dfs 
        nums = numbers;
        len = nums.length;
        
        dfs(0, 0, target);
        
        return cnt;
    }
    
    // res : 연산 결과 , t : target number
    static void dfs(int idx, int res, int t) {
        if (idx == len) {
            if (res == t) {
                cnt++;
            }
            return;
        }
        
        res += nums[idx];
        dfs(idx+1, res, t);
        res -= nums[idx]*2;
        dfs(idx+1, res, t);
    }
}