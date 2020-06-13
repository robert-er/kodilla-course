package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests of class " + ShapeCollector.class);
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    public Circle createTestCircle() {
        double r = 4;
        return new Circle(r);
    }

    @Test
    public void testAddFigure() {
        //Given
        Circle testFigure = createTestCircle();
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        shapeCollector.addFigure(testFigure);
        //Then
        Assert.assertTrue(shapeCollector.showFigures().contains(testFigure));
    }

    @Test
    public void testGetFigure() {
        //Given
        Circle testFigure = createTestCircle();
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        shapeCollector.addFigure(testFigure);
        //Then
        Assert.assertEquals(testFigure, shapeCollector.getFigure(0));
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle testFigure = createTestCircle();
        shapeCollector.addFigure(testFigure);
        //When
        shapeCollector.removeFigure(testFigure);
        //Then
        Assert.assertFalse(shapeCollector.showFigures().contains(testFigure));
    }

    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle testFigure = createTestCircle();
        //When
        shapeCollector.addFigure(testFigure);
        //Then
        Assert.assertNotNull(shapeCollector.showFigures());
    }

    @Test
    public void testGetShapeName() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle testFigure = createTestCircle();
        //When
        shapeCollector.addFigure(testFigure);
        //Then
        Assert.assertEquals("com.kodilla.testing.shape.Circle",shapeCollector.getFigure(0)
                .getShapeName()
                .substring(0,shapeCollector.getFigure(0).getShapeName().length()-1));
    }

    @Test
    public void testGetField() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle testFigure = createTestCircle();
        //When
        shapeCollector.addFigure(testFigure);
        //Then
        Assert.assertEquals(50.24, shapeCollector.getFigure(0).getField(), 0.0);
    }
}
