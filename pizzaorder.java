import java.util.*;

class Pizza {
    Scanner sc = new Scanner(System.in);
    public int amt = 0;
    public boolean drinkAdded = false;
    public boolean dessertAdded = false;

    void selectBase() {
        System.out.println("Please select your Pizza Base from below listed base:");
        System.out.println("1. Regular - Rs.50 , 2. Whole Wheat - Rs.75");
        System.out.println("Enter 1 for Regular or 2 for Whole Wheat");
        int base = sc.nextInt();
        if (base == 1) {
            amt += 50;
        } else {
            amt += 75;
        }
    }

    void selectSauce() {
        System.out.println("Please select Type of sauce you prefer:");
        System.out.println("1. Marinara sauce  ,  2. Pesto sauce");
        int sauce = sc.nextInt();
        if (sauce == 1) {
            System.out.println("Marinara sauce");
        } else {
            System.out.println("Pesto sauce");
        }
    }

    void selectToppings() {
        System.out.println("Please select toppings you like:");
        String c;
        do {
            System.out.println("1. Mozzarella cheese");
            System.out.println("2. Cheddar cheese");
            System.out.println("3. Spinach");
            System.out.println("4. Corn");
            System.out.println("5. Mushroom ");
            System.out.println("6. Chicken ");
            System.out.println("7. Pepperoni ");
            int toppings= sc.nextInt();
            switch (toppings) {
                case 1 : amt += 30;
                case 2 : amt += 35;
                case 3 : amt += 20;
                case 4 : amt += 15;
                case 5 : amt += 15;
                case 6 : amt += 50;
                case 7 : amt += 45;
                default : System.out.println("Please select any one of the toppings");
            }
            System.out.println("Do you want to add more toppings? Y/N");
            c = sc.next();
        } while (c.equalsIgnoreCase("Y"));
    }

    void selectDrink() {
        System.out.println("1. Pepsi - Rs.17");
        System.out.println("2. 7-up - Rs.19");
        System.out.println("3. Coke - Rs.20");
        System.out.println("Enter your choice:");
        int drink = sc.nextInt();
        switch (drink) {
            case 1 : {
                amt += 17;
                drinkAdded = true;
            }
            case 2 : {
                amt += 19;
                drinkAdded = true;
            }
            case 3 : {
                amt += 20;
                drinkAdded = true;
            }
            default : System.out.println("Select a valid drink option.");
        }
    }

    void selectDessert() {
        System.out.println("1. Lava cake - Rs.95");
        System.out.println("2. Chocolate brownie - Rs.86");
        System.out.println("Enter your choice:");
        int dessert = sc.nextInt();
        switch (dessert) {
            case 1 : {
                amt += 95;
                dessertAdded = true;
            }
            case 2 : {
                amt += 86;
                dessertAdded = true;
            }
            default : System.out.println("Select a valid dessert option.");
        }
    }

    double calculateBill() {
        if (drinkAdded && dessertAdded) {
            return amt-=amt*5/100;
        }
        return amt;
    }
}

class Main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in) ;
            Pizza piz = new Pizza();

            System.out.println("Welcome to Pizza Store!");
            piz.selectBase();
            piz.selectSauce();
            piz.selectToppings();

            System.out.println("Do you like to have Drinks? Y/N");
            String c = sc.next();
            if (c.equalsIgnoreCase("Y")) {
                piz.selectDrink();
            }

            System.out.println("Do you like to have Desserts? Y/N");
            String ch = sc.next();
            if (ch.equalsIgnoreCase("Y")) {
                piz.selectDessert();
            }
            double totalBill = piz.calculateBill();
            if (piz.drinkAdded && piz.dessertAdded) {
                System.out.printf("A 5%% discount has been applied! Final Amount to be Paid: Rs. %.2f%n", totalBill);
            } else {
                System.out.printf("No discount applied. Final Amount to be Paid: Rs. %.2f%n", totalBill);
            }
        }
    }
