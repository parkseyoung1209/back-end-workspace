package com.kh._abstract.step2;

public class PineApplePizza extends Pizza{

	public PineApplePizza(int price, String brand) {
		super(price, brand);
	}
	public void info() {
		System.out.printf("%s의 파인애플 피자 가격은 %d원\n", this.brand, this.price );
	}
	public void topping() {
		System.out.println("토핑은 파인애플을 포함시킨다");
	}
}
