package leetCode.binarySearch.matrix;

// 搜索二维矩阵
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left =0,right=m-1;
        if(target<matrix[left][0] || target>matrix[right][n-1]) return false;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] == target||matrix[mid][n-1]==target) {
                return true;
            }else if(matrix[mid][n-1]<target){
                left = mid + 1;
            } else {
                return binarySearch(matrix[mid], target) != -1;
            }
        }
        return false;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
