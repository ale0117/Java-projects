package labs.lab4;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class RobotTest {

	@Test
    public void testConstructor() {
		Robot robot = new Robot();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("N", robot.getDirection());
    }

	@Test
    public void testTurnLeft() {
		Robot robot = new Robot();
		robot.turnLeft();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("W", robot.getDirection());
		robot.turnLeft();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("S", robot.getDirection());
		robot.turnLeft();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("E", robot.getDirection());
		robot.turnLeft();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("N", robot.getDirection());
    }
	
	@Test
    public void testTurnRight() {
		Robot robot = new Robot();
		robot.turnRight();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("E", robot.getDirection());
		robot.turnRight();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("S", robot.getDirection());
		robot.turnRight(); 
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("W", robot.getDirection());
		robot.turnRight(); 
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("N", robot.getDirection());
    }
	
	@Test
    public void testMove() {
		Robot robot = new Robot();
		
		assertTrue(robot.move()); 
		assertEquals(true, robot.getLocation().equals(new Point(0, 1))); 
		assertEquals("N", robot.getDirection());
		
		robot.turnLeft(); 
		assertTrue(robot.move());  
		assertTrue(robot.move()); 
		assertEquals(true, robot.getLocation().equals(new Point(-2, 1))); 
		assertEquals("W", robot.getDirection());
		
		robot.turnRight();
		robot.turnRight();
		assertTrue(robot.move());  
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertEquals(true, robot.getLocation().equals(new Point(1, 1))); 
		assertEquals("E", robot.getDirection());
		
		robot.turnLeft();
		robot.turnLeft(); 
		robot.turnLeft(); 
		assertTrue(robot.move());  
		assertTrue(robot.move()); 
		assertTrue(robot.move());  
		assertTrue(robot.move()); 
		assertEquals(true, robot.getLocation().equals(new Point(1, -3))); 
		assertEquals("S", robot.getDirection());
		
		assertTrue(robot.move());  
		assertTrue(robot.move()); 
		assertFalse(robot.move()); 
		assertEquals(true, robot.getLocation().equals(new Point(1, -6))); 
		assertEquals("S", robot.getDirection());
    }
}
