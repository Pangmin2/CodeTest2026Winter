import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dX = {-1, 1, 2};

        Queue<Node> que = new PriorityQueue<>(Comparator.comparingInt(n -> n.time));
        que.add(new Node(N, 0));

        boolean[] visited = new boolean[100_001];
        int sum = 0;
        int time = 0;
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.now == K && time == 0){
                time = node.time;
                sum++;
                continue;
            }
            else if(node.now == K && time == node.time){
                sum++;
                continue;
            }

            visited[node.now] = true;
            for (int i = 0; i < 2; i++) {
                int newX = node.now + dX[i];

                if(newX >= 0 && newX <= 100_000 && !visited[newX]){
                    que.add(new Node(newX, node.time + 1));
                }
            }
            int newX = node.now * 2;
            if(newX <= 100_000 && !visited[newX]){
                que.add(new Node(newX, node.time + 1));
            }
        }
        System.out.println(time);
        System.out.println(sum);

    }

    static class Node{
        int now;
        int time;

        Node(int now, int time){
            this.now = now;
            this.time = time;
        }
    }
}