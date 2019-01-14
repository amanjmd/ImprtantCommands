
public class Inventory {
	Integer myInventory=3;
	int maxInventory=3;
/*
 * in this we can break the things in two 
 * Expecting update conditions :
 * 	for producer , when inventory is full , it will exepct update as there will be no position add new product
 * 	for consumer , when inventory is zero , it will expect the producer to fill the inventory again 
 * For these two conditions the respective threads will wait 
 * 
 * when peroforming the update ,, the thread will notify the other waiting on the same object.
 * 
 * 
 * 
 * */	
	public void produce() throws InterruptedException {
		synchronized (this) {

			while(true) {
				//				System.out.println(myInventory + " " + maxInventory);
				if(myInventory==maxInventory) 
					/* in this condition, the producer thread is expecting updations from the 
					 * consumer thread , ie to consume and update the inventory, Hence it waits 
					 * ;and we know that , the thread expecting updation waits and updating thread notifies 
					 * so when the consumer consumes , it notifies the producer about consumption . But there can be case 
					 * that notify does not releases lock immediately , hence the consumer might go on consuming 
					 * 
					 */
					wait();

				myInventory = myInventory+1;
				notify();
				System.out.println("Adding to  Inventory. Inventory count  " + myInventory);
				Thread.sleep(3000);


			}
		}

	}
	// Synchronized(this)is similar to calling synchronized method over the object , 
	public  void consume() throws InterruptedException {
		synchronized (this) {
			while(true) {
				if(myInventory==0)
				{
					wait();
				}	
				myInventory=myInventory-1;
				notify();
				System.out.println("consuming from Inventory. Inventory Becomes " + myInventory);
				Thread.sleep(2000);


			}
		}

	}
}
