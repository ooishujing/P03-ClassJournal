package sg.edu.rp.c346.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Module> modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lv = findViewById(R.id.lvModule);
        modules = new ArrayList<>(Arrays.asList(new Module ("C302", "Web Services", "derek_lee@rp.edu.sg"), new Module("C347", "Android Programming II", "jason_lim@rp.edu.sg")));
        ArrayAdapter aa = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_2, android.R.id.text1, modules) {
            
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tvCode = (TextView) view.findViewById(android.R.id.text1);
                TextView tvDes = (TextView) view.findViewById(android.R.id.text2);

                tvCode.setText(modules.get(position).getCode());
                tvDes.setText(modules.get(position).getDescription());
                return view;
            }
        };
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("modules", modules.get(position));
                startActivity(intent);
            }
        });
    }
}
