package move.designmode.responsibilityChain;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-07-08 16:23
 */
public class OneApprover  extends Approver{
    @Override
    public void processRequest(Request request) {
        if (request!=null&&request.money<500){
            System.out.println("oneapprover 审批了这个请求");
        }else if (nextApprover!=null){
            nextApprover.processRequest(request);
        }else {
            System.out.println("不符合审批标准");
        }
    }
}
