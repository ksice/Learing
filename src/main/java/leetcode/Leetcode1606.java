package leetcode;

import java.nio.file.Path;
import java.util.*;

/**
 * 找到处理最多请求的服务器
 *
 * @Version : 1.0
 * @Creation : 2022/3/30 上午10:59
 * @Author : ksice_xt
 */
public class Leetcode1606 {

    static int N = 100010;

    static int[] cnts = new int[N];

    /**
     * 熟悉完之后发现，主题流程就是，通过一个队列，对现在正在处理的服务器和结束时间，进行统计，
     * 然后得出下个请求的到来的时间是否晚于当前的服务器的结束时间，
     * 如果晚则进行服务器选择，如果没有则跳过，同时对服务器处理过的每个请求都进行记录，最后筛选出最大值
     * 不过要求时间和空间那还是要非常熟悉数据结构，treeset的二分法查找是真的厉害，三叶大佬yyds
     *
     * @param k       服务器个数
     * @param arrival 请求来的时间
     * @param load    请求处理时间
     * @return
     */
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        //将所有值赋值为0
        Arrays.fill(cnts, 0);

        int n = arrival.length, max = 0;

        //优先队列，基于a[1]结束时间升序排序,这样在下面peek的时候可以直接拿首位的
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        //treeset有序集合,用来后面查找满足分配规则的服务器编号
        TreeSet<Integer> free = new TreeSet();

        for (int i = 0; i < k; i++) {
            free.add(i);
        }

        for (int i = 0; i < n; i++) {

            //得出该请求开始时间和结束时间
            int start = arrival[i], end = start + load[i];

            //看了注释终于明白了是为了筛选出空闲的服务器，busy.peek()[1]得到是服务器的结束时间，
            //找到结束时间早于开始时间的服务器
            while (!busy.isEmpty() && busy.peek()[1] <= start) {
                free.add(busy.poll()[0]);
            }

            //通过ceiling得出free大于等于的服务器编号 i%k是分配规则
            Integer u = free.ceiling(i % k);

            //如果i%k没有，就取大于等于0的值，分配规则
            if (u == null) {
                u = free.ceiling(0);
            }

            //如果基于0也没有满足的服务器编号，说明服务器都被占用了，这个请求就跳过不需要了
            if (u == null) {
                continue;
            }
            //将空闲的服务器进行移除
            free.remove(u);

            //u是服务器编号，添加到优先队列中服务器编号和结束时间
            busy.add(new int[]{u, end});

            //得出处理的最大任务数，cnts[u]代表的服务器u目前处理的任务数目
            max = Integer.max(max, ++cnts[u]);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < cnts.length; i++) {
            //最后得出cnts处理过max的服务器的集合
            if (cnts[i] == max) {
                list.add(i);
            }
        }
        return list;
    }
}
