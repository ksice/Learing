package leetcode.april;

/**
 * 线段树和线状数组算法，不理解原理直接背线状数组算法吧
 *
 * @Version : 1.0
 * @Creation : 2022/4/4 上午11:00
 * @Author : ksice_xt
 */
public class Leetcode307 {

    public static void main(String[] args) {

//        for (int i = 0; i <10 ; i++) {
//            int i1 = i & -i;
//            System.out.println(i1);
//        }


        int[] nums = new int[]{1, 3, 5, 8, 10};
        NumArray numArray = new NumArray(nums);

        int i = numArray.sumRange(0, 2);
//        System.out.println(i);
    }

    static class NumArray {

        /**
         * 线状数组的添加、查询的模板方法
         */
        int[] tree;

        int lowbit(int x) {
            return x & -x;
        }

        int query(int index) {
            int ans = 0;
            for (int i = index; i > 0; i -= lowbit(i)) {
                ans += tree[i];
            }
            return ans;
        }

        void add(int index, int val) {

            for (int i = index; i <= n; i += lowbit(i)) {
                tree[i] += val;
            }

        }

        int[] nums;

        int n;

        public NumArray(int[] nums_) {
            nums = nums_;
            n = nums_.length;

            tree = new int[n + 1];

            for (int i = 0; i < n; i++) {
                add(i + 1, nums[i]);
            }

            for (int i = 0; i < tree.length; i++) {
                System.out.println(tree[i]);
            }
        }

        public void update(int index, int val) {
            add(index + 1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {

            int query = query(right + 1);
            System.out.println(query);
            return query - query(left);
        }
    }


    /**
     * 线状数组模板
     */

//    // 上来先把三个方法写出来
//    {
//        int[] tree;
//        int lowbit(int x) {
//        return x & -x;
//    }
//        // 查询前缀和的方法
//        int query(int x) {
//        int ans = 0;
//        for (int i = x; i > 0; i -= lowbit(i)) ans += tree[i];
//        return ans;
//    }
//        // 在树状数组 x 位置中增加值 u
//        void add(int x, int u) {
//        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
//    }
//    }
//
//    // 初始化「树状数组」，要默认数组是从 1 开始
//    {
//        for (int i = 0; i < n; i++) add(i + 1, nums[i]);
//    }
//
//    // 使用「树状数组」：
//    {
//        void update(int i, int val) {
//        // 原有的值是 nums[i]，要使得修改为 val，需要增加 val - nums[i]
//        add(i + 1, val - nums[i]);
//        nums[i] = val;
//    }
//
//        int sumRange(int l, int r) {
//        return query(r + 1) - query(l);
//    }
//    }

}
