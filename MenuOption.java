package terminal;

public class MenuOption {
	private String optionname;
	private Command command;
	private Menu submenu;
	public MenuOption(String optionName,Command command,Menu menu) {
		this.optionname=optionName;
		this.command=command;
		this.submenu=menu;
	}
	
	public void performAction() {
		try {
		command.execute();
		}catch(NullPointerException e) {
			
		}
	}
	
	public String getOptionName() {
		return optionname;
	}
	public Command getCommand() {
		return command;
	}

	public String getOptionname() {
		return optionname;
	}

	public void setOptionname(String optionname) {
		this.optionname = optionname;
	}

	public Menu getSubmenu() {
		return submenu;
	}

	public void setSubmenu(Menu submenu) {
		this.submenu = submenu;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
}
