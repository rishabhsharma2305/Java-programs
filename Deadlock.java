/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlock;

/**
 *
 * @author hp
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class Deadlock1 implements Runnable{
    private Lock lock1=null;
    private Lock lock2=null;
    public Deadlock1(Lock l1,Lock l2)
    {
        this.lock1=l1;
        this.lock2=l2;
    }
    
    public void run()
    {
        String threadname= Thread.currentThread().getName();
        System.out.println(threadname+" locking lock1");
        lock1.lock();
        System.out.println(threadname+" locked lock1");
        try{
            Thread.sleep(3000);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println(threadname+" locking lock2");
        lock2.lock(); // now here thread could not hold lock2 because another thread is already holding lock2
        System.out.println(threadname+" locked lock2");
        System.out.println("unlocking lock 1");
        lock1.unlock();
        System.out.println("unlocking lock 2");
        lock2.unlock();
        
    }
}
class Deadlock2 implements Runnable{
    private Lock lock1=null;
    private Lock lock2=null;
    public Deadlock2(Lock l1,Lock l2)
    {
        this.lock1=l1;
        this.lock2=l2;
    }
    
    public void run()
    {
        String threadname= Thread.currentThread().getName();
        System.out.println(threadname+" locking lock2");
        lock2.lock();
        System.out.println(threadname+" locked lock2");
        try{
            Thread.sleep(3000);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println(threadname+" locking lock1");
        lock1.lock();// now here thread could not hold lock1 because another thread is already holding lock1
        System.out.println(threadname+" locked lock1");
        System.out.println("unlocking lock 1");
        lock1.unlock();
        System.out.println("unlocking lock 2");
        lock2.unlock();
        
    }
}
public class Deadlock{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Lock lock1= new ReentrantLock();
        Lock lock2= new ReentrantLock();
        Deadlock1 obj1= new Deadlock1(lock1,lock2);
        Deadlock2 obj2= new Deadlock2(lock1,lock2);
        Thread t1= new Thread(obj1);
        Thread t2= new Thread(obj2);
        t1.start();
        t2.start();
    }
    
}
