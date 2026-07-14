import java.util.HashSet;

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean domain = false;
            boolean ignore = false;

            for (char ch : email.toCharArray()) {
                if (ch == '@') {
                    domain = true;
                    ignore = false;     
                    sb.append(ch);
                } 
                else if (domain) {
                    sb.append(ch);
                } 
                else {
                    if (ch == '+') {
                        ignore = true;
                        continue;
                    }
                    if (ch == '.') {
                        continue;        
                    }
                    if (!ignore) {
                        sb.append(ch);
                    }
                }
            }

            uniqueEmails.add(sb.toString());
        }

        return uniqueEmails.size();
    }
}