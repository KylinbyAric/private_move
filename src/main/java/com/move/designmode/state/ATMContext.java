package move.designmode.state;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-07-13 17:50
 */
public class ATMContext {
    public String pwd;
    public int balace;
    private ATMState atmState;
    public static  NormalState normalState;
    public static NoCashCashState noCashCashState;

    public ATMState getAtmState() {
        return atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

}
