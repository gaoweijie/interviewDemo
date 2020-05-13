package 算法.字符串;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
 * 最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 * 示例1：
 * 输入："/home/"
 * 输出："/home"
 *
 * 示例2：
 * 输入："/../"
 * 输出："/"
 * 从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 *
 * 示例3：
 * 输入："/home//foo/"
 * 输出："/home/foo"
 *
 * 示例4：
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 *
 * 示例5：
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 *
 * 示例6：
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 */
public class 简化路径 {

    public static void main(String[] args) {
//        String a = "/home/";
//        String a = "/../";
//        String a = "/home/";
//        String a = "/home/";
//        String a = "/home/";
//        String a = "/home/";
        String a = "/a//b////c/d//././/..";
        String s = simplifyPath(a);
        System.out.println(s);
    }

//    public static String simplifyPath(String path) {
//        if (path == null) {
//            return "/";
//        }
//
//        StringBuffer sb = new StringBuffer();
//        path = path.replace("./", "");
//
//        List<Character> q = new ArrayList<>();
//        q.add('/');
//        // 记载最近一个放进去的值
//        char temp = '/';
//
//        for (int i = 1; i < path.length(); i++) {
//            if (temp == '/' && path.charAt(i) == '/') {
//                continue;
//            } else if (i == path.length() - 1 && path.charAt(i) == '/'){
//                continue;
//            } else if (path.charAt(i) != '/' && path.charAt(i) != '.') {
//                temp = path.charAt(i);
//                q.add(path.charAt(i));
//            } else if (temp != '/' && path.charAt(i) == '/') {
//                temp = path.charAt(i);
//                q.add(path.charAt(i));
//            } else if (i < path.length() - 1 &&  path.charAt(i) == '.' && path.charAt(i + 1) == '.' ) {
//                if (temp != '/' ) {
//                    while (!q.isEmpty()) {
//                        sb.append(q.poll());
//                    }
//                    i++;
//                }
//            } else {
//                temp = path.charAt(i);
//                q.offer(path.charAt(i));
//            }
//        }
//        while (!q.isEmpty()) {
//            sb.append(q.poll());
//        }
//        return sb.toString();
//    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // 首先将字符串以 “/” 分隔存储到新的字符数组 str 中
        String[] str = path.split("/");
        for (String s : str) {
            // 如果数组非空,且访问到的是 “..” 则说明要返回上一级,要将当前元素出栈
            if (s.equals("..")) {
                // 这里用到增强型 for 循环不能同时判断，需要再次判空
                // 而普通 for 循环则可写成( !stack.isEmpty() && s.equals("..") )
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                // 如果数组非空并且当前元素不是 “.” 说明当前元素是路径信息，要入栈
            } else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }
        // 如果栈内没有元素说明没有路径信息，返回 “/” 即可
        if (stack.isEmpty()) {
            return "/";
        }
        // 这里用到 StringBuilder 操作字符串，效率高
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            ans.append("/" + stack.get(i));
        }
        return ans.toString();
    }
}
