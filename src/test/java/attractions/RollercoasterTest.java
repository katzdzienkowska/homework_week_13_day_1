package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;

    @Before
    public void setUp() {

        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(19, 210.00, 25.25);
        visitor2 = new Visitor(10, 110.00, 55.25);
        visitor3 = new Visitor(9, 150.00, 55.25);
        visitor4 = new Visitor(14, 140.00, 55.25);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void isAllowedToTheRollercoaster() {
        assertEquals(true, rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void isNotAllowedToTheRollercoasterUnderHeightAge() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void isNotAllowedToTheRollercoasterUnderAge() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor3));
    }

    @Test
    public void isNotAllowedToTheRollercoasterUnderHeight() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor4));
    }

    @Test
    public void canReturnDefaultPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.0);
    }

    @Test
    public void canDoubleChargeIfHeightOver200() {
        assertEquals(16.80, rollerCoaster.priceFor(visitor1), 0.0);
    }

    @Test
    public void canChargeDefaultPriceIfHeightUnder200() {
        assertEquals(8.40, rollerCoaster.priceFor(visitor3), 0.0);
    }
}
