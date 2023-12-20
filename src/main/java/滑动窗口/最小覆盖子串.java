package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0; // 滑动窗口左右指针，左闭右开区间方便边界处理
        int valid = 0; // window窗口中符合的字符个数
        int start = 0, len = Integer.MAX_VALUE; // 最小覆盖子串的起始索引和长度

        while (right < s.length()) {
            char c = s.charAt(right); // 移入窗口的字符
            right++; // 扩大窗口
            // 进行数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧是否需要收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left); // 移出窗口的字符
                left++; // 缩小窗口
                // 进行数据更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
