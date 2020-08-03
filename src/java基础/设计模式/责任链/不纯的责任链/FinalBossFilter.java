package java基础.设计模式.责任链.不纯的责任链;

/**
 * 最终的boss审批
 */
public class FinalBossFilter implements Filter {
    public void doFilter(Request request, Response response, FilterChain filterChain) {

        request.getOpinions().add("final_boss 同意");

        filterChain.doFilter(request, response, filterChain);

        response.getSign().add("final_boss 签名");
    }
}
