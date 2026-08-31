package petprojects;

   public class Player{
	    public String name;
	    public int hp;
	    public int gold;
	    Item inventory[]=new Item[20];
	    
	    public Player(String name,int hp,int gold) {
	    	this.name=name;
	    	this.hp=hp;
	    	this.gold=gold;
	    }
	 
	    public void equipItem(Item item) {
	    	  for(int i=0;i<inventory.length;i++) {
	    		  if(inventory[i]!=null) {
	    			  System.out.println("Item is already added");
	    			  return;
	    		  }
	    		  if(inventory[i]==null) {
	    			  inventory[i]=item;
	    			  System.out.println("item added sucesffuly");
	    			  return;
	    		  }
	    	  }
	    	  System.out.println("Inventory is full");
	    }
	    
   
   public void  usePotion(int healAmount) {
	         hp+=healAmount;   
   }
   public void displayStatus() {
	          for(Item item:inventory) {
	        	  if(item!=null) {
	        		 item.displayInfo();
	        		  System.out.println(item);
	        	  }
	          }
   }
   
   
   public void displayInfo() {
	   System.out.println("\n====================");
       System.out.println(" HERO STATUS");
       System.out.println("====================");
       System.out.println("Name : " + name);
       System.out.println("HP   : " + hp);
       System.out.println("Gold : " + gold);
       displayStatus();
       System.out.println("====================\n");
   }
   }