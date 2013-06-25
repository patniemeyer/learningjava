import java.util.*;
import java.util.concurrent.*;

public class TestSemaphore 
{
	int concurrentUsers = 5;
	boolean fair = true;
	Semaphore sem = new Semaphore( concurrentUsers, fair );

	Data readData() throws InterruptedException {
		sem.acquire();
		// read data ...
		sem.release();

		return null /*data*/;
	}

	public static void main( String [] args )
	{
	}

	class Data { }
}
