package move.designmode.state;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-07-13 17:28
 */
public interface ATMState {
     void insertCard();
    void inputPwd();
    int queryBalance();
    void getCash(int cash);
    void quitCard();
}
