package com.first;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

	public static void main(String[] args) {
		
		//Triangle triangle = new Triangle(); without using spring 
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("G:\Girish_Workspace\SpringDemo\src\main\resources\spring.xml"));
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); //to close the application context
		//context.registerShutdownHook();	
		//Triangle triangle = (Triangle) context.getBean("triangle");
		Shape shape1 = (Shape) context.getBean("triangle-alias"); //Alias name is used
		shape1.draw();
		shape1.pointListPrint();
		
		Shape shape2 = (Shape) context.getBean("circle");
		shape2.draw();
		shape2.pointListPrint(); 
	}
}
