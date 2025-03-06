import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class InventoryItem {
    String name;
    double price;
    int quantity;
    
    public InventoryItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public class InventoryManagementSystem {
    private static Map<String, InventoryItem> inventory = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("\nInventory Management System");
        System.out.println("1. Add Item");
        System.out.println("2. Set Quantity");
        System.out.println("3. Display Inventory");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    
        int choice = sc.nextInt();
        
    switch(choice) {
        case 1: 
            // Add Item
            System.out.print("Enter item name: ");
            String name = sc.nextLine();
            System.out.println("Enter item price: ");
            double price = sc.nextDouble();
            System.out.println("Enter item quantity: ");
            int quantity = sc.nextInt();
            
            InventoryItem item = new InventoryItem(name, price, quantity);
            inventory.put(name, item);
            System.out.println("Item'" + name + "'has been added to your inventory");
            break;
        
            
        case 2:
            // Set Quantity
            System.out.print("Enter item name: ");
            String itemname = sc.nextLine();
            
            if (inventory.containsKey(itemname)) {
                System.out.print("Enter new quantity: ");
                int qty = sc.nextInt();
                sc.nextInt();
                
                inventory.get(itemname).quantity = qty;
                System.out.println("Quantity of '" + itemname + "'set to" + qty + ".");
                
            } else { 
                System.out.println("Item'" + itemname + "'not found in inventory."); 
            }
            
            
            break;
        
        case 3:
            // Display Inventory
            System.out.println("\nInventory: ");
            System.out.println("Item Name\tPrice\tQuantity");
            System.out.println("---------\t-----\t--------");
            
            for (InventoryItem itemx : inventory.values()) {
            System.out.println(itemx.name + "\t\t" + itemx.price + "\t" + itemx.quantity);
            }
            
            if (inventory.isEmpty()) {
                System.out.println("Inventory is empty.");
            }
            break;
            
        case 4:
        // Exit 
        System.out.println("Exiting...");
        sc.close();
        return;
    default:
      System.out.println("Invalid option! Please try again.");
    }
}

}
