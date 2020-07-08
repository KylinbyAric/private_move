package move.designmode.responsibilityChain.filter;

import move.designmode.responsibilityChain.Request;
import move.designmode.responsibilityChain.Response;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-07-08 16:44
 */
public class HtmlFilter  implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("HTML 过滤");

    }
}
