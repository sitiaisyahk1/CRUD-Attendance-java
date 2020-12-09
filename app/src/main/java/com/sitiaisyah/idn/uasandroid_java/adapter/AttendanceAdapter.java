package com.sitiaisyah.idn.uasandroid_java.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sitiaisyah.idn.uasandroid_java.R;
import com.sitiaisyah.idn.uasandroid_java.activity.AttendanceActivity;
import com.sitiaisyah.idn.uasandroid_java.model.AttendanceItem;

import java.util.List;


public class AttendanceAdapter extends ArrayAdapter<AttendanceItem>{
    private Context context;
    private List<AttendanceItem> attendanceeItem;

    public AttendanceAdapter(@NonNull Context context,
                             int resource,
                             @NonNull List<AttendanceItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.attendanceeItem = objects;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_item, parent, false);

        TextView txtId = v.findViewById(R.id.txt_attendance_id);
        TextView txtDate = v.findViewById(R.id.txt_attendance_date);
        TextView txtName = v.findViewById(R.id.txt_attendance_name);
        TextView txtKelas = v.findViewById(R.id.txt_attendance_level);
        TextView txtLesson = v.findViewById(R.id.txt_attendance_lesson);
        TextView txtDescription = v.findViewById(R.id.txt_attendance_desc);

        txtId.setText(String.valueOf( attendanceeItem.get(position).getId()));
        txtDate.setText(String.valueOf(attendanceeItem.get(position).getDate()));
        txtName.setText(String.valueOf(attendanceeItem.get(position).getName()));
        txtKelas.setText(String.valueOf(attendanceeItem.get(position).getKelas()));
        txtLesson.setText(String.valueOf(attendanceeItem.get(position).getLesson()));
        txtDescription.setText(String.valueOf(attendanceeItem.get(position).getDescription()));

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AttendanceActivity.class);
                intent.putExtra("id", String.valueOf(attendanceeItem.get(position).getId()));
                intent.putExtra("date", attendanceeItem.get(position).getDate());
                intent.putExtra("name", attendanceeItem.get(position).getName());
                intent.putExtra("kelas", attendanceeItem.get(position).getKelas());
                intent.putExtra("lesson", attendanceeItem.get(position).getLesson());
                intent.putExtra("description", attendanceeItem.get(position).getDescription());
                context.startActivity(intent);
            }
        });

        return v;
    }

}