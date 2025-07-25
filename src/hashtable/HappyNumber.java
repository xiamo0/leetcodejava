package hashtable;

import java.util.HashSet;

/*
https://leetcode.cn/problems/happy-number/?envType=problem-list-v2&envId=hash-table
 快乐数

 编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」 定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为 1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 。



示例 1：

输入：n = 19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
示例 2：

输入：n = 2
输出：false


提示：

1 <= n <= 231 - 1
 */
public class HappyNumber {
    public boolean isHappy(int n) {

        if (n == 1) return true;
        HashSet<Integer> seen = new HashSet<>();
        while (!seen.contains(n)) {
            seen.add(n);
            n = sum(n);
            if (n == 1) return true; // 如果在计算过程中遇到1，直接返回true

        }
        return false;
    }

    static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
