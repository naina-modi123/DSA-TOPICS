class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n+1];
        fact[0] = 1;

        for(int i=1;i <= n;i++) {
            fact[i] = fact[i-1]*i;
            numbers.add(i);
        }
        k = k-1;
        StringBuilder result = new StringBuilder();
        for(int i=1;i<=n;i++) {
            int index = k / fact[n - i];
            result.append(numbers.get(index));
            numbers.remove(index);
            k = k % fact[n - i];
        }
        return result.toString();
    }
}
