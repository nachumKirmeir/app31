package com.example.app31;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;
    ArrayList<Toy> toyList;
    ToyAdapter toyAdapter;
    Toy lastSelected;
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

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        lastSelected = toyAdapter.getItem(i);
        Intent intent = new Intent(MainActivity.this, EditActivity.class);
        intent.putExtra("title", lastSelected.getTitle());
        intent.putExtra("sub", lastSelected.getSubTitle());
        intent.putExtra("price", String.valueOf(lastSelected.getPrice()));
         startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0){
            if(resultCode == RESULT_OK){
                String title = data.getExtras().getString("title");
                String sumTitle = data.getExtras().getString("sub");
                String price = data.getExtras().getString("price");
                lastSelected.setPrice(Integer.parseInt(price));
                lastSelected.setTitle(title);
                lastSelected.setSubTitle(sumTitle);
                Toast.makeText(this, "The Data Has Saved", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "User Cancel", Toast.LENGTH_SHORT).show();
            }
        }
    }
}