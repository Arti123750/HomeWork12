package com.abc.customarryalist;

public class TestClass {
		int id;
		String name;
		public TestClass(int id, String name) 
		{
			super();
			this.id = id;
			this.name = name;}
		
	public static void main(String[] args) {
		
		CustomArraylist<Student>list=new CustomArraylist<>();
		
		list.addElement(new Student(1,"Arti"));
		list.addElement(new Student(2,"Pooja"));
		list.addElement(new Student(3, "Namrata"));
		list.addElement(new Student(4, "Arya"));
		
		System.out.println(list);
		
		System.out.println(list.get(1));
		list.remove(3);
		System.out.println(list);
		
		CustomArraylist<TestClass>list1=new CustomArraylist<>();
		list1.addElement(new TestClass(10, "abc"));

		
		
		
	}

}