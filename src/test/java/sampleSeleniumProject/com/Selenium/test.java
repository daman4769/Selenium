package sampleSeleniumProject.com.Selenium;
class parent {
	parent(String s){
		System.out.println("I am parent" +  s );
	}
}
class child extends parent{
	child(){
		super("I am child");
	
	}
}
public class test {
public static void main(String Args[]) {
	try{
		int a = 20;
		int b = 0;
		System.exit(1);
		int c = a/b;
	
		System.out.println("calling this");	
	}catch(ArithmeticException e) {
		System.out.println("Inside catch");
	}
	finally {
		System.out.println("Inside finall");
	}
	System.out.println("Outside");
}}
