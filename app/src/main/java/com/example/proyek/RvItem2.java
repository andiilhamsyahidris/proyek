package com.example.proyek;

import com.example.proyek.settergetter.RvItemSetGet2;

import java.util.ArrayList;

public class RvItem2 {
    public static String Name[] = {
            "Special",
            "Variance",
            "Other"
    };
    public static int Photo[] = {

            R.drawable.vegetables,
            R.drawable.seasoning,
            R.drawable.fruits
    };

    public static ArrayList<RvItemSetGet2> getListData(){
        ArrayList<RvItemSetGet2> list = new ArrayList<>();
        for (int position = 0; position < Name.length; position++){
            RvItemSetGet2 hero = new RvItemSetGet2();
            hero.setName(Name[position]);
            hero.setPhoto(Photo[position]);

            list.add(hero);
        }
        return list;
    };
}
