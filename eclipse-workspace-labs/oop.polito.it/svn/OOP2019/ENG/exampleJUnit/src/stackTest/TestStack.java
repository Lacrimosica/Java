/*-************************************************************************-*\
*			*  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)      		*
*        	*  (!) May-2019, Aleksa Damljanovic <aleksa.damljanovic@polito.it>  *
*      		*                                                              		*
*      		*  Copying and distributing this file, either with or without  		*
*     		*  modification, are permitted in any medium without royalty, 		*
*           *  provided that this 10-line comment is preserved.            		*
*   	    *                                                              		*
*           *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  		*
\*-************************************************************************-*/

package stackTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exampeJUnit.Stack;

public class TestStack {

	private Stack aStack;
	
	//Called always before @Test method
	@Before
	public void setUp() throws Exception {
		aStack = new Stack();
	}

	//Called always before @Test method 
	@After
	public void tearDown() throws Exception {
	}

	// Unexpected exception generated Failure 
	@Test
	public void testPopPushExceptions() {
		aStack.push(4);
		aStack.push(-2);
		aStack.push(7);
		aStack.push(3);
		

		try {
			aStack.pop();
			aStack.pop();
			aStack.pop();
			aStack.pop();
			assertTrue(true);
		} catch (Exception e) {
			fail("Shouldn't throw an exception");
		}
		 
	}
	
	// Unexpected exception generates Error
	@Test
	public void testPopPushExceptionsThrow() throws Exception {
		aStack.push(4);
		aStack.push(-2);
		aStack.push(7);
		aStack.push(3);
		
		aStack.pop();
		aStack.pop();
		aStack.pop();
		aStack.pop();
		assertTrue(true);

	}
	
	
	@Test
	public void test() {
		assertTrue(aStack.isEmpty());
		
		
		//Expected exception, trying to pop from empty Stack
		try {
			aStack.pop();
			fail("Stack should be empty");
			
		} catch (Exception e) {
			assertTrue(true);
		}
		
		aStack.push(4);
		
		
		//Equivalent
		assertTrue(!aStack.isEmpty());
		assertFalse(aStack.isEmpty());
		
		aStack.push(2);
		aStack.push(-7);
		

	}

}
