package com.mulganov.test_task.anoda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Element> els = new ArrayList<>();

        els.add(new GsonBuilder().setPrettyPrinting().create().fromJson(JsonInput.obj1(), Element.class));
        els.add(new GsonBuilder().setPrettyPrinting().create().fromJson(JsonInput.obj1(), Element.class));
        els.add(new GsonBuilder().setPrettyPrinting().create().fromJson(JsonInput.obj1(), Element.class));

        BoxAdapter adapter = new BoxAdapter(this, els);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ((RecyclerView)findViewById(R.id.list)).setAdapter(adapter);


        findViewById(R.id.photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "photo", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.direct).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "direct", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
