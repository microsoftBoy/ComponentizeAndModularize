package com.example.shuaige.componentizeandmodularize;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.modulea.MainModuleAActivity;
import com.example.shuaige.common.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private ArrayList<String> datas;
    private BaseRecyclerViewAdapter<String> baseRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager );
        baseRecyclerViewAdapter = new BaseRecyclerViewAdapter<String>(datas, R.layout.rv_item_view) {

            @Override
            public ArrayList<Integer> bindDataToView(VH viewHolder, int postion, String model) {
                Log.i(TAG, "bindDataToView: postion = "+postion);

                viewHolder.setText(R.id.tv, "item " + model);

                return null;
            }
        };
        baseRecyclerViewAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClick<String>() {
            @Override
            public void onItemClick(View v, int position, String item) {
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this, MainModuleAActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, MainModuleAActivity.class));
                        break;
                    case 2:
                        break;
                }
            }
        });
        recyclerView.setAdapter(baseRecyclerViewAdapter);

    }

    private void initData(){
        datas = new ArrayList<>();
        datas.add("t跳转到组件a");
        datas.add("t跳转到组件b");
    }

}
