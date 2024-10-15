package com.example.lab02_task06;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    CheckBox chbxManager;
    Button btnAdd;
    RecyclerView rvEmployee;
    ArrayList<Employee> employees;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        chbxManager = findViewById(R.id.chbxManager);
        btnAdd = findViewById(R.id.btnAdd);
        rvEmployee = findViewById(R.id.rv_Employee);

        employees = new ArrayList<>();
        adapter = new EmployeeAdapter(this, employees);

        rvEmployee.setLayoutManager(new LinearLayoutManager(this));
        rvEmployee.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                Employee employee = new Employee();
                employee.setFullName(name);
                employee.setManager(chbxManager.isChecked());

                employees.add(employee);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
