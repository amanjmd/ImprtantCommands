
public class myMain {

	public static void main(String[] args) {
		Inventory invent = new Inventory();
		Thread producerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					invent.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread consumerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					invent.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		consumerThread.start();
		producerThread.start();
		

	}

	
}
