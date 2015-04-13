# Rotate Array 

[LeetCode|编程之美|Array]

## Problem

> Rotate an array of n elements to the right by k steps.

> For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

> **Note**:
> 注意k的大小，若k > n, 可以用k = k % n处理

## Solution

### Idea_1 利用辅助数组存取后k位的数字

	1、 Store k elements in a temp array
	2、 Shift rest of the arr[]
	3、 Store back the k elements

**Time complexity**: O(n)
**Space complexity**: O(k)

### Idea_2 一个数字一个数字移动

	1、 Store arr[n - k] in a temporary variable temp
	2、 Move each elements from arr[0] to arr[n - k - 1], 后移1位 
	3、 将temp值存到数组中刚刚移出来的空位上

**Time complexity**: O(n * k)
**Space complexity**: O(1)

### Idea_3 三次翻转 @VectorYao口中的经典解法

	1、 逆序排列前n-k个元素
	2、 逆序排列后k个元素
	3、 将所有元素逆序排列

**Time complexity**: O(n)
**Space complexity**: O(1)
