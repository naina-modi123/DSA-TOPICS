class Solution {
    private int[] ngr(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        ans[n-1] = -1;
        
        st.push(arr[n-1]);
        
        for(int i = n-2;i>=0;i--) {
            while(st.size() > 0 && st.peek() <= arr[i]) {
                st.pop();
            }
            
            if (st.size() == 0) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            
            st.push(arr[i]);
        }
        return ans;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = ngr(nums2, nums2.length);
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int value = nums1[i];
            int index = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == value) {
                    index = j;
                    break;
                }
            }
            ans[i] = nge[index];
        }
        return ans;
    }
}