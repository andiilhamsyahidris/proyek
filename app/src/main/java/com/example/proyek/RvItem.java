package com.example.proyek;

import java.util.ArrayList;

public class RvItem {
    public static String Name[] = {
            "Sayur",
            "Bumbu",
            "Other"
    };
    public static int Photo[] = {

            R.drawable.vegetables,
            R.drawable.seasoning,
            R.drawable.fruits
    };

    public static ArrayList<RvItemSetGet> getListData(){
        ArrayList<RvItemSetGet> list = new ArrayList<>();
        for (int position = 0; position < Name.length; position++){
            RvItemSetGet hero = new RvItemSetGet();
            hero.setName(Name[position]);
            hero.setPhoto(Photo[position]);

            list.add(hero);
        }
        return list;
    };
}
