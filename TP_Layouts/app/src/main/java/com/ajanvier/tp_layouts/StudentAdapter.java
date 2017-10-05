package com.ajanvier.tp_layouts;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by antoine on 05/10/17.
 */

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Student> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.student_row, null);

        Student currentStudent = getItem(position);

        ((TextView) row.findViewById(R.id.studentFirstName)).setText(currentStudent.getFirstName());
        ((TextView) row.findViewById(R.id.studentLastName)).setText(currentStudent.getLastName());

        return row;
    }
}
