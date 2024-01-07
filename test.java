public class test {
    public static void main(String[] args) {
        dfs(3);
    }

    public static void dfs(int n) {
        if (n == 0) {
            System.out.println("종료");
            return;
        } else {
            dfs(n-1);
            System.out.println(n + " ");
        }
    }
}
