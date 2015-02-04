# Longest Substring Without Repeating Characters 

[LeetCode|Hash Table|String]

## Problem

> Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

## Solution

### Idea_1

- 使用Hash Table进行重复字母的搜索（Hash Table的size为35，可以保证客座率为0.75），遇到没有重复的字母，就添加进Hash Table，如果遇到重复的字母就对Hash Table的当前元素进行处理
- 我的Hash实现和网上其他解答的Hash实现不太一样
- 使用两个指针 ，一个指针为start，指向当前遍历的字符串的开始位置，如果遇到重复字符x，就将start的位置改为上一个x位置+1
- 处理的细节：移除从start指针起，到当前重复元素之前的所有字母
- 注意对长度和最大长度的比较和记录

### Idea_2 动态规划（未研究）

- 假设A[0]到A[i]的最长不包含重复元素字串长度为maxsublength，那么当加入一个元素A[i+1]时，需要考虑的是包含A[i+1]在内的最长不包含重复元素字串，所以可以通过以A[i+1]起始向前搜索而找到,设长度为length
- 在这里，可以通过定义barrier表示以A[i]为起始，向前搜索而出现第一次重复的位置，这样A[i+1]的前向搜索最多只需搜索到A[barrier+1]，因此A[0]到A[i+1]的最长不包含重复元素字串长度为Max(maxsublength,length)

> **动态规划的形式化定义如下**：

> length(i)：以A[i]结尾的最长不包含重复元素字串的长度；
> maxlength(i,j):A[i]到A[j]的最长不包含重复元素字串的长度；
> if i=0 Then maxlength(0,0)=1;
> if i>=1 Then maxlength(0,i)=Max(maxlength(0,i-1),length(i));

> **求解**：maxlength(0,A.length);

#### 代码实现

``` java
public class Solution {
    //动态规划
    public int lengthOfLongestSubstring(String s) {
        if(s==null) return 0;
        char[] c=s.toCharArray();
        if(c.length==0) return 0;
        int maxsublength=1;
        int barrier=0;
        for(int i=1;i<c.length;i++)
        {
            for(int j=i-1;j>=barrier;j--)
            {
                if(c[i]==c[j])
                {
                    barrier=j+1;
                    break;
                }
            }
            maxsublength=Math.max(maxsublength,i-barrier+1);
        }
        return maxsublength;
    }
}
```