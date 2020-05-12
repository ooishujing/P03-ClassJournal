package sg.edu.rp.c346.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DGAdapter extends ArrayAdapter<Week>{

    private ArrayList<Week> day;
    private Context context;
    private TextView tvWeek, tvDG;
    private ImageView iv;

    public DGAdapter(Context context, int resource, ArrayList<Week> objects){
        super(context, resource, objects);

        day = objects;
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);


        tvWeek = rowView.findViewById(R.id.tvWeek);
        tvDG = rowView.findViewById(R.id.tvDG);
        iv = rowView.findViewById(R.id.imageView);


        Week now = day.get(position);
        tvWeek.setText("Week " + (position+1));
        tvDG.setText(now.getGrade());

        return rowView;
    }
}
