package binarysearch;

import java.util.*;

/*
*
* https://leetcode.cn/problems/snapshot-array/description/?envType=problem-list-v2&envId=binary-search
* 1146. 快照数组
中等

相关标签
相关企业

提示
实现支持下列接口的「快照数组」- SnapshotArray：

SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
void set(index, val) - 会将指定索引 index 处的元素设置为 val。
int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。


示例：

输入：["SnapshotArray","set","snap","set","get"]
     [[3],[0,5],[],[0,6],[0,0]]
输出：[null,null,0,null,5]
解释：
SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
snapshotArr.set(0,5);  // 令 array[0] = 5
snapshotArr.snap();  // 获取快照，返回 snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5


提示：

1 <= length <= 50000
题目最多进行50000 次set，snap，和 get的调用 。
0 <= index < length
0 <= snap_id < 我们调用 snap() 的总次数
0 <= val <= 10^9

* */
public class SnapshotArray {

    Map<Integer, Integer>[] arr = null;
    int snapId = 0;

    public SnapshotArray(int length) {
        arr = new HashMap[length];

    }

    public void set(int index, int val) {
        Map<Integer, Integer> map = arr[index];
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(snapId, val);
        arr[index] = map;
    }

    public int snap() {
        return snapId++;

    }

    public int get(int index, int snap_id) {

        Map<Integer, Integer> map = arr[index];
        if (map == null) {
            return 0;
        }
        for (int i = snap_id; i >=0 ; i--) {
            Integer i1 = map.get(i);
            if (i1 !=null){
                return i1.intValue();
            }
        }
        return 0;
    }
}
