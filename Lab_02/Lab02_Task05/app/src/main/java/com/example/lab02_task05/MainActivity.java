package com.example.lab02_task05;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerDish;
    SpinnerAdapter spinnerAdapter;
    Dish res_dish;
    Button btnAdd;
    GridView gvDish;
    EditText edtName;
    ArrayList<Dish> arrayDish;
    ArrayList<Dish> dishGv;
    DishAdapter adapter;
    CheckBox chbxPromotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arrayDish = new ArrayList<Dish>();
        arrayDish.add(new Dish("Thumbnail 1", R.drawable.first_thumbnail));
        arrayDish.add(new Dish("Thumbnail 2", R.drawable.second_thumbnail));
        arrayDish.add(new Dish("Thumbnail 3", R.drawable.third_thumbnail));
        arrayDish.add(new Dish("Thumbnail 4", R.drawable.fourth_thumbnail));

        //final List<String> thumbnails = Arrays.asList("cake", "candy", "chocolate", "icecream", "omelette");
        spinnerDish = (Spinner) findViewById(R.id.spinner);

        spinnerAdapter = new SpinnerAdapter(getApplicationContext(), R.layout.my_dropdown_item, arrayDish);
        spinnerDish.setAdapter(spinnerAdapter);


        spinnerDish.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                res_dish = arrayDish.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        chbxPromotion = (CheckBox) findViewById(R.id.checkBox) ;
        btnAdd  = (Button) findViewById(R.id.btnAdd) ;
        gvDish = (GridView) findViewById(R.id.gvDish);

        edtName = (EditText) findViewById(R.id.edtName);
        dishGv = new ArrayList<Dish>();
        adapter = new DishAdapter(this, R.layout.item_dish,dishGv);
        gvDish.setAdapter(adapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                Dish dish = new Dish();
                dish.setName(name);

                dish.setThumbnail(res_dish.getThumbnail());

                if (chbxPromotion.isChecked())
                {
                    dish.setPromotion(true);
                }
                else
                {
                    dish.setPromotion(false);
                }

                dishGv.add(dish);
                edtName.setText("");
                spinnerDish.setSelection(0);
                chbxPromotion.setChecked(false);
                adapter.notifyDataSetChanged();
            }
        });
    }
}