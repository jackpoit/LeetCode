package leetcode.first;

public class Test {
    public static void main(String[] args) {
        String s="leetcode";
        s=s.replace("a","*");
        s=s.replace("u","a");
        s=s.replace("*","u");
        s=s.replace("e","*");
        s=s.replace("o","e");
        s=s.replace("*","o");
        System.out.println(s);
    }
}
