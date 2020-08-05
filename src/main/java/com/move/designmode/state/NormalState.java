package move.designmode.state;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-07-13 17:29
 */
public class NormalState implements ATMState {
    private ATMContext atmContext;

    public NormalState(ATMContext atmContext) {
        this.atmContext = atmContext;
    }


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
        System.out.println("查询余额为" + atmContext.balace);
        return atmContext.balace;
    }

    @Override
    public void getCash(int cash) {
        if (atmContext.balace >= cash) {
            atmContext.balace -= cash;
            System.out.println("取钱完成");
        } else {
            System.out.println("余额不足");
        }
        if (atmContext.balace == 0) {
            atmContext.setAtmState(ATMContext.noCashCashState);
        }
    }

    @Override
    public void quitCard() {
        System.out.println("退出卡片");
    }

    public static void main(String[] args) {
        System.out.println("");
    }
}
