package move.designmode.responsibilityChain.filter;

import move.designmode.responsibilityChain.Request;
import move.designmode.responsibilityChain.Response;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-07-08 16:45
 */
public class TokenFilter implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("token 过滤");
    }
}
