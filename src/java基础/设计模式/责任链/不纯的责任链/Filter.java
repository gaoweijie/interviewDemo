package java基础.设计模式.责任链.不纯的责任链;

public interface Filter {

    void doFilter(Request request, Response response, FilterChain filterChain);
}