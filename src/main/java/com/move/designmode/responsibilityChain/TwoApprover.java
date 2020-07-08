package move.designmode.responsibilityChain;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-07-08 16:25
 */
public class TwoApprover  extends Approver{
    @Override
    public void processRequest(Request request) {
        if (request!=null && request.money>500 &&request.money<1000){
            System.out.println("twoApprover 批准了该请求");
        }else if(nextApprover!=null){
            nextApprover.processRequest(request);
        }else {
            System.out.println("不符合审批流程");
        }

    }
}
