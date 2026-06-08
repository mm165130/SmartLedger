import java.util.*;

public class SmartLedger {

    // ===== Item Class =====
    static class Item {
        private String date;
        private String type;
        private int amount;
        private String note;

        public Item(String date, String type, int amount, String note) {
            this.date = date;
            this.type = type;
            this.amount = amount;
            this.note = note;
        }

        public String getType() {
            return type;
        }

        public int getAmount() {
            return amount;
        }

        public String getNote() {
            return note;
        }

        @Override
        public String toString() {
            return date + " [" + type + "] $" + amount + " - " + note;
        }
    }

    // ===== Ledger Class =====
    static class Ledger {
        private ArrayList<Item> items = new ArrayList<>();

        public void addItem(Item item) {
            items.add(item);
        }

        public void showAll() {
            if (items.size() == 0) {
                System.out.println("No records found.");
                return;
            }

            System.out.println("==== All Records ====");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }

        public void statistics() {
            int income = 0;
            int expense = 0;

            for (Item item : items) {
                if (item.getType().equalsIgnoreCase("Income")) {
                    income += item.getAmount();
                } else {
                    expense += item.getAmount();
                }
            }

            System.out.println("==== Statistics ====");
            System.out.println("Total Income  : " + income);
            System.out.println("Total Expense : " + expense);
            System.out.println("Balance       : " + (income - expense));
        }

        public void sortByAmount() {
            Collections.sort(items, new Comparator<Item>() {
                public int compare(Item a, Item b) {
                    return Integer.compare(b.getAmount(), a.getAmount());
                }
            });

            System.out.println("==== Sorted by Amount (High -> Low) ====");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }

        public void search(String keyword) {
            System.out.println("==== Search Results ====");
            int count = 0;

            for (Item item : items) {
                if (item.getNote().toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println((++count) + ". " + item);
                }
            }

            if (count == 0) {
                System.out.println("No matching records found.");
            }
        }
    }

    // ===== Main Program =====
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ledger ledger = new Ledger();

        while (true) {
            System.out.println("============================");
            System.out.println("    SmartLedger System");
            System.out.println("============================");
            System.out.println("1. Add a new record");
            System.out.println("2. View all records");
            System.out.println("3. Income/Expense statistics");
            System.out.println("4. Sort by amount (High -> Low)");
            System.out.println("5. Search records by keyword");
            System.out.println("0. Exit");
            System.out.println("============================");
            System.out.print("Please enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear the buffer

            if (choice == 1) {
                System.out.print("Enter date (YYYY/MM/DD): ");
                String date = sc.nextLine();

                System.out.print("Enter type (Income/Expense): ");
                String type = sc.nextLine();

                System.out.print("Enter amount: ");
                int amount = sc.nextInt();
                sc.nextLine(); // Clear the buffer

                System.out.print("Enter note: ");
                String note = sc.nextLine();

                ledger.addItem(new Item(date, type, amount, note));
                System.out.println("Successfully added!");

            } else if (choice == 2) {
                ledger.showAll();

            } else if (choice == 3) {
                ledger.statistics();

            } else if (choice == 4) {
                ledger.sortByAmount();

            } else if (choice == 5) {
                System.out.print("Enter keyword: ");
                String keyword = sc.nextLine();
                ledger.search(keyword);

            } else if (choice == 0) {
                System.out.println("Thank you for using SmartLedger! Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice! Please try again.");
            }

            System.out.println();
        }

        sc.close();
    }
}
