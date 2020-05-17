package com.leica.graph;

import java.util.LinkedList;
import java.util.Queue;


/**
 * graph
 *
 * @author leica
 * @date 2020/5/17 20:41
 */
public class Graph {
    /**
     * the number of vertices
     */
    private final int v;

    /**
     * adjacency list
     */
    private final LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * add edge
     * <p>
     * store an undirected graph twice on an edge
     *
     * @param s the vertex s
     * @param t the vertex t
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * breadth first search
     *
     * @param s the vertex s
     * @param t the vertex t
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        // visited is used to record the vertices that have been visited，used to prevent vertices from being visited repeatedly。
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // queue is a queue，used to store vertices that have been accessed but the connected vertices have not been accessed。
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        // prev used to record the search path。
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * depth first search record whether the vertex was found
     */
    boolean found = false;

    /**
     * depth first search
     *
     * @param s the vertex s
     * @param t the vertex t
     */
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    /**
     * recursive depth first search
     *
     * @param w       the vertex w
     * @param t       the vertex t
     * @param visited the vertices that have been visited
     * @param prev    the search path array
     */
    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    /**
     * recursively print the path of s-> t
     *
     * @param arr the array
     * @param s   the vertex s
     * @param t   the vertex t
     */
    private void print(int[] arr, int s, int t) {
        if (arr[t] != -1 && t != s) {
            print(arr, s, arr[t]);
        }
        System.out.println(t + " ");
    }

}
