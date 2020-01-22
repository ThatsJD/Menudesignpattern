package terminal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductDatabase {

	private List<Product> Database = new ArrayList<Product>();
	
	public void insertData(String productName,double price) {
		Product product=new Product(productName,price);
		Database.add(product);
	}
	public boolean removeData(int index) {
		try {
		Database.remove(index);
		}catch(IndexOutOfBoundsException e){
			return false;
		}
		return true;
	}
	public boolean modifyData(int index,String productName, double price) {
		
			try {
			Product product=Database.get(index);
			product.setDescription(productName);
			product.setPrice(price);
			return true;
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public int getIndex(String productName) {
		int index=0;
		for(Product product : Database) {
			if(product.getDescription()==productName)
				return index;
		index++;
		}
		return -1;
	}
	public Product searchByProductName (String productName){
		for(Product item : Database) {
			if(item.getDescription()==productName)
				return new Product(item);
			
		}
		return null;
	}
	public Product searchByPrice (double price){
		for(Product item : Database) {
			if(item.getPrice()==price)
				return new Product(item);
			
		}
		return null;
	}
	@Override
	public String toString() {
		StringBuilder strbuilder=new StringBuilder();;
		for(Product item : Database) {
			strbuilder.append(String.format("%s %10f",item.getDescription(), item.getPrice()));
		}
		return strbuilder.toString();
	}
	
}
