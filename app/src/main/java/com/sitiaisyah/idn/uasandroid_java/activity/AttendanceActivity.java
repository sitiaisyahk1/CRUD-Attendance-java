package com.sitiaisyah.idn.uasandroid_java.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sitiaisyah.idn.uasandroid_java.R;
import com.sitiaisyah.idn.uasandroid_java.model.AttendanceItem;
import com.sitiaisyah.idn.uasandroid_java.remote.APIUtils;
import com.sitiaisyah.idn.uasandroid_java.remote.ProductService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendanceActivity extends AppCompatActivity {

    ProductService productService;
    EditText edtDate ,edtName, edtKelas, edtLesson, edtDescription, edtId;
    Button btnSave, btnDel;
    TextView txtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtDate = findViewById(R.id.edt_date);
        edtName = findViewById(R.id.edt_name);
        edtKelas = findViewById(R.id.edt_class);
        edtLesson = findViewById(R.id.edt_lesson);
        edtDescription = findViewById(R.id.edt_desc);

        btnSave = findViewById(R.id.btn_save);
        btnDel = findViewById(R.id.btn_delete);

        edtId = findViewById(R.id.edt_id);
        txtId = findViewById(R.id.txt_id);

        productService = APIUtils.getProductService();

        Bundle extras = getIntent().getExtras();
        String Date = extras.getString("date");
        String Name = extras.getString("name");
        String Kelas = extras.getString("kelas");
        String Lesson = extras.getString("lesson");
        String Description = extras.getString("description");
        final String ID = extras.getString("id");

        edtId.setText(ID);
        edtDate.setText(Date);
        edtName.setText(Name);
        edtKelas.setText(Kelas);
        edtLesson.setText(Lesson);
        edtDescription.setText(Description);

        if (ID != null && ID.trim().length() > 0) {
            edtId.setFocusable(false);
        } else {
            txtId.setVisibility(View.INVISIBLE);
            edtId.setVisibility(View.INVISIBLE);
            btnDel.setVisibility(View.INVISIBLE);
        }

        btnSave.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String date = edtDate.getText().toString();
                String name = edtName.getText().toString();
                String kelas = edtKelas.getText().toString();
                String lesson = edtLesson.getText().toString();
                String description = edtDescription.getText().toString();

                if (ID != null && ID.trim().length() > 0){
                    updateAttendance(Integer.parseInt(ID), date ,name, kelas, lesson, description);
                } else {
                    addAttendance(date ,name, kelas, lesson, description);
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAttendance(Integer.parseInt(ID));
                Intent intent = new Intent(AttendanceActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addAttendance(String date, String name, String kelas, String lesson, String description) {
        Call<AttendanceItem> call = productService.addAttendance(date, name, kelas, lesson, description);
        call.enqueue(new Callback<AttendanceItem>() {
            @Override
            public void onResponse(Call<AttendanceItem> call, Response<AttendanceItem> response) {
                if (response.isSuccessful()){
                    Toast.makeText(AttendanceActivity.this, "product added succesfully",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AttendanceActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<AttendanceItem> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    private void updateAttendance(int id, String date, String name, String kelas, String lesson, String description) {
        Call<AttendanceItem> call = productService.updateAttendance(id, date, name, kelas, lesson, description);
        call.enqueue(new Callback<AttendanceItem>() {
            @Override
            public void onResponse(Call<AttendanceItem> call, Response<AttendanceItem> response) {
                if (response.isSuccessful()){
                    Toast.makeText(AttendanceActivity.this, "Product Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AttendanceActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<AttendanceItem> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    private void deleteAttendance(int id){
        Call<AttendanceItem> call = productService.deleteAttendance(id);
        call.enqueue(new Callback<AttendanceItem>() {
            @Override
            public void onResponse(Call<AttendanceItem> call, Response<AttendanceItem> response) {
                if (response.isSuccessful()){
                    Toast.makeText(AttendanceActivity.this, "Product deleted",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AttendanceActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<AttendanceItem> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}