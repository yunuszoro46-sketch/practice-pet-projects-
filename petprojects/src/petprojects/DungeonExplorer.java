package petprojects;

import java.util.Scanner;

public class DungeonExplorer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hero name: ");
        String name = scanner.nextLine();
        
        Player player = new Player(name, 100, 5);
        boolean run = true;
        
        while (run) {
            System.out.println("\n----MAIN MENU----");
            System.out.println("1. Add Custom Item to Inventory");
            System.out.println("2. Display Hero Details & Inventory");
            System.out.println("0. Exit Game");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline buffer after reading integer
            
            switch (choice) {
                case 1: {
                    System.out.print("Enter Item name: ");
                    String itemName = scanner.nextLine();

                    System.out.print("Enter Item Type (Weapon/Potion): ");
                    String itemType = scanner.nextLine();

                    System.out.print("Enter Item value: ");
                    int value = scanner.nextInt();
                    scanner.nextLine(); // Clear newline buffer after reading integer
                    
                    Item newitem = new Item(itemName, itemType, value);
                    player.equipItem(newitem); // Called on 'player' instance
                    break;
                }
                case 2:
                    player.displayInfo();
                    break;

                case 0:
                    run = false;
                    System.out.println("Exiting game...");
                    break;
                    
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
        
        scanner.close();
    }
}