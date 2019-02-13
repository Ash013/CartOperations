package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart implements CartOperations{
	private float tax_percentage;
	private float InvoiceAmount;
	List<Product> items=new ArrayList<>();
	public ShoppingCart(float tax_percentage) {
		this.tax_percentage=tax_percentage;
	}
	
	@Override
	public float getInvoiceAmount() {
		return InvoiceAmount;
	}

	@Override
	public float addToCart(Product p) {
		items.add(p);
		float tax=((p.price)*(p.quantity)*(tax_percentage/100));
		float cost=(p.price*p.quantity)+tax;
		InvoiceAmount=InvoiceAmount+cost;
		return InvoiceAmount;
	}

	@Override
	public void removeFromCart(Product p) throws ProductException {
		if(items.contains(p)) {
			float cost=(p.price*p.quantity)+((p.price)*(p.quantity)*(tax_percentage/100));
			InvoiceAmount=InvoiceAmount-cost;
			items.remove(p);
		}
		else throw new ProductException("The selected product to remove "+p.name+" is not there in your cart ");
	}

	@Override
	public String toString() {
		String str="";
		Iterator<Product> itr=items.iterator();
		while(itr.hasNext()) {
			str=str+(itr.next().name);
		}
		return str;
	}
	
	public static void main(String[] args) throws ProductException{
		Product p1=new Product("Keyboard",400,2);
		Product p2=new Product("Pendrive",300,2);
		Product p3=new Product("Camera",3000,1);

		CartOperations cart=new ShoppingCart(10);
		//cart.removeFromCart(p3);
		cart.addToCart(p1);
		cart.addToCart(p2);
		cart.addToCart(p3);
		cart.removeFromCart(p1);
		System.out.println(cart.getInvoiceAmount());
		System.out.println(cart);
	}
	
	
}
