package petprojects;
public class Item{
	 public String itemName;
	 public String type;
	 public int value;
	 
	 public Item(String itemName,String type,int value){
		 this.itemName=itemName;
		 this.type=type;
		 this.value=value;
	 }
	 
	 public void displayInfo() {
		 System.out.println("Item name: "+this.itemName+"Type: "+this.type+"Value: "+this.value);
	 }
	 
}