package co.vesa.materialdesignwithrecyclerview;

import android.content.Context;

/**
 * Created by jussivesa on 12/10/2017.
 */

public class Place {

    public String name;
    public String imageName;

    public int getImageResourceId(Context context) {
        return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
    }

}
