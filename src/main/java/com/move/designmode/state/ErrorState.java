package move.designmode.state;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-07-13 19:06
 */
public class ErrorState implements ATMState{
    @Override
    public void insertCard() {
        System.out.println("ATM出现错误");
    }

    @Override
    public void inputPwd() {
        System.out.println("ATM出现错误");
    }

    @Override
    public int queryBalance() {
        System.out.println("ATM出现错误");
        return -1;
    }

    @Override
    public void getCash(int cash) {
        System.out.println("ATM出现错误");
    }

    @Override
    public void quitCard() {
        System.out.println("ATM出现错误");
    }
}
