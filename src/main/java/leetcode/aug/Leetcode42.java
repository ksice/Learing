package leetcode.aug;

import java.util.Stack;

/**
 * trapping rain water
 *
 * @author ksice
 * @since 2022-08-04 下午2:49
 */
public class Leetcode42 {
    //解法一
//    //按每行求水的容量
//    public int trap(int[] height) {
//
//        //先得出最高的水的高度
//        int max = getMax(height);
//
//        int ans = 0;
//
//        //然后依次循环每种高度的水的容量
//        for (int i = 1; i < max; i++) {
//
//            //标记开始是否计算水的容量
//            boolean is_start = false;
//
//            //每个高度的水的总量
//            int tem = 0;
//
//            for (int j = 0; j < height.length; j++) {
//
//                //判断中间一段有多少小于这个高度的水
//                if (is_start && height[j] < i) {
//                    tem++;
//                }
//
//                //遇到比这个高度高的就开始计算水容量，例如[ 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 ]
//                //从1开始计算水位，到0就加1，这时候到2就开始将0位置上一个容量加上
//                if (height[j] >= i) {
//                    is_start = true;
//                    ans += tem;
//                    tem = 0;
//                }
//            }
//
//        }
//        return ans;
//
//    }
//
//    int getMax(int[] height) {
//
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (height[i] > max) {
//                max = height[i];
//            }
//        }
//
//        return max;
//    }
    public static void main(String[] args) {
        Leetcode42 leetcode42 = new Leetcode42();
        leetcode42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    //解法二
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        int current = 0;

        while (current < height.length) {
            //判断栈是否为空是empty方法
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();

                if (stack.empty()) {
                    break;
                }

                int distance = current - stack.peek() - 1; //两者之间的距离

                // {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
                //1入栈 0也入栈 2大于0，将0取出，0左边的1，得出2和1的距离差了1，然后同事算0左右边最小高度为1 容量就是为1*1
                //然后1入栈 0 入栈，1入栈，因为只要下一个值比栈顶高度高就可能出现一个底坑，然后将栈顶的左边和右边进行计算，找最小值

                //选出栈顶和当前下标高度谁最低，就是选择左右两边最矮的那个高度
                int min = Math.min(height[stack.peek()], height[current]);

                //然后拿左右两边的最低高度减去出栈的高度就是容量高度
                sum += distance * (min - h);
            }
            stack.push(current);//将下标入栈
            current++;//下标后移
        }
        return sum;
    }


}
