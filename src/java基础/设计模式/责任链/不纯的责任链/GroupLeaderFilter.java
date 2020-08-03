package java基础.设计模式.责任链.不纯的责任链;

/**
 * 组领导审批链
 */
public class GroupLeaderFilter implements Filter {

    public void doFilter(Request request, Response response, FilterChain filterChain) {

        request.getOpinions().add("group_leader 同意");

        filterChain.doFilter(request, response, filterChain);

        response.getSign().add("group_leader 签名");
    }
}