package com.example.proyek;

import java.util.ArrayList;
public class VegetableData {

    public static String Name[] = {
            "Timun",
            "Bayam",
            "Buncis",
            "Brokoli",
            "Daung Singkong",
            "Daun Seledri",
            "Kangkung",
            "Kol"
    };

    public static int Harga[] = {
            30000,
            28000,
            25000,
            26000,
            15000,
            12000,
            20000,
            18000
    };

    public static int Photo[] = {
            R.drawable.cucumber,
            R.drawable.bayam,
            R.drawable.buncis,
            R.drawable.brokoli,
            R.drawable.daunsingkong,
            R.drawable.daunseledri,
            R.drawable.kangkung,
            R.drawable.brokoli

    };

    public static ArrayList<VegetablesSetGet> getListData(){
        ArrayList<VegetablesSetGet> list = new ArrayList<>();
        for (int position = 0; position < Name.length; position++){
            VegetablesSetGet vegetablesSetGet = new VegetablesSetGet();
            vegetablesSetGet.setName(Name[position]);
            vegetablesSetGet.setHarga(Harga[position]);
            vegetablesSetGet.setPhoto(Photo[position]);
            list.add(vegetablesSetGet);
        }
        return list;
    };


}
