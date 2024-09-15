import java.util.*;

class Solution {
    
    static class Road implements Comparable<Road> {
        int village;
        int time;
        
        Road(int village, int time) {
            this.village = village;
            this.time = time;
        }
        
        // 최소힙을 사용하기 위해 비교 기준 설정
        @Override
        public int compareTo(Road o) {
            return this.time - o.time;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        List<Road>[] connInfo = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            connInfo[i] = new ArrayList<>();
        }
        
        // 도로 정보를 인접 리스트에 저장
        for (int[] r : road) {
            connInfo[r[0]].add(new Road(r[1], r[2]));
            connInfo[r[1]].add(new Road(r[0], r[2]));
        }
        
        // 다익스트라 알고리즘을 위한 최소 힙(PriorityQueue)
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.offer(new Road(1, 0)); // 1번 마을에서 시작, 초기 시간은 0
        
        // 각 마을까지의 최단 시간을 저장하는 배열
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 초기값은 무한대로 설정
        dist[1] = 0; // 시작점인 1번 마을은 시간 0
        
        while (!pq.isEmpty()) {
            Road current = pq.poll();
            int currVillage = current.village;
            int currTime = current.time;
            
            // 현재 노드가 이미 처리된 마을이면 넘어간다.
            if (currTime > dist[currVillage]) {
                continue;
            }
            
            // 인접 마을들에 대해 최단 시간을 갱신
            for (Road neighbor : connInfo[currVillage]) {
                int newTime = currTime + neighbor.time;
                
                // 더 짧은 시간이 있다면 갱신하고 큐에 추가
                if (newTime < dist[neighbor.village]) {
                    dist[neighbor.village] = newTime;
                    pq.offer(new Road(neighbor.village, newTime));
                }
            }
        }
        
        // K시간 이내에 배달이 가능한 마을의 수 계산
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}
