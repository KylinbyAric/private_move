package move.designmode.responsibilityChain.filter;

import move.designmode.responsibilityChain.Request;
import move.designmode.responsibilityChain.Response;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-07-08 16:51
 */
public class Test {
    public static void main(String[] args) {
        HtmlFilter htmlFilter = new HtmlFilter();
        TokenFilter tokenFilter = new TokenFilter();
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(htmlFilter).addFilter(tokenFilter);
        filterChain.doFilter(new Request(),new Response());
    }
}
