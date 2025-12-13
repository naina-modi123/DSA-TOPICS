class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<code.length;i++){
            String str1 = code[i];
            if (str1.length() == 0) continue;
            boolean validCode = true;
            for (char ch : str1.toCharArray()) {
                if (!(Character.isLetterOrDigit(ch) || ch == '_')) {
                    validCode = false;
                    break;
                }
            }
            if (!validCode) continue;
            String str2 = businessLine[i];
            if (!(str2.equals("electronics") ||
                  str2.equals("grocery") ||
                  str2.equals("pharmacy") ||
                  str2.equals("restaurant"))) {
                continue;
            }
            if (!isActive[i]) continue;
            ans.add(str2 + "#" + str1);
        }
        Collections.sort(ans, (a, b) -> {
            String[] p1 = a.split("#");
            String[] p2 = b.split("#");

            int order1 = getOrder(p1[0]);
            int order2 = getOrder(p2[0]);

            if (order1 != order2) {
                return order1 - order2;   
            }
            return p1[1].compareTo(p2[1]); 
        });
        List<String> result = new ArrayList<>();
        for (String s : ans) {
            result.add(s.split("#")[1]);
        }
        return result;
    }
    private static int getOrder(String s) {
        if (s.equals("electronics")) return 0;
        if (s.equals("grocery")) return 1;
        if (s.equals("pharmacy")) return 2;
        return 3; // restaurant
    }
}