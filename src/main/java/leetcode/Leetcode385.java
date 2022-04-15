package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Version : 1.0
 * @Creation : 2022/4/15 上午11:02
 * @Author : ksice_xt
 **/
public class Leetcode385 {

    static NestedInteger ph = new NestedInteger(0);

    public static void main(String[] args) {

        Deque<Integer> d = new ArrayDeque<>();

        d.addLast(1);
        d.addLast(2);
        d.addLast(3);

        System.out.println(d);
    }

    /**
     * [123,[456,[789]]]
     *
     * @param s
     * @return
     */
    public static NestedInteger deserialize(String s) {
        Deque<NestedInteger> d = new ArrayDeque<>();

        char[] cs = s.toCharArray();

        int n = cs.length, i = 0;

        while (i < n) {

            if (cs[i] == ',' && ++i > 0) {
                continue;
            }

            //判断是否为数字
            if (cs[i] == '-' || (cs[i] >= '0' && cs[i] <= '9')) {
                int j = cs[i] == '-' ? i + 1 : i, num = 0;

                //如果是数字，同时判断下一位是不是也是数字，如果是的就开始乘以10同时加上当前值
                while (j < n && (cs[j] >= '0' && cs[j] <= '9')) {
                    num = num * 10 + (cs[j++] - '0');
                }
                //如果是负数则置为0
                d.addLast(new NestedInteger(cs[i] == '-' ? -num : num));
                //同时将j目前移到的下标赋给i
                i = j;
            } else if (cs[i] == '[') {
                //从第一个[开始就创建对象
                d.addLast(new NestedInteger());
                d.addLast(ph);
                i++;
            } else {
                //当下标挪到]时候就需要将前面的值放到集合中
                List<NestedInteger> list = new ArrayList<>();

                while (!d.isEmpty()) {
                    NestedInteger nestedInteger = d.pollLast();

                    if (nestedInteger == ph) {
                        break;
                    }

                    list.add(nestedInteger);
                }

                for (int j = list.size()-1; j >= 0; j--) {
                    d.peekLast().add(list.get(j));
                }
                i++;
            }
        }

        return d.peekLast();
    }

    public static class NestedInteger {

        int value;

        public NestedInteger() {
        }

        ;

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.value = value;
        }

        ;

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        ;

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return null;
        }

        ;

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
        }

        ;

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
        }

        ;

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }

        ;
    }
}
