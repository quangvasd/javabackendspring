package vn.plusplus.threading.Ex5;

public class MainEx5 {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Thread husband = new Thread(new WithdrawThread(bankAccount, 1000000));
        husband.setName("Husband");
        Thread wife = new Thread(new WithdrawThread(bankAccount, 3000000));
        wife.setName("Wife");

        wife.start();
        husband.start();
    }
}
    class BankAccount {
        private Long amount = 20000000L;

        public void withDraw(String threadName, long withDrawAmount) {
            System.out.println(System.currentTimeMillis() + ": " + threadName + " need " + withDrawAmount + ", see balance: " + amount);
            synchronized (this) {
                if (withDrawAmount > amount) {
                    System.out.println(System.currentTimeMillis() + ": " + threadName + " withdraw failed");
                } else {
                    amount = amount - withDrawAmount;
                    System.out.println(System.currentTimeMillis() + ": " + threadName + " withdraw successful");
                }
            }
            System.out.println(System.currentTimeMillis() + ": " + threadName + " see balance: " + amount);
        }
    }

    class WithdrawThread implements Runnable {
        BankAccount bankAccount;
        Long withdrawAmount;

        public WithdrawThread(BankAccount bankAccount, long withdrawAmount) {
            this.bankAccount = bankAccount;
            this.withdrawAmount = withdrawAmount;
        }

        @Override
        public void run() {
            while (true) {
                bankAccount.withDraw(Thread.currentThread().getName(), withdrawAmount);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
