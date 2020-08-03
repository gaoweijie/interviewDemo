package java基础.设计模式.责任链.纯的责任链;

/**
 * 纯责任链模式，一个处理者要么处理请求，要么交给下一个处理者
 * 比如请假审批流，请假小于1天，组领导可批，小于3天，部门领导可批，大于3天的需要大boss批
 */
public abstract class Filter {

    /**
     * 下一个处理者
     */
    public Filter nextFilter;

    public abstract void doFilter(Request request, Response response);

    public Filter getNextFilter() {
        return nextFilter;
    }

    public void setNextFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }
}