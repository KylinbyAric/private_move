package move.designmode.state;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-07-13 17:57
 */
public class NoCashCashState implements ATMState {
    private ATMContext atmContext;

    @Override
    public void insertCard() {
        System.out.println("插卡完成");
    }

    @Override
    public void inputPwd() {
        if ("1234".equals(atmContext.pwd)) {
            System.out.println("输入密码完成");
        } else {

        }
    }

    @Override
    public int queryBalance() {
        System.out.println("余额："+atmContext.balace);
        return -1;
    }

    @Override
    public void getCash(int cash) {
        System.out.println("ATM现金余额不足");
    }

    @Override
    public void quitCard() {

    }
}
