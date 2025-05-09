class MergeSortedArray {
    // Method to merge two sorted arrays (nums1 and nums2) into nums1
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Copy nums2 into the extra space of nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        // Apply the Gap Method (a variation of Shell Sort) to sort the merged array
        int length = m + n; // Total length of the merged array
        int gap = (length / 2) + (length % 2); // Initial gap size

        // Continue sorting until the gap is reduced to 0
        while (gap > 0) {
            int left = 0; // Left pointer
            int right = left + gap; // Right pointer (gap distance apart from left)

            // Compare and swap elements that are 'gap' distance apart
            while (right < length) {
                if (nums1[left] > nums1[right]) {
                    swap(nums1, left, right); // Swap if left element is greater than right
                }
                left++;
                right++;
            }

            // Break the loop if the gap is reduced to 1
            if (gap == 1) break;

            // Reduce the gap size for the next iteration
            gap = (gap / 2) + (gap % 2);
        }
    }

    // Helper method to swap two elements in an array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();

        // Example input
        int[] nums1 = {1, 2, 3, 0, 0, 0}; // nums1 with extra space for merging
        int m = 3; // Number of initialized elements in nums1
        int[] nums2 = {2, 5, 6}; // nums2 to be merged into nums1
        int n = 3; // Number of elements in nums2

        // Call the merge method
        solution.merge(nums1, m, nums2, n);

        // Print the merged and sorted array
        System.out.print("Merged Array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}