package java基础.设计模式.责任链.不纯的责任链;

public class Main {

    public static void main(String[] args) {

        FilterChain filterChain = new FilterChain();
        filterChain.add(new GroupLeaderFilter()).add(new DeptLeaderFilter()).add(new FinalBossFilter());

        Request request = new Request();
        request.setName("张三");
        request.setGold(100L);
        Response response = new Response();
        filterChain.doFilter(request, response, filterChain);

        System.out.println(request);
        System.out.println(response);
    }
}
