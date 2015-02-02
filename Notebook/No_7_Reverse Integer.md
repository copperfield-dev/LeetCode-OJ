# Reverse Integer

[LeeCode|Math]

## Problem

> Reverse digits of an integer.

> Example1: x = 123, return 321
> Example2: x = -123, return -321

> **`Notice`** **Have you thought about this?**
> - If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

> - Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

## Solution

- 由个位起逐位获取数字
- 需要注意如何判断该数反转之后是否会溢出，解决方法有以下几种：

	1. **Check if you are ABOUT to overflow before adding:**  
                           
	 ``` java  
	 if (sign == 1) {
	     if (result == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10) 
	         return 0; 
	     if (result > Integer.MAX_VALUE / 10) 
	         return 0;
	 }
	 else if (sign == -1) {
	     if (result == Integer.MIN_VALUE / 10 && x % 10 < Integer.MIN_VALUE % 10)
	         return 0;
	     if (result < Integer.MIN_VALUE / 10)
	         return 0;
	 }
	 ```

	2. **Trickier way, declare 'result' as long, and check if exceeds Integer.MAX_VALUE.** Just remember to cast back to int when returning.
