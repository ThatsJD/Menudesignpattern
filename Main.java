package terminal;

import java.util.Scanner;

public class Main {

	public static ProductDatabase db = new ProductDatabase();

	public static void main(String arg[]) {
		Menu root = setMenus();
		System.out.println(root);
		Scanner scanner = new Scanner(System.in);
		while (true) {
			root = root.optionSelect(scanner.nextInt());
			System.out.println(root);
		}
	}

	public static Menu setMenus() {
		Menu mainMenu = new Menu("Main Menu");
		Menu itemMenu = new Menu("Items Menu");
		Menu report = new Menu("Items Menu");

		MenuOption opt = new MenuOption("Manage Items", null, null);
		opt.setSubmenu(itemMenu);
		mainMenu.addMenuOption(opt);

		mainMenu.addMenuOption(new MenuOption("Print Reports", null, mainMenu)).setCommand(new Command() {
			@Override
			public void execute() {
				printReport();

			}
		});
		;
		mainMenu.addMenuOption(new MenuOption("Exit", null, mainMenu)).setCommand(new Command() {
			@Override
			public void execute() {
				System.exit(1);

			}
		});
		;

		itemMenu.addMenuOption(new MenuOption("Add New Item", null, itemMenu)).setCommand(new Command() {
			@Override
			public void execute() {
				addItems();

			}
		});
		;
		;
		itemMenu.addMenuOption(new MenuOption("Find Items", null, itemMenu)).setCommand(new Command() {
			@Override
			public void execute() {
				findItems();

			}
		});
		;
		;
		itemMenu.addMenuOption(new MenuOption("Modify Existing Items", null, itemMenu)).setCommand(new Command() {
			@Override
			public void execute() {
				changeItems();
				;

			}
		});
		;
		;
		itemMenu.addMenuOption(new MenuOption("Remove Items", null, itemMenu)).setCommand(new Command() {
			@Override
			public void execute() {
				removeItem();

			}
		});
		opt = new MenuOption("Back to Main Menu", null, itemMenu);
		opt.setSubmenu(mainMenu);
		itemMenu.addMenuOption(opt);

		opt = new MenuOption("Back to Main Menu", null, report);
		opt.setSubmenu(mainMenu);
		report.addMenuOption(opt);

		return mainMenu;
	}

	protected static void addItems() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product name: ");
		String name = scanner.nextLine();
		System.out.println("Enter Product price: ");
		double price = scanner.nextDouble();
		db.insertData(name, price);

	}

	protected static void findItems() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product name: ");
		String name = scanner.next();
		System.out.println(db.searchByProductName(name));
	}

	protected static void changeItems() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product name: ");
		String name = scanner.next();
		System.out.println("Enter new Product price: ");
		double price = scanner.nextDouble();
		if(db.modifyData(db.getIndex(name), name, price))
			System.out.println("Item is Changed successfully...");
		else 
			System.out.println("Something went wrong! please check your inputs");
	}

	protected static void removeItem() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product name: ");
		String name = scanner.next();
		if(db.removeData(db.getIndex(name)))
			System.out.println("Item is removed successfully...");
		else 
			System.out.println("Something went wrong! please check your inputs");

	}

	protected static void printReport() {

		System.out.println(db);
	}

}
