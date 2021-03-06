package test.stringquestion;

import org.junit.Test;
import test.testhelp.TestHelper;
import test.testhelp.safeTest;

/**
 * @author wangfy
 * @Description 字符串
 * @date 2018/11/5
 */

public class StringQuestionOne {

    @Test
    public void testOne() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        TestHelper.test(getClass(), "rotate2", ints, 3);
    }

    /**
     * @return void
     * @Description 可以采取反转的方法，先反转前n-k个元素，再反转后k个元素，
     * 然后再将整个数组反转，就能得到该数组旋转k个元素的结果了
     * @Param [nums, k]
     * @Line 27
     **/
    @safeTest(300)
    public void rotate(int[] nums, int k) {
        if (k > nums.length)
            k %= nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
//        Arrays.stream(nums).forEachOrdered(o -> System.out.print(o + " "));
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums.length == 0 || (k %= nums.length) == 0) {
            return;
        }
        int length = nums.length;
        int start = 0;
        int i = 0;
        int cur = nums[i];
        int cnt = 0;

        while (cnt++ < length) {
            i = (i + k) % length; //计算索引新的位置
            int t = nums[i]; //临时保存
            nums[i] = cur;    //
            if (i == start) {
                ++start;
                ++i;
                cur = nums[i];
            } else {
                cur = t;
            }
        }
    }

    public String shortestPalindrome(String s) {
        int i = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) i++;
        }
        if (i == s.length()) return s;
        String tmp = reverseSt(s.substring(i));
        return tmp + shortestPalindrome(s.substring(0, i)) + s.substring(i);
    }

    public String reverseSt(String target) {
        char[] tmp = target.toCharArray();
        char[] result = new char[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            result[i] = tmp[tmp.length - i - 1];
        }
        return String.valueOf(result);
    }
    /**
     * @date 2019/4/5 5:56
     * @return int
     * @Description 713. 乘积小于K的子数组
     * 尺取法
     * @Param [nums, k] 
     **/
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int left = 0, res = 0;
        int pre = 1;
        for(int right = 0; right < nums.length; right++){
            pre *= nums[right];
            while(pre >= k){
                pre /= nums[left++];
            }
            res += right - left + 1;
        }
        return res;
    }
}
