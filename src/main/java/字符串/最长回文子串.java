package 字符串;

public class 最长回文子串 {

    // 中心扩展算法 处理回文串
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAround(s, i, i);
            int len2 = expandAround(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2; // 这里需要注意
                end = i + len / 2;
            }

        }

        return s.substring(start, end + 1);
    }

    private int expandAround(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 退出循环时候，left在最长回文串的左边，right在最长回文串的右边， 所以需要-1； 例如 {aba}，退出循环时候，left = -1， right = 3
        return right- left - 1;
    }
}
