package test;

/**
 *	 �����̵߳����ڴ�������쳣
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
