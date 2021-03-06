package ProgramCreek.Array_String.SimplePointer;

import java.util.Arrays;

public class NextPermutation {


    public static void main(String[] args) {

//        int[] input = {4, 5, 6, 3, 2, 1 };
        int[] input = {4,2,9,8,5,0,4 };
        System.out.println("Arrays Before : "+ Arrays.toString(input));
        nextPermutation(input);
        System.out.println("Arrays After : "+ Arrays.toString(input));

    }

    public static void nextPermutation(int[] nums) {
        //find first decreasing digit
        int mark = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                mark = i - 1;
                break;
            }
        }

        if (mark == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int idx = nums.length-1;
        for (int i = nums.length-1; i >= mark+1; i--) {
            if (nums[i] > nums[mark]) {
                idx = i;
                break;
            }
        }

        swap(nums, mark, idx);

        reverse(nums, mark + 1, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }



}
