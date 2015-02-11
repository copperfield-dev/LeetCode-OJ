# Single Number II

[LeetCode|Bit Manipulation]

## Problem

> Given an array of integers, every element appears three times except for one. Find that single one.

> **Note**:
> Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

## Solution

### 此类问题的通用解法

- 对每个元素出现偶数次来说，只要把所有元素异或就能找到这个单独的元素
- 对每个元素出现奇数次（k次）来说：
  	
	1、用数组存储所有元素（二进制表示）各个位上 “1” 出现的次数之和
	
	2、对该数组分别进行模k操作，如果为1，那说明这一位是要找的单独元素二进制表示中为 “1” 的那一位

	```Java
	public int singleNumber(int[] A) {
        int[] bitNum = new int[32]; 
        for (int i = 0; i < bitNum.length; i++)
            bitNum[i] = 0;
        int singleNumber = 0;
        for (int i = 0; i < bitNum.length; i++) {
            for (int j = 0; j < A.length; j++) {
                bitNum[i] += (A[j] >> i) & 1;
            }
            singleNumber |= (bitNum[i] % 3) << i;
        }

        return singleNumber;
    }
	```

### 使用掩码变量

- ***ones*** 代表第i个元素出现一次的掩码变量
- ***twos*** 代表第i个元素出现两次的掩码变量
- ***threes*** 代表第i个元素出现三次的掩码变量
- 最后返回***ones*** 即为所求答案

	```Java
	public int singleNumber(int[] A) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < A.length; i++) {
            twos |= ones & A[i];
            ones ^= A[i];
            threes = ones & twos;
            //对于ones 和 twos 把出现了3次的位置设置为0 
            //取反之后1的位置为0
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
	```