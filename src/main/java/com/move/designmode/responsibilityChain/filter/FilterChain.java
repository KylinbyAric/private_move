package move.designmode.responsibilityChain.filter;

import move.designmode.responsibilityChain.Request;
import move.designmode.responsibilityChain.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-07-08 16:42
 */
public class FilterChain {
    public List<Filter> filters = new ArrayList<>();
    public FilterChain addFilter(Filter filter){
        filters.add(filter);
        return this;
    }
    public void doFilter(Request request, Response response){
        for (Filter item:filters) {
            item.doFilter(request,response,this);
        }
    }
}
