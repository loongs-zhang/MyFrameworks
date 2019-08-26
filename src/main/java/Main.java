import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * @author SuccessZhang
 * 舍掉小数取整:Math.floor(3.5)=3
 * 四舍五入取整:Math.rint(3.5)=4
 * 向上取整:Math.ceil(3.1)=4
 * 向下取整:Math.floor(3.1)=3
 * 取绝对值：Math.abs(-3.5)=3.5
 * 求n方根：Math.pow(target, 1d/n)，如Math.pow(27, 1d/3)=3.0
 * 取余数：A%B = 余数
 * <p>
 * Arrays.sort(new int[]{10,3,1,5,9});//快速排序实现，可直接使用
 * Collections.shuffle(list);//打乱顺序
 * Collections.sort(list);//排序
 * <p>
 * 栈 java.util.Stack
 * 取栈顶值（不出栈）stack.peek();
 * 进栈stack.push(Object);
 * 出栈stack.pop();
 * <p>
 * 队列 java.util.Queue
 * 实现类java.util.LinkedList
 * 取队首值（不出队）queue.peek();
 * 入队queue.offer(Object);
 * 出队queue.poll();
 * <p>
 * 流取最大值stream().max((x, y) -> x > y ? 1 : -1).get()
 */
@SuppressWarnings("unused")
public class Main {

    /**
     * 运用试除法:
     * 1.只有奇数需要被测试
     * 2.测试范围从2与根号n
     */
    private static boolean isPrime(int n) {
        if (n > 2 && (n & 1) == 0) {
            return false;
        }
        for (int i = 3; i <= Math.pow(n, 1.0 / 2); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串去重，保留第1个，如aaabbbccdde->abcde、aba->ab
     */
    public static String removeRepeatRetainFirst(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charWord = str.charAt(i);
            int firstPosition = str.indexOf(charWord);
            int lastPosition = str.lastIndexOf(charWord);
            if (firstPosition == lastPosition || firstPosition == i) {
                sb.append(charWord);
            }
        }
        return sb.toString();
    }

    /**
     * 字符串去重，保留最后1个，如aba->ba
     */
    public static String removeRepeatRetainLast(String str) {
        return str.replaceAll("(.)(?=.*\\1)", "");
    }

    /**
     * 四舍五入
     *
     * @param target 原始数据
     * @param digit  需要四舍五入的位数
     * @return 四舍五入后的数(可能有小数)
     */
    public static double round(double target, int digit) {
        return new BigDecimal(target).setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 求∠B的角度
     *
     * @param a a边的长度
     * @param b b边的长度
     * @param c c边的长度
     * @return ∠B的角度
     */
    private static double getAngleDegree(double a, double b, double c) {
        return Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2.0 * a * c)));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bf.readLine().split(" ");
    }
}