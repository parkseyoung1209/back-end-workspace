package com.kh._abstract.step2;

public class BulgogiPizza extends Pizza{


	public BulgogiPizza(int price, String brand) {
		super(price, brand);
	}
	
	public void info() {
		System.out.printf("%s의 불고기 피자 가격은 %d원\n", this.brand, this.price );
	}
	public void topping() {
		System.out.println("토핑은 불고기를 포함시킨다");
	}
}
