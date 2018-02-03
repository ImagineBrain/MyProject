package com.xzx.test;

public class Student extends People {
	private int grade;

	public Student(String name, int age) {
		super(name, age);
	}

	public Student(String name, int age, int grade) {
		super(name, age);
		this.grade = grade;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	private void learn(String course) {
		System.out.println(super.name + " learn " + course);
	}
}
