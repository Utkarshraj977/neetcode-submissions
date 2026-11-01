class Solution {
    public String encode(List<String> strs) {
        char del = '₹';
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append(del);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        char del = '₹';
        List<String> ls = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            StringBuilder sb = new StringBuilder();
            while (str.charAt(i) != del) {
                sb.append(str.charAt(i++));
            }
            ls.add(sb.toString());
            i++;
        }
        return ls;
    }
}
