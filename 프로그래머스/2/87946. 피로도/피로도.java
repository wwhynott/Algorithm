class Solution {
    
    static int[][] dgArr;
    static boolean[] visit;
    static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        dgArr = dungeons;
        visit = new boolean[dungeons.length];


        dfs(0, k);


        int answer = max;
        return answer;
    }
    
    // num : 방문한 던전 개수, k : 피로도
    static void dfs(int num, int k) {
        // 리턴조건 ,, 어케줌
        // 끝까지 갔다고 리턴하면 안되고
        // 뒤쪽 던전 먼저 갔다가 앞에도 방문 가능한 던전이 있다면 방문해야함,,!!!
        // 던전 방문은 for문 돌면서 ㄱㄱ
        // 최소피로도 소모피로도 둘다 고려해서 리턴?
//        if (dgArr[idx][0] > k) {
//            return;
//        }
        // 리턴 안해!

        for (int i=0; i<dgArr.length; i++) {
            if (!visit[i] && dgArr[i][0] <= k) {
                // 한번이라도 dfs 들어가면 flag = true;
                // 피로도 소모
                visit[i] = true;
                dfs(num+1, k-dgArr[i][1]);
                // 지금 저 던전 안갈거다?
                // 방문처리 원복
                visit[i] = false;
            }
        }

        max = Math.max(max, num);
    }
}