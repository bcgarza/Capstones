package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY,PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};


	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	private Calculator calculator = new Calculator();
	private Currency currency = new Currency();
	Log log = new Log();

	public void run() {
		File actionLog = new File("actionLog.txt");
		InventoryReader.buildInventory();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			//Display list
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				InventoryReader.displayInventory(InventoryReader.getInventoryItemMap());

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				System.out.println();
				System.out.println("Current Money Provided: $"+ calculator.getCurrentMoneyProvided());

				while (true) {//IF THEY CHOOSE TO FEED MONEY THEY CAN CONTINUE TO ADD MONEY UNTIL THEY HIT X AND EXIT THE ENTER MONEY AND GO BACK TO PURCHASE MENU.
					String purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						System.out.println("Current Money Provided: $" + calculator.getCurrentMoneyProvided());
						System.out.println("Insert Money or Press x to return Purchase Menu");
						Scanner scanner = new Scanner(System.in);
						String moneyInput = scanner.nextLine();
						while (!moneyInput.toLowerCase().equals("x")) {
							BigDecimal moneyInputDouble = new BigDecimal(moneyInput);
							BigDecimal currentMoney = calculator.getCurrentMoneyProvided();
							calculator.setCurrentMoneyProvided(calculator.getCurrentMoneyProvided(), moneyInputDouble, false);
							BigDecimal updatedMoney = calculator.getCurrentMoneyProvided();
							System.out.println("Current Money Provided: $" + calculator.getCurrentMoneyProvided());
							log.writeToFile(actionLog, updatedMoney, currentMoney, "FEED ME:");
							System.out.println("Insert Money or Press x to return Purchase Menu");
							moneyInput = scanner.nextLine();
						}
						System.out.println();
						System.out.println("Current Money Provided: $" + calculator.getCurrentMoneyProvided());
					}
					if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {//IF THEY CHOOSE SELECT OPTION THEN THEY ARE PRESENTED WITH THE LIST OF OPTIONS AND AVAILABLE ITEMS AND PRICES.
						InventoryReader.displayInventory(InventoryReader.getInventoryItemMap());
						System.out.println();
						System.out.println("Current Money Provided: $" + calculator.getCurrentMoneyProvided());
						System.out.println();
						System.out.println("What would you like to buy?");
						Scanner scanner = new Scanner(System.in);
						String userSelection = scanner.nextLine();
						try {//WHATEVER THEY TYPE IN IS CALLED FROM THE POPULATED MAP WITH THE USER SELECTION 'KEY' AND THE MONEY IS SUBTRACTED FROM THE INPUT AMOUT. A PURCHASE MESSAGE IS PRINTED DEPENDING ON THE TYPE OF ITEM.
							if (InventoryReader.getInventoryItemMap().get(userSelection).getPrice().compareTo(calculator.getCurrentMoneyProvided()) < 0) {
								InventoryItem.purchaseItem(InventoryReader.getInventoryItemMap(), calculator.getCurrentMoneyProvided(), userSelection);
								BigDecimal currentMoney = calculator.getCurrentMoneyProvided();
								calculator.setCurrentMoneyProvided(calculator.getCurrentMoneyProvided(), InventoryReader.getInventoryItemMap().get(userSelection).getPrice(), true);
								BigDecimal updatedMoney = calculator.getCurrentMoneyProvided();
								log.writeToFile(actionLog, updatedMoney, currentMoney, InventoryReader.getInventoryItemMap().get(userSelection).getName() + " " + userSelection);
							} else {
								System.out.println();
								System.out.println("Not enough money, please insert more");
							}
						} catch (NullPointerException e) {
							System.out.println("Please select a valid option");
						}
						System.out.println();
						System.out.println("Current Money Provided: $" + calculator.getCurrentMoneyProvided());
					}
					if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {//EXITS THE PURCHASE LOOP AND RETURNS THEIR REMAINING CHANGE IN THE FORM OF COINS
						BigDecimal currentMoney = calculator.getCurrentMoneyProvided();
						currency.returnChange(calculator.getCurrentMoneyProvided());
						calculator.setCurrentMoneyProvided(currentMoney, currentMoney, true);
						BigDecimal updatedMoney = calculator.getCurrentMoneyProvided();
						log.writeToFile(actionLog, updatedMoney, currentMoney, "GIVE CHANGE:");
						break;
					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
