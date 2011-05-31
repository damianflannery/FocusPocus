package com.drotox.android.focuspocus;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class HomeActivity extends Activity {
	
	private ListView mListView;
	private MyListViewAdapter mAdapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        ArrayList<Food> foods = new ArrayList<Food>();
        foods.add(new Food("chocolate", 20, 1));
        foods.add(new Food("sponge cake", 10, 2));
        foods.add(new Food("apple", 1, 5));

        mAdapter = new MyListViewAdapter(this);
        mAdapter.setItems(foods);
        
		mListView = (ListView) findViewById(R.id.listview_lv);
		mListView.setAdapter(mAdapter);
    }
}