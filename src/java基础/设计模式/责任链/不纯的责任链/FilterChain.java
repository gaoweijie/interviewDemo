package java基础.设计模式.责任链.不纯的责任链;

import java.util.ArrayList;
import java.util.List;

/**
 *  不纯的责任链模式，一个处理者既处理请求，又把请求传递给下一个处理者
 */
public class FilterChain implements Filter {
    private int index = 0;
    private List<Filter> filters = new ArrayList<Filter>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }
	
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        if (index == filters.size()) return;

        Filter filter = filters.get(index);
        index++;
        filter.doFilter(request, response, filterChain);
    }

    //***********************************************************
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public String toString() {
        return "FilterChain{" +
                "index=" + index +
                ", filters=" + filters +
                '}';
    }
}
