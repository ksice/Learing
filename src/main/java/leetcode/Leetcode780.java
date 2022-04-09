package leetcode;

/**
 * 到达终点
 * 给定四个整数 sx , sy ，tx 和 ty，如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回 false。
 * <p>
 * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
 *
 * @Version : 1.0
 * @Creation : 2022/4/9 上午9:29
 * @Author : ksice_xt
 */
public class Leetcode780 {

    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {

        while (tx > sx && ty > sy) {
            if (ty > tx) {
                ty -= tx;
            } else {
                tx -= ty;
            }
        }
        //还有种可能tx比sx小然后ty==sy 例如3437
        if (ty < sy || tx < sx) {
            //如果都不一样说明转不了sy和sx
            return false;
        }

        if (tx == sx) {
            //如果tx==sx所以tx已经是原值了，这时候肯定是ty还大于sy,否则while循环不会退出
            return (ty - sy) % tx == 0;
        }//反之一样的
        else {
            return (tx - sx) % ty == 0;
        }
    }

}
