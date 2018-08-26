import java.util.*;

public class Main {
    public static int MAX = 100;
    public static int count;   //用于对图中顶点遍历的次序进行计数
    public static int n;
    public static int[] DFN = new int[MAX];    //记录图中每个节点的DFS遍历的时间戳(即次序)
    public static int[] Low = new int[MAX];   //记录每个顶点的所在树的根节点编号
    public static boolean[] inStack = new boolean[MAX];  //用于记录当前节点是否在栈中
    public static Stack<Integer> stack;
    public static int number = 0;

    public void init(int n) {
        count = 0;
        stack = new Stack<Integer>();
        for(int i = 0;i <= n;i++) {
            DFN[i] = -1;   //代表顶点i未被遍历
            Low[i] = -1;
            inStack[i] = false;
        }
    }

    static class edge {
        public int a;  //边的起点
        public int b;  //边的终点

        edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public void dfs(ArrayList<edge>[] map, int start) {
        DFN[start] = count++;
        Low[start] = DFN[start];
        stack.push(start);
        inStack[start] = true;
        int j = start;
        for(int i = 0;i < map[start].size();i++) {
            j = map[start].get(i).b;
            if(DFN[j] == -1) {  //顶点j未被遍历
                dfs(map, j);
                Low[start] = Math.min(Low[start], Low[j]);
            } else if(inStack[j]) {
                Low[start] = Math.min(Low[start], DFN[j]);
            }
        }
        if(DFN[start] == Low[start]) {
            System.out.print("强连通分量：");
            do {
                j = stack.pop();
                System.out.print(j+" ");
                inStack[j] = false;
            } while(start != j);
            System.out.println();
            number++;
        }
        return;
    }

    public static void main(String[] args) {
//        Main test = new Main();
//        Scanner in = new Scanner(System.in);
//        n = in.nextInt();
//        test.init(n);
//        int k = in.nextInt();  //有向图的边数目
//        ArrayList<edge>[] map = new ArrayList[n + 1];
//        for(int i = 0;i <= n;i++)
//            map[i] = new ArrayList<edge>();
//        in.nextLine();
//        for(int i = 0;i < k;i++) {
//            int a = in.nextInt();
//            int b = in.nextInt();
//            map[a].add(new edge(a, b));
//        }
//        test.dfs(map, 1);
        Main test = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        test.init(n);
        scanner.nextLine();
        ArrayList<edge>[] mapEdge = new ArrayList[n + 1];
        for(int i = 0;i <= n;i++)
            mapEdge[i] = new ArrayList<edge>();
        Map<Integer,List> map = new HashMap<Integer, List>();
        for (int i = 0; i < n; i++) {
            String string = scanner.nextLine();
            String[] stringArray = string.split(" ");
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; stringArray.length > 1 && j < stringArray.length - 1; j++) {
                mapEdge[i + 1].add(new edge(i + 1, Integer.parseInt(stringArray[j])));
                list.add(Integer.parseInt(stringArray[j]));
            }
            map.put(i + 1, list);
        }
        test.dfs(mapEdge, 1);
        System.out.println(number);
    }
}
