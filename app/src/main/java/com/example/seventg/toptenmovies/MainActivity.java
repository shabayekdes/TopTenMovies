package com.example.seventg.toptenmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Movies> mydata = new ArrayList<Movies>();
        mydata.add(new Movies("Saw","horror movies",R.drawable.saw));
        mydata.add(new Movies("lord of rings","three parts movies",R.drawable.lord));
        mydata.add(new Movies("ring","two parts movies",R.drawable.ring));
        myCustomAdapter adapter = new myCustomAdapter(mydata);
        ListView ls = (ListView) findViewById(R.id.list_view);
        ls.setAdapter(adapter);
    }
    class myCustomAdapter extends BaseAdapter{
        ArrayList<Movies> mydata = new ArrayList<Movies>();
        myCustomAdapter( ArrayList<Movies> mydata){
            this.mydata = mydata;
        }
        @Override
        public int getCount() {
            return mydata.size();
        }
        @Override
        public Object getItem(int position) {
            return mydata.get(position).name;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater myinflater = getLayoutInflater();
            View myview = myinflater.inflate(R.layout.row_list,null);
            TextView txtname = (TextView) myview.findViewById(R.id.txtname);
            TextView txtdes = (TextView) myview.findViewById(R.id.txtdes);
            ImageView img = (ImageView)myview.findViewById(R.id.imageView);
            Movies temp = mydata.get(position);

            txtname.setText(temp.name);
            txtdes.setText(temp.des);
            img.setImageResource(temp.img);

            return myview;
        }
    }


}
