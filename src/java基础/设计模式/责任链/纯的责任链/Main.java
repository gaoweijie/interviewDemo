package java基础.设计模式.责任链.纯的责任链;

/**
 * 责任链模式可以分为纯责任链模式与不纯的责任链模式，其区别在于每个处理者的行为定义。
 * 对于纯责任链模式而言，每个处理者要么处理请求，要么把请求传递给下一个处理者，二者只能选其一。
 * 对于不纯的责任链模式而言，每个处理者可以既处理请求，又把请求传递给下一个处理者。下面将分别对纯责任链模式与不纯的责任链模式进行说明。
 */
public class Main {
    public static void main(String[] args) {
        // 构造责任链
        Filter groupLeaderFilter = new GroupLeaderFilter();
        Filter deptLeaderFilter = new DeptLeaderFilter();
        Filter finalBossFilter = new FinalBossFilter();
        groupLeaderFilter.setNextFilter(deptLeaderFilter);
        deptLeaderFilter.setNextFilter(finalBossFilter);

        // 处理张三的请求
        Request request = new Request();
        request.setDays(10);
        request.setName("张三");
        Response response = new Response();

        System.out.println("开始审批张三的请求");
        groupLeaderFilter.doFilter(request, response);
        System.out.println("张三的请假审批结果：" + response);
    }
}