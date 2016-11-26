package com.example.rodrigo.demorv;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.marshalchen.ultimaterecyclerview.layoutmanagers.ScrollSmoothLineaerLayoutManager;
import com.marshalchen.ultimaterecyclerview.swipe.SwipeItemManagerInterface;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SwipeAdapter adapter;
    private List<DataModel> data;
    private ScrollSmoothLineaerLayoutManager mLayoutManager;
    protected UltimateRecyclerView ultimateRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ultimateRecyclerView = (UltimateRecyclerView) findViewById(R.id.ultimate_recycler_view);
        init();
    }

    private void init() {
        data = new ArrayList<>();
        data.add(new DataModel("Rodrigo 1", "Bill"));
        data.add(new DataModel("Rodrigo 2", "Bill"));
        data.add(new DataModel("Rodrigo 3", "Bill"));
        data.add(new DataModel("Rodrigo 4", "Bill"));
        data.add(new DataModel("Rodrigo 5", "Bill"));
        data.add(new DataModel("Rodrigo 6", "Bill"));
        data.add(new DataModel("Rodrigo 7", "Bill"));
        data.add(new DataModel("Rodrigo 8", "Bill"));
        data.add(new DataModel("Rodrigo 9", "Bill"));
        data.add(new DataModel("Rodrigo 10", "Bill"));
        adapter = new SwipeAdapter(data);
        adapter.setMode(SwipeItemManagerInterface.Mode.Single);
        mLayoutManager = new ScrollSmoothLineaerLayoutManager(this, LinearLayoutManager.VERTICAL, false, 500);
        ultimateRecyclerView.setLayoutManager(mLayoutManager);
        ultimateRecyclerView.setAdapter(adapter);
    }
}

