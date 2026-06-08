/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.smartledger;

/**
 *
 * @author 劉芊鈺
 */
import java.util.*;

public class SmartLedger {

    // ===== Item 類別 =====
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
            return date + " " + type + " " + amount + " " + note;
        }
    }

    // ===== Ledger 類別 =====
    static class Ledger {
        private ArrayList<Item> items = new ArrayList<>();

        public void addItem(Item item) {
            items.add(item);
        }

        public void showAll() {
            if (items.size() == 0) {
                System.out.println("沒有資料");
                return;
            }

            System.out.println("==== 所有紀錄 ====");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }

        public void statistics() {
            int income = 0;
            int expense = 0;

            for (Item item : items) {
                if (item.getType().equals("收入")) {
                    income += item.getAmount();
                } else {
                    expense += item.getAmount();
                }
            }

            System.out.println("==== 統計結果 ====");
            System.out.println("總收入：" + income);
            System.out.println("總支出：" + expense);
            System.out.println("結餘：" + (income - expense));
        }

        public void sortByAmount() {
            Collections.sort(items, new Comparator<Item>() {
                public int compare(Item a, Item b) {
                    return b.getAmount() - a.getAmount();
                }
            });

            System.out.println("==== 金額排序（高→低）====");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }

        public void search(String keyword) {
            System.out.println("==== 搜尋結果 ====");
            int count = 0;

            for (Item item : items) {
                if (item.getNote().contains(keyword)) {
                    System.out.println((++count) + ". " + item);
                }
            }

            if (count == 0) {
                System.out.println("找不到相關資料");
            }
        }
    }

    // ===== 主程式 =====
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ledger ledger = new Ledger();

        while (true) {
            System.out.println("============================");
            System.out.println("   SmartLedger 記帳系統");
            System.out.println("============================");
            System.out.println("1. 新增記帳紀錄");
            System.out.println("2. 查看所有紀錄");
            System.out.println("3. 收入/支出統計");
            System.out.println("4. 金額排序（高→低）");
            System.out.println("5. 搜尋紀錄（關鍵字）");
            System.out.println("0. 離開");
            System.out.println("============================");
            System.out.print("請輸入選項：");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("請輸入日期（YYYY/MM/DD）：");
                String date = sc.nextLine();

                System.out.print("請輸入類型（收入/支出）：");
                String type = sc.nextLine();

                System.out.print("請輸入金額：");
                int amount = sc.nextInt();
                sc.nextLine();

                System.out.print("請輸入備註：");
                String note = sc.nextLine();

                ledger.addItem(new Item(date, type, amount, note));
                System.out.println("新增成功！");

            } else if (choice == 2) {
                ledger.showAll();

            } else if (choice == 3) {
                ledger.statistics();

            } else if (choice == 4) {
                ledger.sortByAmount();

            } else if (choice == 5) {
                System.out.print("請輸入關鍵字：");
                String keyword = sc.nextLine();
                ledger.search(keyword);

            } else if (choice == 0) {
                System.out.println("感謝使用 SmartLedger！");
                break;

            } else {
                System.out.println("無效選項！");
            }

            System.out.println();
        }

        sc.close();
    }
}