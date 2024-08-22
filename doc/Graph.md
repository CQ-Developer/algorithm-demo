# 图

## 有向无权图的邻接矩阵表示

```java
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            graph[sc.nextInt()][sc.nextInt()] = 1;
        }
    }

}
```

## 有向有权图的邻接矩阵表示

```java
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            graph[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }
    }

}
```

## 无向无权图的邻接矩阵表示

```java
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt(), t = sc.nextInt();
            graph[f][t] = graph[t][f] = 1;
        }
    }

}
```

## 无向有权图的邻接矩阵表示

```java
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt(), t = sc.nextInt(), w = sc.nextInt();
            graph[f][t] = graph[t][f] = w;
        }
    }

}
```

## 有向无权图的邻接表表示

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(sc.nextInt()).add(sc.nextInt());
        }
    }

}
```

## 有向有权图的邻接表表示

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt(), t = sc.nextInt(), w = sc.nextInt();
            graph.get(f).add(new int[]{t, w});
        }
    }

}
```

## 无向无权图的邻接表表示

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt(), t = sc.nextInt();
            graph.get(f).add(t);
            graph.get(t).add(f);
        }
    }

}
```

## 无向有权图的邻接表表示

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt(), t = sc.nextInt(), w = sc.nextInt();
            graph.get(f).add(new int[]{t, w});
            graph.get(t).add(new int[]{f, w});
        }
    }

}
```

## 有向无权链式前向星表示

```java
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int cnt = 1;
        int[] head = new int[n + 1], next = new int[m + 1], to = new int[m + 1];
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt(), t = sc.nextInt();
            buildGraph(f, t, cnt++, head, next, to);
        }
        graphTravsersal(head, next, to);
    }

    private static void buildGraph(int f, int t, int cnt, int[] head, int[] next, int[] to) {
        next[cnt] = head[f];
        to[cnt] = t;
        head[f] = cnt;
    }
    
    private static void graphTravsersal(int[] head, int[] next, int[] to) {
        for (int i = 0; i < head.length; i++) {
            System.out.print(i + "-> ");
            for (int j = head[i]; j > 0; j = next[j]) {
                System.out.print(to[j] + " ");
            }
            System.out.println();
        }
    }

}
```

## 有向有权链式前向星表示

```java
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int cnt = 1;
        int[] head = new int[n + 1], next = new int[m + 1], to = new int[m + 1], weight = new int[m + 1];
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt(), t = sc.nextInt(), w = sc.nextInt();
            buildGraph(f, t, w, cnt++, head, next, to, weight);
        }
        graphTravsersal(head, next, to, weight);
    }

    private static void buildGraph(int f, int t, int w, int cnt, int[] head, int[] next, int[] to, int[] weight) {
        weight[cnt] = w;
        next[cnt] = head[f];
        to[cnt] = t;
        head[f] = cnt;
    }

    private static void graphTravsersal(int[] head, int[] next, int[] to, int[] weight) {
        for (int i = 0; i < head.length; i++) {
            System.out.printf("%d -> ", i);
            for (int j = head[i]; j > 0; j = next[j]) {
                System.out.printf("[%d,%d] ", to[j], weight[j]);
            }
            System.out.println();
        }
    }

}
```
