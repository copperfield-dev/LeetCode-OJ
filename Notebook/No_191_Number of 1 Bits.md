# Number of 1 Bits

[LeetCode|剑指Offer|Bit Manipulation]

## Problem

> Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

> For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

## Solution

### Idea_1 常规解法

- 把输入的整数n和1做与运算，判断n的最低位是不是为1
- **反复把1左移一位，与n做与运算，**每次判断n的其中一位是不是1

### Idea_2 利用二进制特性

- 把输入的整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0
- 一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作





