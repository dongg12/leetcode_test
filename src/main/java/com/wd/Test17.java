package com.wd;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2462.雇佣k位工人的总代价
 */
public class Test17 {
    public static void main(String[] args) {

    }

    /**
     * candidates 如果很小的话，下面这个方法就不能用了
     */
    public long totalCost(int[] costs, int k, int candidates) {
        long sum = 0;
        Arrays.sort(costs);
        for (int i = 0; i < k && i < costs.length; i++) {
            sum += costs[i];
        }
        return sum;
    }

    /**
     * 根据题目描述，我们需要雇佣代价最小，并且在代价相等时下标最小的工人，
     * 因此我们可以使用小根堆维护所有当前可以雇佣的工人，
     * 小根堆的每个元素是一个二元组 (cost,id)(\textit{cost}, \textit{id})(cost,id)，
     * 分别表示工人的代价和下标。
     * 初始时，我们需要将数组 costs\textit{costs}costs 中的前 candidates\textit{candidates}candidates 和后 candidates\textit{candidates}candidates 个工人放入小根堆中。需要注意的是，如果 candidates×2≥n\textit{candidates} \times 2 \geq ncandidates×2≥n（其中 nnn 是数组 costs\textit{costs}costs 的长度），前 candidates\textit{candidates}candidates 和后 candidates\textit{candidates}candidates 个工人存在重复，等价于将所有工人都放入小根堆中。
     * 随后我们用 left\textit{left}left 和 right\textit{right}right 分别记录前面和后面可以选择的工人编号的边界，它们的初始值分别为 candidates−1\textit{candidates} - 1candidates−1 和 n−candidatesn - \textit{candidates}n−candidates。这样一来，我们就可以进行 kkk 次操作，每次操作从小根堆中取出当前最优的工人。如果它的下标 id≤left\textit{id} \leq \textit{left}id≤left，那么它属于前面的工人，我们需要将 left\textit{left}left 增加 111，并将新的 (costs[left],left)(\textit{costs}[\textit{left}], \textit{left})(costs[left],left) 放入小根堆中。同理，如果 id≥right\textit{id} \geq \textit{right}id≥right，那么需要将 right\textit{right}right 减少 111，并将新的 (costs[right],right)(\textit{costs}[\textit{right}], \textit{right})(costs[right],right) 放入小根堆中。
     * 如果 left+1≥right\textit{left} + 1 \geq \textit{right}left+1≥right，说明我们已经可以选择任意的工人，此时再向小根堆中添加工人会导致重复，因此只有在 left+1<right\textit{left} + 1 < \textit{right}left+1<right 时，才会移动 left\textit{left}left 或 right\textit{right}right 并添加工人。
     */
    public long totalCostV2(int[] costs, int k, int candidates) {
        // 排序规定
        PriorityQueue<int[]> ints = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);


        // 定义边界
        int left = candidates - 1;
        int right = costs.length - candidates;

        if (left < right - 1) {  // 左边界小于右边界，就是不能够完全涵盖全部数据，只加前后两头数据就好了
            for (int i = 0; i <= left; i++) {
                ints.offer(new int[]{costs[i], i});
            }

            for (int i = costs.length - 1; i >= right; i--) {
                ints.offer(new int[]{costs[i], i});
            }
        } else { // 把所有数据都放进去
            for (int i = 0; i < costs.length; i++) {
                ints.offer(new int[]{costs[i], i});
            }
        }

        long sum = 0;
        // 根据k，遍历取数，然后再往里面放
        for (int i = 0; i < k; i++) {
            int[] poll = ints.poll();
            int index = poll[1];
            sum += poll[0];
            if (left < right - 1) {
                if (index <= left) {
                    left++;
                    ints.offer(new int[]{costs[left], left});
                }else {
                    right--;
                    ints.offer(new int[]{costs[right], right});
                }
            }
        }
        return sum;
    }
}
