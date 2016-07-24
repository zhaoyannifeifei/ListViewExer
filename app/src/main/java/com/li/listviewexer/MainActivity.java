package com.li.listviewexer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.li.listviewexer.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ListView mListView;
    List<Fruit> mFruitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.activity_main_list_view);

        initFruit();

        FruitAdapter fruitAdapter = new FruitAdapter(this, R.layout.list_item_fruit, mFruitList);
        mListView.setAdapter(fruitAdapter);


    }

    private void initFruit() {
        String[] fruitName = {"apple", "banana", "orange", "watermelon", "pear", "grape",
                "Pineapple", "strawberry", "cherry", "apple", "banana", "orange"};
        int[] fruitImages = {R.drawable.apple_pic, R.drawable.banana_pic, R.drawable.orange_pic,
                R.drawable.watermelon_pic, R.drawable.pear_pic, R.drawable.grape_pic,
                R.drawable.pineapple_pic, R.drawable.strawberry_pic, R.drawable.cherry_pic,
                R.drawable.apple_pic, R.drawable.banana_pic, R.drawable.orange_pic};
        mFruitList = new ArrayList<>();
        for (int i = 0; i < fruitName.length; i++) {
            Fruit fruit = new Fruit(fruitName[i], fruitImages[i]);
            mFruitList.add(fruit);
        }
    }

    public class FruitAdapter extends ArrayAdapter<Fruit> {
        private int mCountOfInflate = 0;

        public FruitAdapter(Context context, int resource, List<Fruit> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_fruit,
                        parent, false);
                Log.d(TAG, "新造箱子" + (++mCountOfInflate));
            } else {
                view = convertView;
            }

            ImageView imageView = (ImageView) view.findViewById(
                    R.id.list_item_fruit_image_view);
            TextView textView = (TextView) view.findViewById(
                    R.id.list_item_fruit_name_text_view);

            Fruit fruit = getItem(position);
            imageView.setImageResource(fruit.getmImageId());
            textView.setText(fruit.getmName());
            return view;
        }

        @Override
        public int getCount() {
            Log.d(TAG, "getCount: " + super.getCount());
            return super.getCount();
        }
    }

}
