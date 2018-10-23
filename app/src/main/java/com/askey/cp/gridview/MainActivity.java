package com.askey.cp.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView grid;
    private String[] notify;
    private int[] icons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = findViewById(R.id.grid);
        notify = getResources().getStringArray(R.array.liststring);
        icons = new int[]{R.drawable.func_balance,R.drawable.func_history,R.drawable.func_news,R.drawable.func_finance,R.drawable.func_exit};
        //final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, notify);
        IconAdapter adapter = new IconAdapter();
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch((int) id){
            case R.drawable.func_balance:
            case R.drawable.func_history:
            case R.drawable.func_news:
            case R.drawable.func_finance:
                break;
            case R.drawable.func_exit:
                finish();
                break;
        }
    }
    class IconAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return notify.length    ;
        }

        @Override
        public Object getItem(int position) {
            return notify[position];
        }

        @Override
        public long getItemId(int position) {
            return icons[position];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (row ==null){
                row = getLayoutInflater().inflate(R.layout.item_row,null);
            }
            setImage(position, row);
            return row;
        }

        private void setImage(int position, View row) {
            TextView item_text = row.findViewById(R.id.item_text);
            ImageView item_image = row.findViewById(R.id.item_image);
            item_text.setText(notify[position]);
            item_image.setImageResource(icons[position]);
        }
    }
}
