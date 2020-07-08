package move.designmode.responsibilityChain;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-07-08 16:23
 */
public abstract   class Approver {
    public Approver nextApprover;

    public Approver getNextApprover() {
        return nextApprover;
    }

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    abstract public void  processRequest(Request request);

}
