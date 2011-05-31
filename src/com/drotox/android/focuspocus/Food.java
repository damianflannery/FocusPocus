package com.drotox.android.focuspocus;


public class Food {
	
	private String name;
	private int cals;
	private int servings;
	
	public Food() {
	}
	
	public Food(String name, int cals, int servings) {
		this.name = name;
		this.cals = cals;
		this.servings = servings;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param cals the cals to set
	 */
	public void setCals(int cals) {
		this.cals = cals;
	}
	/**
	 * @return the cals
	 */
	public int getCals() {
		return cals;
	}
	/**
	 * @param servings the servings to set
	 */
	public void setServings(int servings) {
		this.servings = servings;
	}
	/**
	 * @return the servings
	 */
	public int getServings() {
		return servings;
	}
	
	
}