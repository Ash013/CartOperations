package main;

public class ProductException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg="invalid";

	public ProductException(String msg) {
		
		System.out.println(msg);
	}
	
}
