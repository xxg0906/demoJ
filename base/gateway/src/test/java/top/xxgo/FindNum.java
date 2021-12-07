package top.xxgo;

public class FindNum {


    static int findNthDigit(int n) {
        int len = 1, weigh = 1;  /* len表示当前数(十进制)的位数, weigh表示当前位的权重(10^i)...  */
        while (n > (long) 9 * weigh * len) /* 转换成long long, 防止整型溢出 */ {
//            n -= 9 * weigh * len;
            n = n - 9 * weigh * len;
            len++;
            weigh *= 10;
        }
        int curNum = (n - 1) / len + weigh;     // curNum是含有所找digit的那个数, 整个数列的第一个数是1
        System.out.println(n);
        System.out.println(curNum);
        int resDigit = 0;
        for (int i = (n - 1) % len; i < len; i++)  // 从低位向高位移动扫描, 根据离末位的偏移量找到所找的数字
        {
            resDigit = curNum % 10;
            curNum /= 10;
        }
        return resDigit;
    }

    public static void main(String[] args) {
//      1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19
        st(25);
        st(102);
        st(1199);
        st(2331);
        st(2324);
        st(12115);
    }

    static void st(int m) {
        int nthDigit = findNthDigit(m);
        int i = funNum(m);
        System.out.print(nthDigit);
        System.out.print("-VS-");
        System.out.println(i);
        System.out.println("------------    ---");
    }

    public static int funNum(int di) {
        int len = 1;
        int weight = 1;
        while (di > 9 * len * weight) {
            di = di - 9 * len * weight;
            len++;
            weight = weight * 10;
        }
        int dNum = (di - 1) / len + weight;

        double pow = Math.pow(10, len - (di - 1) % len);
        System.out.println(pow);
        int s= (int) (dNum/pow);
        System.out.println(s % 10);
        // 余数 第几位 di=16   1
        int m = (di - 1) % len;
        for (int i = 1; i < len - m; i++) {
            dNum = dNum / 10;
        }
        return dNum % 10;

    }

}
