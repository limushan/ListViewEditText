package com.android.edittextdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.android.edittextdemo.domain.EditData;
import com.android.edittextdemo.R;
import com.android.edittextdemo.view.EditView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView mListView;
    private ArrayList<EditData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

    }

    private void initData() {
        if (data == null) {
            data = new ArrayList<>();
        }
        for (int i = 0; i < 20; i++) {
            data.add(new EditData());
        }
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.lv);
        mListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = new EditView(MainActivity.this);

                }

                ((EditView) convertView).setData(data.get(position), position);
                return convertView;
            }
        });
    }

}
