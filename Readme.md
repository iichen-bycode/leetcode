[oi-wiki](https://oi-wiki.org/)

[科学刷题](https://leetcode.cn/discuss/post/3141566/ru-he-ke-xue-shua-ti-by-endlesscheng-q3yd/)

[链表](https://leetcode.cn/problem-list/linked-list/)

[双向链表](https://leetcode.cn/problem-list/doubly-linked-list/)

[动态规划](https://leetcode.cn/problem-list/dynamic-programming/)

[KMP图解](https://www.zhihu.com/question/21923021/answer/37475572)
> 本质是减少不匹配时迭代匹配次数（暴力是每次从当前 i+1 匹配，KMP就是减少该次数）
> next数组 即 k（k < len）个的 前后缀相同的 字符串数目 如： 对于 abcab 则 k = 2，详细如下：
> 
> 已知next[i-1]，即前i-1个字符串字串前后缀有两个相同的 abc...ab?,则 
>   
>    1. 若 s[next[i-1]] = s[2] = 'c' = s[i] = ? = 'c' 则next[i] = next[i-1] +1
>    2. 若不相等，如：abcabd...abcabx，则需要获取abcab的next值: abc与abx比较 发现 c与x不同，则再回退
> 获取 ab的next值: 0 则停止，next[i] = 1,若x = c,则next[i] = 3 
>
```java
int[] calculateMaxMatchLengths(String pattern) {
    int[] maxMatchLengths = new int[pattern.length()];
    int maxLength = 0;
    for (int i = 1; i < pattern.length(); i++) {
        while (maxLength > 0 && pattern.charAt(maxLength) != pattern.charAt(i)) {
            maxLength = maxMatchLengths[maxLength - 1]; // ①
        }
        if (pattern.charAt(maxLength) == pattern.charAt(i)) {
            maxLength++; // ②
        }
        maxMatchLengths[i] = maxLength;
    }
    return maxMatchLengths;
}
```

```java
List<Integer> search(String text, String pattern) {
    List<Integer> positions = new ArrayList<>();
    int[] maxMatchLengths = calculateMaxMatchLengths(pattern);
    int count = 0;
    for (int i = 0; i < text.length(); i++) {
        while (count > 0 && pattern.charAt(count) != text.charAt(i)) {
            count = maxMatchLengths[count - 1];
        }
        if (pattern.charAt(count) == text.charAt(i)) {
            count++;
        }
        if (count == pattern.length()) {
            positions.add(i - pattern.length() + 1);
            count = maxMatchLengths[count - 1];
        }
    }
    return positions;
}
```

![alt text](https://picx.zhimg.com/80/v2-6d6a40331cd9e44bfccd27ac5a764618_720w.webp?source=1def8aca "标注")
![alt text](https://picx.zhimg.com/v2-ce1d46a1e3603b07a13789b6ece6022f_r.jpg?source=1def8aca "标注")
![alt text](https://picx.zhimg.com/80/v2-c5ff4faaab9c3e13690deb86d8d17d71_720w.webp?source=1def8aca "标注")

