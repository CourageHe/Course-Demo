package com.couragehe.test4;

import java.util.Locale.Category;

/**
 * 1.编写一个类，描述汽车，其中用字符型描述车的牌号，用浮点型描述车的价格。
 * 编写一个测试类，其中有一个修改价格的方法，对汽车对象进行操作，
 * 根据折扣数修改汽车的价格，最后在main（）方法中输出修改后的汽车信息。
 * @author 52423
 *
 */

public class TestCar{
	public static void updatePrice(Car car,float discount) {
		float price = car.getPrice();
		car.setPrice(price*discount);
	}
	public static void main(String[]args) {
		Car car = new Car("666666",99999.199999f);
		TestCar.updatePrice(car, 0.75f);
		System.out.println(car);
	}
}
class Car {
	private String carNumber;
	private float price;
	
	public Car(String carNumber, Float price) {
		super();
		this.carNumber = carNumber;
		this.price = price;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [carNumber=" + carNumber + ", price=" + price + "]";
	}

}
