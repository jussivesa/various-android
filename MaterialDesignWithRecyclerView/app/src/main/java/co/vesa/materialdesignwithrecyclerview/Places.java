package co.vesa.materialdesignwithrecyclerview;

import java.util.ArrayList;

/**
 *
 * Place names must have matching image named from the location name
 * where name is truncated and lowercase eg. oldcource.jpg for Old Cource
 *
 * Created by jussivesa on 12/10/2017.
 */

public class Places {

    private static String[] placeNameArray = {
            "Black Mountain", "Chambers Bay", "Clear Water", "Harbour Town",
            "Muirfield", "Old Course", "Pebble Beach", "Spy Class", "Turtle Bay"};

    protected static ArrayList<Place> placeList() {
        ArrayList<Place> list = new ArrayList<>();
        for (int i = 0; i < placeNameArray.length; i++) {
            Place place = new Place();
            place.name = placeNameArray[i];
            place.imageName = placeNameArray[i].replaceAll("\\s+", "").toLowerCase();
            list.add(place);
        }
        return list;
    }

}
