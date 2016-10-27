package leetcode;

/**
 * @author Harshali
 * 
 */
 
public class SimpleDeadlock {
 
    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
 
        Thread t1 = new Thread(new DangerousDeadlock(obj1, obj2), "Thread1");
        Thread t2 = new Thread(new DangerousDeadlock(obj2, obj3), "Thread2");
        Thread t3 = new Thread(new DangerousDeadlock(obj3, obj1), "Thread3");
 
        t1.start();
        Thread.sleep(3000);
        t2.start();
        Thread.sleep(3000);
        t3.start();
    }
}
 
class DangerousDeadlock implements Runnable {
    private Object obj1;
    private Object obj2;
 
    public DangerousDeadlock(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
 
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (obj1) {
            System.out.println(name + " acquired lock on Object1: " + obj1);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
 
            synchronized (obj2) {
                System.out.println(name + " acquired lock on Object2: " + obj2);
            }
            System.out.println(name + " released lock on Object2: " + obj2);
        }
        System.out.println(name + " released lock on Object1: " + obj1);
        System.out.println(name + " Finished Crunchify Deadlock Test.");
    }
}
