// 11. Container With Most Water


class MaxArea {
    public static int maxArea(int[] height) {
        int result = 0;
        int left = 0, right = height.length -1;

        while(left < right){
            int area = (right - left) * Math.min(height[left], height[right]);

            result = Math.max(result, area);

            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        // int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1, 1};
        // Output: 49

        int ans = maxArea(height);

        System.out.println(ans);

    }

}
