package leetcode.april;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 最小高度树
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 * <p>
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Version : 1.0
 * @Creation : 2022/4/6 上午10:53
 * @Author : ksice_xt
 */
public class Leetcode310 {
    /**
     * 这个方法太机智了，通过计算谁是中心点来判断是不是最小高度树
     *
     * @param n     节点个数
     * @param edges 节点之间的关系
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();

        //如果只有一个节点那么0节点就是最小高度树
        if (n == 1) {
            res.add(0);
            return res;
        }
        //建立每个节点的度表（就是每个节点的有多少个邻点），节点就是下标
        int[] degree = new int[n];

        //建立图关系，存储节点的相连节点关系
        List<List<Integer>> map = new ArrayList<>();

        //初始化map
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        //将每个节点的连接的节点数进行统计, 例如[[1,0],[1,2],[1,3]]，edge[0]就是1、1、1，edge[1]就是0、2、3
        //然后通过degree来判断邻点个数，同时通过map来判断相连节点信息
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;

            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        //添加队列添加叶子节点
        Queue<Integer> queue = new LinkedList<>();

        //当度为1的时候说明他是叶子节点，添加到队列中
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        //进行循环删除叶子节点，将所有的叶子节点都删除了剩下来的1到2个节点就是最小高度树
        while (!queue.isEmpty()) {

            res = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                //poll取出就删了
                int cur = queue.poll();
                //将当前节点全部添加，因为上面会重新弄个新集合，如果这是最后的节点，那么集合存的最小高度树
                res.add(cur);

                //得到cur相邻的叶子节点
                List<Integer> list = map.get(cur);

                for (int j = 0; j < list.size(); j++) {
                    //得出相邻的节点
                    Integer neighbor = list.get(j);

                    //因为当前的节点被剔除了，所以他的相连接点就变成叶子节点了，一层层剥开
                    degree[neighbor]--;

                    //如果是相邻节点那就添加到队列进行下次的删除
                    if (degree[neighbor] == 1) {
                        //如果是两个节点是最小高度树，那么queue有两个节点，res全部添加存储，不会漏掉其中一个
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }

}
