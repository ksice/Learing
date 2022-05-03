package leetcode.may;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version : 1.0
 * @Creation : 2022/5/3 上午10:07
 * @Author : ksice_xt
 */
public class Leetcode937 {
    public static void main(String[] args) {
        reorderLogFiles(new String[1]);
    }

    public static String[] reorderLogFiles(String[] logs) {
        List<Logs> list = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            list.add(new Logs(logs[i], i));
        }

        //核心部分就是写比较逻辑
        list.sort((a, b) -> {

            //所有 字母日志 都排在 数字日志 之前。
            if (a.type != b.type) {
                return a.type - b.type;
            }

            //数字日志 应该保留原来的相对顺序
            if (a.type == 1) {
                return a.index - b.index;
            }
            //字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。

            return a.content.equals(b.content) ? a.sign.compareTo(b.sign) : a.content.compareTo(b.content);
        });

        String[] strings = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            strings[i] = list.get(i).ori;
        }
        return strings;
    }


    static class Logs {
        /**
         * type判断是否这个包含数字
         * index代表数组的下标
         * content代表除了第一个的后面内容
         * sign代表第一个字符串
         * ori代表源字符串
         */
        int type, index;
        String content, ori, sign;

        Logs(String s, int index) {

            this.index = index;

            int n = s.length(), i = 0;

            //为了得到第一个字符串
            while (i < n && s.charAt(i) != ' ') i++;

            sign = s.substring(0, i);

            content = s.substring(i + 1);

            ori = s;

            type = Character.isDigit(content.charAt(0)) ? 1 : 0;

        }
    }
}
