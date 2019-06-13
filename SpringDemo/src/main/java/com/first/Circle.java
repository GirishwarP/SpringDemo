package com.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape{

	private Point center;
	
	public Point getCenter() {
		return center;
	}

	@Required //center point should be compulsory initiated (to avoid NullPointerException)
	@Autowired 
	public void setCenter(@Qualifier("centerPoint")Point center) {
		this.center = center;
	}

	public void draw() {
		System.out.println("Circle drawn with origin : (" + center.getxPoint() + "," + center.getyPoint() + ")");		
	}

	public void pointListPrint() {
		System.out.println("just overriden");
	}
}
