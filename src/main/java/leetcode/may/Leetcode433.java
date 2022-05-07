package leetcode.may;

import java.util.*;

/**
 * 最小基因变化
 *
 * @Version : 1.0
 * @Creation : 2022/5/7 上午10:43
 * @Author : ksice_xt
 */
public class Leetcode433 {

    /**
     * 每次转换后的基因序列必须存在基因库里面
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {

        //转换的基因序列号
        char[] items = new char[]{'A', 'C', 'G', 'T'};

        Queue<String> queue = new ArrayDeque<>();

        //用map存储转成对应的序列号和所需的步数
        Map<String, Integer> map = new HashMap<>();

        queue.add(start);

        map.put(start, 0);

        Set<String> set = new HashSet<>();

        for (int i = 0; i < bank.length; i++) {
            set.add(bank[i]);
        }

        while (!queue.isEmpty()) {
            String poll = queue.poll();
            char[] chars = poll.toCharArray();

            //将当前转换之后的步数重新赋值开始转换
            int step = map.get(poll);

            //一次循环进行修改每个字符进行匹配
            for (int i = 0; i < poll.length(); i++) {

                char str = poll.charAt(i);

                for (char item : items) {

                    //如果当前item和字符相同那就跳过不替换
                    if (str == item) {
                        continue;
                    }

                    //将字符clone一份，然后将对应的位置替换掉，然后在转成字符串
                    char[] clone = chars.clone();

                    clone[i] = item;

                    String ss = String.valueOf(clone);

                    //修改后的基因序列不在基因库里面就重新替换
                    if (!set.contains(ss)) {
                        continue;
                    }

                    //还要判断是否已经转变过这样的字符串
                    if (map.containsKey(ss)) {
                        continue;
                    }

                    if (ss.equals(end)) {
                        return step + 1;
                    }

                    map.put(ss, step + 1);

                    queue.add(ss);
                }
            }
        }
        return -1;
    }
}
