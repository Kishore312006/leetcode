class Solution {
    public List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<>();

        backtrack(s, 0, 0, "", ans);

        return ans;
    }

    public void backtrack(String s, int index, int parts,
                           String current, List<String> ans) {

        if (parts == 4 && index == s.length()) {
            ans.add(current.substring(0, current.length() - 1));
            return;
        }

        if (parts == 4 || index == s.length()) {
            return;
        }

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String part = s.substring(index, index + len);

            // Leading zero check
            if (part.length() > 1 && part.charAt(0) == '0') {
                continue;
            }

            int num = Integer.parseInt(part);

            // IP part must be 0 to 255
            if (num > 255) {
                continue;
            }

            backtrack(
                s,
                index + len,
                parts + 1,
                current + part + ".",
                ans
            );
        }
    }
}