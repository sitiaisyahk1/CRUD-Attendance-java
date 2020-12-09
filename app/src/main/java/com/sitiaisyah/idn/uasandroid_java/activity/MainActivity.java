package com.sitiaisyah.idn.uasandroid_java.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.sitiaisyah.idn.uasandroid_java.R;
import com.sitiaisyah.idn.uasandroid_java.adapter.AttendanceAdapter;
import com.sitiaisyah.idn.uasandroid_java.model.AttendanceItem;
import com.sitiaisyah.idn.uasandroid_java.remote.APIUtils;
import com.sitiaisyah.idn.uasandroid_java.remote.ProductService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnAddUser;
    Button btnGetUser;
    ListView rv;
    ProductService productService;
    List<AttendanceItem> list = new ArrayList<AttendanceItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddUser = findViewById(R.id.btnAddUser);
        btnGetUser = findViewById(R.id.btnGetUserList);
        rv = findViewById(R.id.rv);

        productService = APIUtils.getProductService();

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AttendanceActivity.class);
                intent.putExtra("date", "");
                intent.putExtra("name", "");
                intent.putExtra("kelas", "");
                intent.putExtra("lesson", "");
                intent.putExtra("description", "");
                startActivity(intent);
            }
        });

        btnGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserList();
            }
        });

    }

    public void getUserList() {
        Call<List<AttendanceItem>> call = productService.getAttendance();
        call.enqueue(new Callback<List<AttendanceItem>>() {
            @Override
            public void onResponse(Call<List<AttendanceItem>> call, Response<List<AttendanceItem>> response) {
                if (response.isSuccessful()){
                    list = response.body();
                    rv.setAdapter(new AttendanceAdapter(MainActivity.this,
                            R.layout.list_item, list));
                }
            }

            @Override
            public void onFailure(Call<List<AttendanceItem>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}