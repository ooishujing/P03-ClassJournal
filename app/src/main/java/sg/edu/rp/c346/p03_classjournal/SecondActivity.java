package sg.edu.rp.c346.p03_classjournal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    Button btnInfo, btnAdd, btnEmail;
    Module modules;
    String message;
    ArrayList<Week> dgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = this.findViewById(R.id.lvDG);
        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = findViewById(R.id.buttonEmail);


        dgs = new ArrayList<Week>();
        Intent intent = getIntent();
        modules = (Module) intent.getSerializableExtra("modules");

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Info for " + modules.getCode());

        aa = new DGAdapter(this, R.layout.row, dgs);
        lv.setAdapter(aa);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/" + modules.getCode()));
                startActivity(rpIntent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                i.putExtra("modules", dgs.size()+1);
                startActivityForResult(i,0);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{modules.getEmail()});
                message = "Hi faci,\n\nI am ...\nPlease see my results so far, thank you!\n\n";
                for (Week w: dgs) {
                    message += "Week " + w.getWeek() + ": DG: " + w.getGrade() + "\n";
                }
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data != null) {
                dgs.add((Week) data.getSerializableExtra("new"));
                aa.notifyDataSetChanged();
            }
        }
    }
}
