[oi-wiki](https://oi-wiki.org/)

[科学刷题](https://leetcode.cn/discuss/post/3141566/ru-he-ke-xue-shua-ti-by-endlesscheng-q3yd/)

[链表](https://leetcode.cn/problem-list/linked-list/)
> 虚拟头节点 + 头插法修改next指向

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

#### 定长滑动窗口 （最大最长）
> 对于定长k，先初始移动满足窗口大小等于k,然后后续移动就是 处理前一个刚进入窗口的元素和最后一个离开窗口的元素。 见：1456
> 关键在于 '入'与’进‘的处理 比如：进 +1， 出 需要-1
> 
##### 求最短最小

##### 求子数组个数
> 越长越合法
```java
    class Solution {
        public int numberOfSubstrings(String s) {
            // 滑动窗口：含a、b、c至少各1次
            int[] cnt = new int[3];
            char[] ss = s.toCharArray();
            int n = s.length(), res = 0;
            for (int i = 0, j = 0; j < n; j++) {
                cnt[ss[j] - 'a']++;
                while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                    cnt[ss[i++] - 'a']--;
                    res += n - j;  // [i..j]已经满足了, 右边界[j..n-1]肯定都可以
                }
            }
            return res;
        }
    }
```
> 越短越合法 

> 恰好型
> 即两次 越长越合法相减  == => >= - >
```java
    public static int numSubarraysWithSum2(int[] nums, int goal) {
        int l1 = 0, l2 = 0, len = nums.length, ans = 0, s1 = 0, s2 = 0;
        for (int i = 0; i < len; i++) {
            s1 += nums[i];
            s2 += nums[i];
            // >= - >
            while (s1 > goal && l1 <= i) {
                s1 -= nums[l1++];
            }
            while (s2 >= goal && l2 <= i) {
                s2 -= nums[l2++];
            }
            ans += l2 - l1;
        }
        return ans;
    }
```

#### 回文串 (Manacher's Algorithm)
> Manacher's Algorithm
>
![alt text](https://pic2.zhimg.com/80/v2-d570f7a9e732d577d556b0e6cff1d263_720w.webp "标注")
![alt text](https://pic3.zhimg.com/80/v2-11f96d39d9648b7c146e49cdceb0854c_720w.webp "标注")


#### 位运算
> 并集 a | b
> 交集 a & b
> 差集（子集）  a ^ b
> 差集（非子集） a & ~b
> 包含于   a & b = a  或  a | b = b
> 
> Integer.bitCount(s) 对应二进制1的数目
> 32-Integer.numberOfLeadingZeros(s) 对应二进制长度
> 31-Integer.numberOfLeadingZeros(s)   最大元素
> Integer.numberOfTrailingZeros(s)   最小元素
> 
> & 两位同时为1，结果才为1，否则为0
> | 参与运算的两个数据只要有一个值为1 那么值为1
> ^ 参加运算的两个对象，如果两个相应位值不同，则该位结果为1，否则为0


#### 模运算
> 记住二进制： 除以2 等价于 右移操作 >>1
> 直接通过二进制 Int长度来遍历， for (int i = 0; i < 31; i++)
> 对于x 只有二进制全为1 才可以进位 x+1。如：3 => 011; 3+1 = 4   => 100

> (a + b) % m  = (a % m  + b % m) % m
> (a * b) % m = ((a % m) * (b % m)) % m
> 对于任意x 取模： (x % m + m) % m
> 除数取模：(a/b) mod p  = (a*b的p-2平方) mod p
>
> 快速幂： 将x转为二进制 不断右移位 如果当前位是1 直接乘当前幂
```java
class Solution {
    public double myPow(double x, int N) {
        double ans = 1;
        long n = N;
        if (n < 0) { // x^-n = (1/x)^n
            n = -n;
            x = 1 / x;
        }
        while (n != 0) { // 从低到高枚举 n 的每个比特位
            if ((n & 1) == 1) { // 这个比特位是 1
                ans *= x; // 把 x 乘到 ans 中
            }
            x *= x; // x 自身平方
            n >>= 1; // 继续枚举下一个比特位
        }
        return ans;
    }
}
```


### 前缀和
[详解](https://leetcode.cn/problems/range-sum-query-immutable/solutions/2693498/qian-zhui-he-ji-qi-kuo-zhan-fu-ti-dan-py-vaar/)
> 前缀和数组：    快速求区间和
```java
    /* 对于数组：a = [1,2,3,4,5,6]
        s[0] = 0
        s[1] = a[0]
        s[2] = a[0] + a[1]
        ...
        s[n] = a[0] + a[1] + ... + a[n]
        
        上诉a数组对于的前缀和数组：
        s[7] = [0,1,3,6,10,15,21] 则任意a[i]到a[j]的子数组和 就等于s[j + 1] - s[i]
    */
```

### 差分
[详解](https://leetcode.cn/problems/car-pooling/solutions/2550264/suan-fa-xiao-ke-tang-chai-fen-shu-zu-fu-9d4ra/)
> 反向前缀和:快速对区间加数  从左到右逐个累加 等于 原数组，所以对于 d[i] + k,还原为原数组是 会每个元素都 + k 

> 当我们想要对原数组的 [l,r] 进行整体修改时，只需要对差分数组的 l 和 r+1 位置执行相应操作即可
```declarative
    /*               0 1 2
        对于数组：a = [1,2,3,4,5,6] ,右侧减当前值 d[i] = a[i] - a[i-1]
        d[] = [1,2-1,3-2,4-3,5-4,6-4] d[0]      补上 a[0]
        d[] = [1,1,1,1,1,1]  
    */
```