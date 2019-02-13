package main;

public interface CartOperations {
	public float getInvoiceAmount();
	public float addToCart(Product p);
	public void removeFromCart(Product p) throws ProductException;
}
