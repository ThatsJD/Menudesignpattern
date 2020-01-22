package terminal;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	List<MenuOption> options= new ArrayList<MenuOption>();
	private String title;
	public Menu(String title) {
		
		this.title=title;
	}
	
	private String MenuName;
	
	public MenuOption addMenuOption(MenuOption option) {
		options.add(option);
		return option;
	}
	public Menu optionSelect(int index) {
		MenuOption opt= options.get(index-1);
		opt.performAction();
		return opt.getSubmenu();
	}
	
	public String toString() {
		StringBuilder strb = new StringBuilder();
		strb.append(this.title+ " \n ");
		int index=1;
		for( MenuOption option : options ) {
			strb.append(String.format( "%d-  %-10s \n ",index++, option.getOptionName()));
		}
		return strb.toString();
	}
	
}
