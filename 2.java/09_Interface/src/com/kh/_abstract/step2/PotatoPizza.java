package com.kh._abstract.step2;

public class PotatoPizza extends Pizza{

	public PotatoPizza(int price, String brand) {
		super(price, brand);
	}
	public void info() {
		System.out.printf("%s의 포테이토 피자 가격은 %d원\n", this.brand, this.price );
	}
	public void topping() {
		System.out.println("토핑은 포테이토를 포함시킨다");
	}
}
