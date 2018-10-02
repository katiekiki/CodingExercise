public class ArraysMergeSortedArrays {

    public static void main(String[] args) {

        int[] input1 = {1,2,3,0,0,0};
        int[] input2 = {2,5,6};

        merge2(input1,3,input2,3);

//        int[] result = merge(input1,3,input2,3);
//
        System.out.print("The merge result ");
        for (int output : input1) {
            System.out.print(output + " ");
        }

    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];

        int nums1Ptr = 0, nums2Ptr = 0, index = 0;

        while (nums1Ptr < m &&  nums2Ptr < n) {
            if (nums1[nums1Ptr] < nums2[nums2Ptr]) {
                result[index] = nums1[nums1Ptr];
                nums1Ptr++;
            } else {
                result[index] = nums2[nums2Ptr];
                nums2Ptr++;
            }
            index++;
        }

        if (nums1Ptr < m) {
            while (nums1Ptr < m) {
                result[index] = nums1[nums1Ptr];
                index++;
                nums1Ptr++;
            }
        }

        if (nums2Ptr < n) {
            while (nums2Ptr < n) {
                result[index] = nums2[nums2Ptr];
                index++;
                nums2Ptr++;
            }
        }

        return result;
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        int count = nums1.length -1;
        int num1Ptr= m -1, num2Ptr = n-1;


        while (num1Ptr >= 0 && num2Ptr >= 0) {
            if (nums1[num1Ptr] > nums2[num2Ptr]) {
                nums1[count] = nums1[num1Ptr];
                num1Ptr--;
            } else {
                nums1[count] = nums2[num2Ptr];
                num2Ptr--;
            }
            count--;
        }

        while (num1Ptr >= 0 && count >= 0) {
            nums1[count] = nums1[num1Ptr];
            num1Ptr--;
            count--;
        }

        while (num2Ptr >= 0 && count >= 0) {
            nums1[count] = nums2[num2Ptr];
            num2Ptr--;
            count--;
        }

    }
}

