package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Account[] accountArray = new Account[10];
        accountArray = makeAccountArray(accountArray);

        int id = inputId();
        displayMenu(id, accountArray);
    }

    public static Account[] makeAccountArray(Account[] accountArray){
        for(int i = 0; i < accountArray.length; i++){
            accountArray[i] = new Account(i, 100);
        }
        return accountArray;
    }

    public static boolean checkId(int id, Account[] accountArray){
        for(int i = 0; i < accountArray.length; i++){
            if(accountArray[i].getId() == id){
                return true;
            }
        }
        return false;
    }

    public static double checkBalance(int id, Account[] accountArray){
        return accountArray[id].getBalance();
    }

    public static double withDraw(int id, Account[] accountArray, double money){
        return Account.withDraw(money, accountArray[id]);

    }

    public static double deposit(int id, Account[] accountArray, double money){
        Account.deposit(money, accountArray[id]);
        return money;
    }

    public static int inputId(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an id: ");
        int id = scanner.nextInt();
        return id;
    }

    public static void displayMenu(int id, Account[] accountArray){
        Scanner scanner = new Scanner(System.in);
        if(checkId(id, accountArray)){
            System.out.println("Main menu");
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4: exit");

            System.out.print("Enter a choice: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1: {
                    double balance = checkBalance(id, accountArray);
                    if (balance != 0) {
                        System.out.println("You have " + balance + " in your account");
                    } else {
                        System.out.println("Your account is empty");
                    }
                    displayMenu(id, accountArray);
                    break;
                }

                case 2:{
                    System.out.print("Input the money you want to withdraw: ");
                    double money = scanner.nextDouble();
                    double withDrawMoney = withDraw(id, accountArray, money);
                    if(withDrawMoney > 0){
                        System.out.println("You just withdraw: "+withDrawMoney);
                        System.out.println("You have: "+accountArray[id].getBalance()+" in your account");
                    }else{
                        System.out.println("Invalid money to withdraw");
                    }
                    displayMenu(id, accountArray);
                    break;
                }

                case 3: {
                    System.out.print("Input the money you want to deposit: ");
                    double moneyDeposit = scanner.nextDouble();
                    double depositMoney = deposit(id, accountArray, moneyDeposit);
                    if (depositMoney > 0) {
                        System.out.println("You just deposit: " + depositMoney);
                        System.out.println("You have " + accountArray[id].getBalance() + " in your account");
                    } else {
                        System.out.println("Invalid money to deposit");
                    }
                    displayMenu(id, accountArray);
                    break;
                }

                case 4:{
                    id = inputId();
                    displayMenu(id, accountArray);
                    break;
                }

                default:
                    System.out.println("Invalid choice");
                    displayMenu(id, accountArray);
            }
        }else{
            System.out.println("Wrong id account!!!");
            id = inputId();
            displayMenu(id, accountArray);
        }
    }
}
