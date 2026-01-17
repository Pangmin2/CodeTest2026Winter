import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int row;
        int col;

        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static int answer;
    static int[][] graph;
    static List<Node> chickenStore;
    static List<Node> house;
    static List<Node> picked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        answer = Integer.MAX_VALUE;
        chickenStore = new ArrayList<>();
        house = new ArrayList<>();
        picked = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                graph[i][j] = tmp;
                if(tmp == 1){
                    house.add(new Node(i, j));
                }
                else if(tmp == 2){
                    chickenStore.add(new Node(i, j));
                }
            }
        }
        solve(n, m, 0, 0);
        System.out.println(answer);

    }

    static void solve(int n, int m, int start, int recur){
        if(m == recur){
            calculate(n, m);
            return;
        }

        for (int i = start; i < chickenStore.size(); i++) {
            picked.add(chickenStore.get(i));
            solve(n, m, i + 1, recur + 1);
            picked.remove(picked.size() - 1);
        }
    }

    private static void calculate(int n, int m) {
        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            Node h = house.get(i);

            int length = Integer.MAX_VALUE;
            for (int j = 0; j < picked.size(); j++) {
                Node chicken = picked.get(j);
                int dist = Math.abs(chicken.row - h.row) + Math.abs(chicken.col - h.col);
                length = Math.min(length, dist);
            }
            sum += length;

            if(sum >= answer)
                return;
        }
        answer = Math.min(answer, sum);
    }

}