package move.designmode.responsibilityChain;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-07-08 16:28
 */
public class Test {
    public static void main(String[] args) {
        Request request = new Request();
        request.money = 1000;
        OneApprover oneApprover = new OneApprover();
        TwoApprover twoApprover = new TwoApprover();
        oneApprover.setNextApprover(twoApprover);
        oneApprover.processRequest(request);
    }
}
