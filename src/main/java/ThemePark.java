import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;

import java.util.ArrayList;

public class ThemePark {

    private ArrayList<IReviewed> attractions = new ArrayList <>();
    private ArrayList<IReviewed> stalls = new ArrayList<>();

    private ArrayList<IReviewed> allReviewed = new ArrayList<>();

    public ThemePark() {
        this.attractions = new ArrayList<>();
        this.stalls = new ArrayList<>();
    }

    public ArrayList<IReviewed> getAllReviewed(){
        return allReviewed;
    }

    public void addToAllReviewed(IReviewed place) {
        allReviewed.add(place);
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.incrementVisitCount();
        visitor.addAttraction(attraction);
    }
}
