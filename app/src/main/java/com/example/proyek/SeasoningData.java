package com.example.proyek;

import java.util.ArrayList;

public class SeasoningData {
    public static String Name[] = {
            "Bawang merah putih",
            "Bawang bombay",
            "Cabai",
            "Merica",
            "Jahe",
            "Ketumbar"

    };
    public static int Harga[] = {

            15000,
            15000,
            12000,
            9000,
            9000,
            7000
    };
    public static int Photo[] = {
            R.drawable.onion,
            R.drawable.bawangbobay,
            R.drawable.cabai,
            R.drawable.merica,
            R.drawable.jahe,
            R.drawable.ketumbar
    };
    public static ArrayList<SeasoningSetGet> getListData(){
        ArrayList<SeasoningSetGet> list = new ArrayList<>();
        for (int position = 0; position < Name.length; position++){
            SeasoningSetGet seasoningSetGet = new SeasoningSetGet();
            seasoningSetGet.setName(Name[position]);
            seasoningSetGet.setHarga(Harga[position]);
            seasoningSetGet.setPhoto(Photo[position]);
            list.add(seasoningSetGet);
        }
        return  list;

    };



}
