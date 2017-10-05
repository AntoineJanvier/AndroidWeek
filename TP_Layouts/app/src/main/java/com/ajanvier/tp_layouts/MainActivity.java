package com.ajanvier.tp_layouts;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends ListActivity {

    final String[] days = new String[] {
            "MONDAY",
            "TUESDAY",
            "WEDNESDAY",
            "THURSDAY",
            "FRIDAY",
            "SATURDAY",
            "SUNDAY",
            "MONDAY",
            "TUESDAY",
            "WEDNESDAY",
            "THURSDAY",
            "FRIDAY",
            "SATURDAY",
            "SUNDAY",
            "MONDAY",
            "TUESDAY",
            "WEDNESDAY",
            "THURSDAY",
            "FRIDAY",
            "SATURDAY",
            "SUNDAY",
            "MONDAY",
            "TUESDAY",
            "WEDNESDAY",
            "THURSDAY",
            "FRIDAY",
            "SATURDAY",
            "SUNDAY"
    };

    List<Student> studentList = Arrays.asList(
            new Student("Toto", "Titi"), new Student("Baba", "Bibi"),
            new Student("Caca", "Kiki"), new Student("Lala", "Lili"),
            new Student("dsfq", "dsfq"), new Student("fgfreefr", "fgfreefr"),
            new Student("fgfreefr", "fgfreefr"), new Student("fgfreefr", "fgfreefr"),
            new Student("fgfreefr", "fgfreefr"), new Student("fgfreefr", "fgfreefr"),
            new Student("fgfreefr", "fgfreefr"), new Student("fgfreefr", "fgfreefr"),
            new Student("fgfreefr", "fgfreefr"), new Student("gesrtr", "gesrtr"),
            new Student("gesrtr", "gesrtr"), new Student("gesrtr", "gesrtr"),
            new Student("gesrtr", "gesrtr"), new Student("gesrtr", "gesrtr"),
            new Student("gesrtr", "gesrtr"), new Student("gesrtr", "gesrtr"),
            new Student("gesrtr", "gesrtr"), new Student("gesrtr", "gesrtr"),
            new Student("gerge", "gerge"), new Student("gerge", "gerge"),
            new Student("gerge", "gerge"), new Student("gerge", "gerge"),
            new Student("gerge", "gerge"), new Student("gerge", "gerge"),
            new Student("gerge", "gerge"), new Student("gerge", "gerge"),
            new Student("gerge", "gerge"), new Student("gerge", "gerge"),
            new Student("gerge", "gerge"), new Student("gerge", "gerge"),
            new Student("gerge", "gerge"), new Student("gerge", "gerge"),
            new Student("gerge", "gerge"), new Student("gerge", "gerge"),
            new Student("gerge", "gerge"), new Student("gerge", "gerge")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<Student> arrayAdapter = new StudentAdapter(
                this,
                android.R.layout.simple_list_item_1,
                studentList
        );
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Student student = (Student) getListAdapter().getItem(position);
        TextView textView = findViewById(R.id.tv);
        textView.setText(student.getFirstName() + " " + student.getLastName());
    }
}
