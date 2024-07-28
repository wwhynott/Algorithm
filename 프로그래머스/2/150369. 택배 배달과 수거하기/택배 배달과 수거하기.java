class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long totalDistance = 0;
        int currentDelivery = 0;
        int currentPickup = 0;

        // 먼 집부터 역순으로 처리
        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] > 0 || pickups[i] > 0) {
                int trips = 0;
                while (currentDelivery < deliveries[i] || currentPickup < pickups[i]) {
                    trips++;
                    currentDelivery += cap;
                    currentPickup += cap;
                }
                currentDelivery -= deliveries[i];
                currentPickup -= pickups[i];
                totalDistance += (i + 1) * 2 * trips;
            }
        }

        return totalDistance;
    }
}