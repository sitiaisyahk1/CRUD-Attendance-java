package com.sitiaisyah.idn.uasandroid_java.remote;

import com.sitiaisyah.idn.uasandroid_java.model.AttendanceItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ProductService {

    @GET("attendance/get/")
    Call<List<AttendanceItem>> getAttendance();

    @FormUrlEncoded
    @POST("attendance/add")
    Call<AttendanceItem> addAttendance(@Field("date") String date,
                                       @Field("name") String name,
                                       @Field("kelas") String kelas,
                                       @Field("lesson") String lesson,
                                       @Field("description") String description);


    @FormUrlEncoded
    @PUT("attendance/update/")
    Call<AttendanceItem> updateAttendance(@Field("id") int id,
                                          @Field("date") String date,
                                          @Field("name") String name,
                                          @Field("kelas") String kelas,
                                          @Field("lesson") String lesson,
                                          @Field("description") String description);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = ("attendance/delete/"), hasBody = true)
    Call<AttendanceItem> deleteAttendance(@Field("id") int id);

}
