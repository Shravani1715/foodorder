package com.sveri.foodapplicaion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.sveri.foodapplicaion.Database.Database;

import java.util.jar.Attributes;

public class MainActivity2 extends AppCompatActivity {
    EditText fname, items, total;

    Button button;
    ListView lv;
    Database mdb = new Database(this);
    Cursor cursor;
    SimpleCursorAdapter sca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initialize();
        eventHandler();
        showData();

    }
    protected void initialize(){
        fname = (EditText) findViewById(R.id.editTextName);
        items = (EditText) findViewById(R.id.editTextitems);
        total = (EditText) findViewById(R.id.editTexttotal);
        button = (Button) findViewById(R.id.button);
        lv = (ListView) findViewById(R.id.listViewfood);
    }
    protected void eventHandler(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Your order is successfully done", Toast.LENGTH_SHORT).show();
                String etName =fname.getText().toString().trim();
                Integer intitems = Integer.parseInt(items.getText().toString().trim());
                Integer inttotal = Integer.parseInt(total.getText().toString().trim());

                if(etName.isEmpty()){
                    fname.setError("Dish can not be Empty");
                }else if(intitems == null || intitems.equals("")){
                    items.setError("Items can not be empty");
                }else if(inttotal == null || inttotal.equals("")){
                    total.setError("total can not be Empty");
                }else {
                    ContentValues cv=new ContentValues();
                    cv.put("name",etName);
                    cv.put("items",intitems);
                    cv.put("total",inttotal);

                    mdb.insertOrder(cv);
                    Toast.makeText(MainActivity2.this, "Data inserted Successfully", Toast.LENGTH_SHORT).show();

                    fname.setText(null);
                    items.setText(null);
                    total.setText(null);

                    cursor.requery();
                }
            }
        });
    }
    public void showData(){
        cursor = mdb.getData();
        cursor.requery();
        String[] fromDb = {"name","items","total"};
        int[] toTextView = {R.id.textViewName, R.id.textViewitems, R.id.textViewtotal};
        sca = new SimpleCursorAdapter(MainActivity2.this,R.layout.row,cursor,fromDb,toTextView,1);
        lv.setAdapter(sca);
        sca.notifyDataSetChanged();
        cursor.requery();
    }
}