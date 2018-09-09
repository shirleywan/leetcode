package xiaozhao;


import java.util.*;

/**
 * java版图遍历 ， 假设每条路径权重为1；
 */
public class Graph {
    private int vertexSize;//顶点数量
    private int [] vertexs;//顶点数组
    private int[][]  matrix; //邻接矩阵
    private static final int MAX_WEIGHT = 1000;
    private boolean [] isVisited;

    public Graph(int vertextSize){
        this.vertexSize = vertextSize;
        matrix = new int[vertextSize][vertextSize];
        vertexs = new int[vertextSize];
        for(int i = 0;i<vertextSize;i++){
            vertexs[i] = i;
        }
        isVisited = new boolean[vertextSize];
    }


    /**
     * 获取某个顶点的出度
     * @return
     */
    public int getOutDegree(int index){
        int degree = 0;
        for(int j = 0;j<matrix[index].length;j++){
            int weight = matrix[index][j];
            if(weight!=0&&weight!=MAX_WEIGHT){
                degree++;
            }
        }
        return degree;
    }



    /**
     * 入度
     * @return
     */

    /**
     * 获取某个顶点的第一个邻接点
     * 根据index(代表第几行) 往右遍历j++(代表第几列),则第一个数为第一个邻接点.
     */
    public int getFirstNeighbor(int index){
        for(int j = 0;j<vertexSize;j++){
            if(matrix[index][j]>0&&matrix[index][j]<MAX_WEIGHT){
                return j;
            }
        }
        return -1;
    }

    /**
     * 在顶点v处,根据前一个邻接点的下标index来取得下一个邻接点
     * v1表示要找的顶点
     * v2 表示该顶点相对于哪个邻接点去获取下一个邻接点(index表示从参照点开始往后遍历)
     */
    public int getNextNeighbor(int v,int index){
        for(int j = index+1;j<vertexSize;j++){
            if(matrix[v][j]>0&&matrix[v][j]<MAX_WEIGHT){
                return j;
            }
        }
        return -1;
    }

    /**
     * 图的深度优先遍历算法
     */
    public int count = 0; // 用类变量记录深度遍历的深度；
    private void depthFirstSearch(int i ){
        isVisited[i] = true;
        int w = getFirstNeighbor(i);//
        while(w!=-1){
            if(!isVisited[w]){
                //需要遍历该顶点
                System.out.println("访问："+w+"顶点");
                depthFirstSearch(w );
                count++;
            }
            w = getNextNeighbor(i, w);//第一个相对于w的邻接点
        }
    }

    /**
     * 对外公开的深度优先遍历
     */

    public void depthFirstSearch(){
        isVisited = new boolean[vertexSize];
//        for(int i = 0;i<vertexSize;i++){
//            if(!isVisited[i]){
//                System.out.println("访问到了："+i+"顶点");
//                depthFirstSearch(i);
//            }
//        }

        this.count = 1;
        depthFirstSearch(0);
        System.out.println(this.count);
        isVisited = new boolean[vertexSize];
    }

    public void broadFirstSearch(){
        isVisited = new boolean[vertexSize];
        for(int i =0;i<vertexSize;i++){
            if(!isVisited[i]){
                broadFirstSearch(i);
            }
        }
        isVisited = new boolean[vertexSize];
    }

    /**
     * 实现广度优先遍历
     * @param i
     */
    private void broadFirstSearch(int i) {
        int u,w;
        LinkedList<Integer> queue = new LinkedList<Integer>();
//        System.out.println("访问到："+i+"顶点");
        int count = 1;
        isVisited[i] = true;
        queue.add(i);//第一次把v0加到队列
        while(!queue.isEmpty()){
            u = (Integer)(queue.removeFirst()).intValue();
            w = getFirstNeighbor(u);
            while(w!=-1){
                if(!isVisited[w]){
//                    System.out.println("访问到了："+w+"顶点");
                    count ++;
                    isVisited[w] = true;
                    queue.add(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
        System.out.println(count);
    }



    /*********************************/
    public static void main(String [] args){


        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine().split("\n")[0]);
        Graph graph = new Graph(n);
        for(int i = 0 ; i< n-1 ;i++){
            String[] string = in.nextLine().split(" ");
            graph.matrix[Integer.valueOf(string[0])-1][Integer.valueOf(string[1])-1] = Integer.valueOf(string[2]);
            graph.matrix[Integer.valueOf(string[1])-1][Integer.valueOf(string[0])-1] = Integer.valueOf(string[2]);
        }
        //        int [] a1 = new int[]{0,10,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,11,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT};
        //        int [] a2 = new int[]{10,0,18,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,16,MAX_WEIGHT,12};
        //        int [] a3 = new int[]{MAX_WEIGHT,MAX_WEIGHT,0,22,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,8};
        //        int [] a4 = new int[]{MAX_WEIGHT,MAX_WEIGHT,22,0,20,MAX_WEIGHT,MAX_WEIGHT,16,21};
        //        int [] a5 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,20,0,26,MAX_WEIGHT,7,MAX_WEIGHT};
        //        int [] a6 = new int[]{11,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,26,0,17,MAX_WEIGHT,MAX_WEIGHT};
        //        int [] a7 = new int[]{MAX_WEIGHT,16,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,17,0,19,MAX_WEIGHT};
        //        int [] a8 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,16,7,MAX_WEIGHT,19,0,MAX_WEIGHT};
        //        int [] a9 = new int[]{MAX_WEIGHT,12,8,21,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0};
        //
        //        graph.matrix[0] = a1;
        //        graph.matrix[1] = a2;
        //        graph.matrix[2] = a3;
        //        graph.matrix[3] = a4;
        //        graph.matrix[4] = a5;
        //        graph.matrix[5] = a6;
        //        graph.matrix[6] = a7;
        //        graph.matrix[7] = a8;
        //        graph.matrix[8] = a9;

        //  int degree = graph.getOutDegree(4);
        //      System.out.println("vo的出度:"+degree);
        //      System.out.println("权值："+graph.getWeight(2,3));
        //dfs：
        graph.depthFirstSearch();
        System.out.println("-----------------");
        //输入示例： 4
        // 1 2
        // 2 3
        // 3 4
        //bfs：
        graph.broadFirstSearch();
    }
}
