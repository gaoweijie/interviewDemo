package java基础.设计模式.责任链.不纯的责任链;

/**
 * 部门领导审批
 */
public class DeptLeaderFilter implements Filter {
    public void doFilter(Request request, Response response, FilterChain filterChain) {

        request.getOpinions().add("dept_leader 同意");

        filterChain.doFilter(request, response, filterChain);

        response.getSign().add("dept_leader 签名");
    }
}