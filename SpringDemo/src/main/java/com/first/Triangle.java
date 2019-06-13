package com.first;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape, ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {

	private String type;
	private int height;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private List<Point> pointList;  //use of collection
	private ApplicationContext context = null;
	
	
	public List<Point> getPointList() {
		return pointList;
	}
	public void setPointList(List<Point> pointList) {
		this.pointList = pointList;
	}
	public Point getPointA() {
		return pointA;
	}
	
	@Required 
	public void setPointA(@Qualifier("centerPoint")Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	//constructor
	public Triangle(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	//method
	public void draw() {
		System.out.println(type + " Triangle Drawn of height " + height);
		System.out.println("PointOO : (" + pointA.getxPoint() + "," + pointA.getyPoint() +")");
		System.out.println("PointOX : (" + pointB.getxPoint() + "," + pointB.getyPoint() +")");
		System.out.println("PointXY : (" + pointC.getxPoint() + "," + pointC.getyPoint() +")");
	}
	
	public void pointListPrint() {
		for(Point point : pointList) {
			System.out.println("Point : (" + point.getxPoint() + "," + point.getyPoint() + ")");
		}
	}
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
	public void setBeanName(String name) {
		System.out.println("Bean name is : " + name);
	}
	
	//Life cycle call back method : invoked before initializing bean factory 
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean init method called...");		
	}
	//Life cycle call back method : invoked before initializing bean factory
	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy method called...");		
	}
	
	//Customized init method
	public void myInit() {
		System.out.println("myInit method called...");
	}
	//customized destroy method
	public void myDestroy() {
		System.out.println("myDestroy method called...");
	}
}
