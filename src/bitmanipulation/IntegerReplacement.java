package bitmanipulation;

/*

https://leetcode.cn/problems/integer-replacement/description/?envType=problem-list-v2&envId=bit-manipulation

给定一个正整数 n ，你可以做如下操作：

如果 n 是偶数，则用 n / 2替换 n 。
如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
返回 n 变为 1 所需的 最小替换次数 。



示例 1：

输入：n = 8
输出：3
解释：8 -> 4 -> 2 -> 1
示例 2：

输入：n = 7
输出：4
解释：7 -> 8 -> 4 -> 2 -> 1
或 7 -> 6 -> 3 -> 2 -> 1
示例 3：

输入：n = 4
输出：2


提示：

1 <= n <= 231 - 1

 */
public class IntegerReplacement {

    public static void main(String[] args) {
        System.out.println(new IntegerReplacement()
                .integerReplacement1(3));

    }


    public int integerReplacement1(int n) {

        //6 - 3 - 2 - 1
        //5 - 4 - 2 - 1
        //15 - 14 - 7 - 6 - 3 - 2 - 1
        // 1-
        // 2 - 1
        // 3 - 4 - 2 -1
        // 5 - 4 - 2 - 1
        // 6 - 3 - 2 - 1    (110) 3
        // 7 - 6 - 3 - 2 - 1 (111) 4
        // 8 - 4 - 2 - 1 (1000) 3
        // 9 - 8 - 4 - 2 - 1 (1001)4
        // 10 -5 - 4 - 2 - 1 (1010)4
        //11-10 -5 - 4 - 2 - 1 (1011)5
        int count = 0;

        int i = Integer.bitCount(n);
        if (i == 1) {
            String binaryString = Integer.toBinaryString(n);
            count += binaryString.length() - 1;
        } else {
            if (n % 2 == 0) {
                count = count + 1;
                count = count + integerReplacement(n / 2);
            } else {
                count = count + 1;
                int tempCount1 = integerReplacement(n + 1);
                int tempCount2 = integerReplacement(n - 1);
                count += Math.min(tempCount1, tempCount2);
            }
        }
        return count;

    }

    public int integerReplacement(int n) {
        int count = 0;
        if (n == 1) {
            return count;
        }
        if (n % 2 == 0) {
            n = n / 2;
            count += 1 + integerReplacement(n);
        } else {
            count += 1 + integerReplacement(n - 1);
        }
        return count;
    }
}
