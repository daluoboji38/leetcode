package leetCode.general.priorityQueue;

import java.util.PriorityQueue;

public class discountCandyV2 {
    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int c : cost) {
            pq.offer(c);
        }
        int res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
            if (!pq.isEmpty()) res +=pq.poll();
            if (!pq.isEmpty()) pq.poll();
            }
        return res;
    }
}
