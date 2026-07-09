// Last updated: 7/9/2026, 10:24:56 AM
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        System.out.println(sol.simplifyPath("/home/"));                // Output: /home
        System.out.println(sol.simplifyPath("/home//foo/"));           // Output: /home/foo
        System.out.println(sol.simplifyPath("/home/user/Documents/../Pictures")); // Output: /home/user/Pictures
        System.out.println(sol.simplifyPath("/../"));                  // Output: /
        System.out.println(sol.simplifyPath("/.../a/../b/c/../d/./")); // Output: /.../b/d
    }
}

class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // Skip empty or current directory
                continue;
            } else if (part.equals("..")) {
                // Go up one level if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Valid directory name
                stack.push(part);
            }
        }
        
        // Build canonical path
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.insert(0, "/" + dir);
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
