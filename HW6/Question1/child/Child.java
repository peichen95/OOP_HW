package child;

import parent.Parent;

public class Child extends Parent{
	
	public void calculateSum(){
		System.out.printf("calculate the sum of protected variables from parent class of different package: %d + %d = %d",
		                   super.x, super.y, super.x+super.y);
	}

	public static void main(String[] args){
		Child child = new Child();
		child.calculateSum();
	}
}