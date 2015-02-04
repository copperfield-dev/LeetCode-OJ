# Two Sum

[LeetCode|《编程之美》|Array|Hash Table]

## Problem

> Given an array of integers, find two numbers such that they add up to a specific target number.

> The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

> You may assume that each input would have exactly one solution.

> Input: numbers={2, 7, 11, 15}, target=9
> Output: index1=1, index2=2

## Solution

### Idea_1 穷举

- 从数组中任意取出两个数字，计算两者之和是否为给定的数字
- 时间复杂度为$N(N - 1) / 2$ 即$ O(N^2) $

### Idea_2 Hash Table

- 对数组中的每个数字***numbers[i]***都判别***target-numbers[i]***是否在数组中
- `提高查找效率通常可以先将要查找的数组排序`，然后用二分查找等方法进行查找，就可以将原来$$O(N)$$的查找时间缩短为$$O(\log_2N)$$，总的时间复杂度（包括排序和查找）为$$O(N\log_2N)$$
- 可以利用更快的查找方法：Hash表，给定一个数字，根据Hash映射查找另一个数字是否在数组中，只需要用$$O(1)$$的时间，总的时间复杂度为$$O(N)$$

### Idea_3 对两个数字的和进行遍历

- 对两个数字的和进行一个有序的遍历
- 这种遍历可以利用一个巧妙的方法：通过对**排好序**的数组，令$$i = 0, j = n - 1$$，看***numbers[i]*** + ***numbers[j]***是否等于***target***，如果是，则结束，如果小于***target***，则$$i = i + 1$$；如果大于***target***，则$$j = j - 1$$
- 这样只需要在排好序的数组上遍历一次，就可以得到最后的结果，时间复杂度为$$O(N)$$，总的时间复杂度（排序+遍历）为$$O(N\log_2N)$$