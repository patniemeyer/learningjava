import java.util.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.*;

public class TestCondition 
{

	public static void main( String [] args ) throws Exception
	{
		Lock lock = new ReentrantLock();
		Condition cond = lock.newCondition();
		lock.lock();
		cond.await( 1, TimeUnit.SECONDS );
		lock.unlock();
	}

}
