import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2606_바이러스 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numOfCom = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int numOfEdges = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[numOfCom + 1];
        LinkedList<LinkedList<Integer>> edges = new LinkedList<LinkedList<Integer>>();

        for (int i = 0; i <= numOfCom; i++) {
            edges.push(new LinkedList<Integer>());
        }

        for (int i = 0; i < numOfEdges; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            edges.get(s).add(e);
            edges.get(e).add(s);
        }

        int result = 0;

        Queue<Integer> queue = new LinkedList<>();
        // 1번 노드에서 갈 수 있는 모든 경우 queue에 추가
        edges.get(1).forEach(el -> queue.add(el));
        visited[1] = true;
        // 큐가 빌 때까지 진행
        while (!queue.isEmpty()) {
            int now = queue.poll();
            // 이미 방문했다면 위로 올라간다
            if (visited[now])
                continue;
            // 방문 처리 및 결과 더하기
            visited[now] = true;
            result++;
            // 현재 위치에서 갈 수 있는 노드를 모두 큐에 추가
            for (int el : edges.get(now)) {
                // 방문하지 않았으 때만 큐에 추가
                if (!visited[el]) {
                    queue.add(el);
                }
            }
            // System.out.println(queue.toString());
        }

        System.out.println(result);
    }
}
