package com.coderscampus.assignement10.DTO;

import java.util.List;

public class Thursday {
	private List <Meals> meals;
	private Nutrients nutrients;
	public List <Meals> getMeals(){
		return meals;
	}
	public Nutrients getNutrients() {
		return nutrients;
	}
	public void setNutrients(Nutrients nutrients) {
		this.nutrients = nutrients;
	}
	public void setMeals(List<Meals> meals) {
		this.meals = meals;
	}

}
