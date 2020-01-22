package terminal;

public class Product {

	private String Name;
	private double price;
	
	public Product(String description, double price) {
		this.Name=description;
		this.price=price;
	}
	
	public Product(Product product) {
		this.Name=product.Name;
		this.price=product.price;
	}

	public String getDescription() {
		return Name;
	}

	public void setDescription(String description) {
		this.Name = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return String.format("%s %10f",this.getDescription(), this.getPrice());
		
	}
}
