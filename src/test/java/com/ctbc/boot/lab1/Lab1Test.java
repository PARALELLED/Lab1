package com.ctbc.boot.lab1;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions; // 需使用junit.jupiter
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.ctbc.boot.lab1.bean.Employee;

public class Lab1Test {
	// 理論上要全對
	
	// All
	//--------------------------------------------------
	@BeforeAll
	// org.junit.platform.commons.JUnitException: @BeforeAll method 'public void com.ctbc.boot.lab1.Lab1Test.oneTermSetup()' must be static unless the test class is annotated with @TestInstance(Lifecycle.PER_CLASS).
	public static void oneTermSetup() {
		System.out.println("一次性的啟動");
	}
	
	@AfterAll
	public static void finalCleanUp() {
		System.out.println("\n一次性的清除");
	}
	
	
	
	// Each
	//--------------------------------------------------
	@BeforeEach
	public void  prepare() {
		System.out.println("\n開始準備");
	}
	
	@AfterEach
	public void storeAndClean() {
		System.out.println("清除並重製");
	}
	
	
	
	//--------------------------------------------------
	@Test
	public void compareObjectIdentical() {
		/*
		 * assertTure
		 * assertFalse
		 * assertEquals
		 * assertArrayEquals //
		 * assertNotEquals
		 * assertSame // 
		 * assertTimeOut
		 */
		
		//Assertions.fail("失敗"); 
		System.out.println("compare object Identical");
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = e1;
		// e1 <--> e3, e2 <--> e3
		Assertions.assertSame(e1,e3);
	}

	@Test
	public void compareObjectEquality() {
		System.out.println("compare object equality");
		Employee e1 = new Employee("AB1234","Brain",75);
		Employee e2 = new Employee("AB1234","Brain",75);
		Assertions.assertEquals(e1, e2); // 因為加了@Data，@Data已實作EqualsAndHashCode，所以會相等
		

	}

	@Test
	@Disabled("will be available in next release")
	public void compareObjectSomething() {
		System.out.println("compare object certain attribute");

	}
}
