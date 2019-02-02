package it.sevenbits;

public class ThreadExecutor {
    public void showAccountFilling(long millis) throws InterruptedException {
        Account account = new Account(0);

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getId() + " started working");
            while (true) {
                try {
                    account.addToBalance(10);
                } catch (Exception e) {
                    break;
                }
            }
            System.out.println(Thread.currentThread().getId() + " stopped working");
            });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getId() + " started working");
            while (true) {
                try {
                    account.addToBalance(20);
                } catch (Exception e) {
                    break;
                }
            }
            System.out.println(Thread.currentThread().getId() + " stopped working");
        });

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getId() + " started working");
            while (true) {
                try {
                    account.addToBalance(15);
                } catch (Exception e) {
                    break;
                }
            }
            System.out.println(Thread.currentThread().getId() + " stopped working");
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(account.toString());
    }
}
