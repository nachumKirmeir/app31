package com.example.app31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Toy> toyList;
    ToyAdapter toyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        Toy t1 = new Toy(50,"home","very good toy");
        Toy t2 = new Toy(70,"home","average  toy");
        Toy t3 = new Toy(90,"home","nice toy");
        Toy t4 = new Toy(29,"light","very good toy");
        Toy t5 = new Toy(37,"phone","average  toy");
        Toy t6 = new Toy(50,"light","nice toy");
        Toy t7 = new Toy(29,"light","very good toy");
        Toy t8 = new Toy(37,"phone","average  toy");
        Toy t9 = new Toy(50,"light","nice toy");

        toyList = new ArrayList<Toy>();
        toyList.add(t1);toyList.add(t2);toyList.add(t3);
        toyList.add(t4);toyList.add(t5);toyList.add(t6);
        toyList.add(t7);toyList.add(t8);toyList.add(t9);

        toyAdapter = new ToyAdapter(this, 0,0,toyList);
        lv.setAdapter(toyAdapter);
    }
}