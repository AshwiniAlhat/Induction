package com.ideas.model;

public class Item {

	private final String name;
	private final int quantity;

	public Item(String itemName, int quantity) {
		this.name = itemName;
		this.quantity = quantity;
		
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other == null) {
			return false;
		} 
		
		if(this.getClass() != other.getClass()) {
			return false;
		} 
		
		Item that = (Item) other;
		
		if (this == that){
			return true;
		}
		
		return this.name.equals(that.name) && this.quantity == that.quantity;
	}
	
	
	 @Override
	    public int hashCode() {
	        int hash = 1;
	        hash = hash * 17 + name.hashCode();
	        hash = hash * 31 + quantity;
	        return hash;
	    }

}
