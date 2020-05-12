package sg.edu.rp.c346.p03_classjournal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView tvWeek;
    Button btn;
    RadioGroup rg;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvWeek = findViewById(R.id.tvWeek);
        btn = findViewById(R.id.btnSubmut);
        rg = findViewById(R.id.radioGroup);

        Intent intent = getIntent();
        num = intent.getIntExtra("modules", 0);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Week " + num);

        tvWeek.setText("Week " + num);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                RadioButton r = (RadioButton) rg.getChildAt(rg.indexOfChild(rg.findViewById(rg.getCheckedRadioButtonId())));
                i.putExtra("new", new Week(num, r.getText().toString()));
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
