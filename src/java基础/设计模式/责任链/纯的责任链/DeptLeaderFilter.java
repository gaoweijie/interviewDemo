package java基础.设计模式.责任链.纯的责任链;

/**
 * 部门领导审批
 */
public class DeptLeaderFilter extends Filter {
    public void doFilter(Request request, Response response) {
        if (request.getDays() <= 3) {
            response.setApprovalName("dept_leader");
            response.setResult(true);
            System.out.println("dept_leader同意了");
            return;
        } else {
            System.out.println("dept_leader无权审批，交给下一级");
            this.getNextFilter().doFilter(request, response);
        }
    }
}
