package Programmers;

import java.util.*;

/**
 * url : https://programmers.co.kr/learn/courses/30/lessons/12978
 */

class Town implements Comparable<Town> {
    int id;
    int time;

    public Town(int id, int time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public int compareTo(Town other) {
        return Integer.compare(this.time, other.time);
    }
}

public class Delivery {
    static int N = 5;
    static int K = 3;
    static int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
    static int answer = 0;
    static int[] minimumTimeCost;

    public static void main(String[] args) {
        minimumTimeCost = new int[N + 1];
        Arrays.fill(minimumTimeCost, Integer.MAX_VALUE);
        List<List<Town>> townList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            townList.add(new ArrayList<>());
        }

        for (int[] info : road) {
            townList.get(info[0]).add(new Town(info[1], info[2]));
            townList.get(info[1]).add(new Town(info[0], info[2]));
        }
        minimumTimeCost[1] = 0;

        dijkstra(1, townList);

        for (int cost : minimumTimeCost) {
            if (cost <= K) answer += 1;
        }

        System.out.println(answer);
    }

    private static void dijkstra(int i, List<List<Town>> townList) {
        Queue<Town> q = new PriorityQueue<>();
        q.offer(new Town(1, 0));

        while (!q.isEmpty()) {
            Town curTown = q.poll();
            if (minimumTimeCost[curTown.id] < curTown.time) continue;

            // 인접한 마을 순회
            for (Town nextTown : townList.get(curTown.id)) {
                if(minimumTimeCost[nextTown.id] > curTown.time + nextTown.time) {
                    minimumTimeCost[nextTown.id] = curTown.time + nextTown.time;
                    q.offer(new Town(nextTown.id, minimumTimeCost[nextTown.id]));
                }
            }
        }
    }
}
