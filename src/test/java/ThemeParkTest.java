import attractions.Dodgems;
import attractions.Playground;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;
import attractions.RollerCoaster;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    Dodgems dodgems;
    Playground playground;
    RollerCoaster rollerCoaster;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void before(){
        themePark = new ThemePark();
        dodgems = new Dodgems("Bumper Cars", 5);
        playground = new Playground("Fun Zone", 7);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 3);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 5);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 4);
        visitor1 = new Visitor(11, 110, 34.66);
        visitor2 = new Visitor(18, 180, 34.66);
    }

    @Test
    public void canReturnAnArrayListOfAllReviewed() {
        assertEquals(0, themePark.getAllReviewed().size());
    }

    @Test
    public void canAddVisitorLocationsToArrayList(){
        themePark.addToAllReviewed(rollerCoaster);
        themePark.addToAllReviewed(iceCreamStall);
        assertEquals(2, themePark.getAllReviewed().size());
    }

    @Test
    public void canIncrementVisitCount(){
        themePark.visit(visitor1, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
    }

    @Test
    public void canAddAttractionToVisitedAttractionsList(){
        themePark.visit(visitor1, rollerCoaster);
        assertEquals(1, visitor1.getVisitedAttractions().size());
    }
}
