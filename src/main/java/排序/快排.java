package 排序;

import java.util.Arrays;

public class 快排 {
    public int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int idx = partition(nums, left, right);
            quickSort(nums, left, idx - 1);
            quickSort(nums, idx + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left]; // left位置为基准元素
        int i = left + 1; //用来记录大于基准元素的位置

        for (int j = left + 1; j <= right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);// 将小于基准元素的元素放到i位置
                i++;
            }
        }

        swap(nums, left, i - 1); // i是大于基准元素的位置，所以i - 1为基准元素的位置，将基准元素放到正确的位置
        return i - 1;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        快排 clazz = new 快排();
        System.out.println(Arrays.toString(clazz.sort(new int[]{5,1,1,6,7,0})));
    }


}
