//file: Consumer.java
import java.util.Vector;

public class Consumer implements Runnable 
{
    Producer producer;

    Consumer( Producer producer ) {
        this.producer = producer;
    }

    public void run() {
        while ( true ) {
            String message = producer.getMessage();
            System.out.println("Got message: " + message);
			try { 
				Thread.sleep( 2000 ); 
			} catch ( InterruptedException e ) { }
        }
    }

    public static void main(String args[]) {
        Producer producer = new Producer();
        new Thread( producer ).start();
        Consumer consumer = new Consumer( producer );
        new Thread( consumer ).start();
    }
}
