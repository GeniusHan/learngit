package test;

/**
 *	 创建线程导致内存溢出的异常
 * @author wsw
 *
 */
public class JavaVMStackOOM 
{
	private int count = 0;
	
	private void dontStop()
	{
		while(true)
		{
			System.out.println(++count);
		}
	}
	
	public void stackLeakByThread()
	{
		while(true)
		{
			Thread thread = new Thread(new Runnable() 
			{
				@Override
				public void run() 
				{
					dontStop();			
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args)
	{
		JavaVMStackOOM com = new JavaVMStackOOM();
		com.stackLeakByThread();
	}
}
