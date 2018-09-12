package com.example.waleedkalyar.customlistviewpractice.customInstituteAdapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.waleedkalyar.customlistviewpractice.CustomInstituteModel.InstituteModel;
import com.example.waleedkalyar.customlistviewpractice.R;

/**
 * Created by WALEED KALYAR on 8/8/2017.
 */

public class InstitueAdapter extends ArrayAdapter {
    Context context;
    int resource;
    InstituteModel[] instituteData;
    LayoutInflater instInflater;

    public InstitueAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull InstituteModel[] instituteData) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.instituteData = instituteData;
        instInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = instInflater.inflate(resource, null);
        ImageView iThumnail = (ImageView) convertView.findViewById(R.id.institute_thumnail);
        TextView iName = (TextView) convertView.findViewById(R.id.institute_name);
        TextView iLocation = (TextView) convertView.findViewById(R.id.institute_location);
        TextView iPositions = (TextView) convertView.findViewById(R.id.institute_positions);
        TextView iStudents = (TextView) convertView.findViewById(R.id.institute_students);


        iThumnail.setImageResource(instituteData[position].instThumnail);
        iName.setText(instituteData[position].instName);
        iLocation.setText(instituteData[position].instLocation);
        iPositions.setText(instituteData[position].instPositions);
        iStudents.setText(instituteData[position].instStudents);

        return convertView;
    }

    @Override
    public int getCount() {
        return instituteData.length;
    }
}
