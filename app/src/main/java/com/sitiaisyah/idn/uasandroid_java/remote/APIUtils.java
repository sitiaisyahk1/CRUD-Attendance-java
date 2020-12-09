package com.sitiaisyah.idn.uasandroid_java.remote;

public class APIUtils {

    private APIUtils(){

    }

    public static final String API_URL = "http://192.168.1.6/attendance/index.php/attendance/";

    public static ProductService getProductService(){
        return RetrofitClient.getClient(API_URL).create(ProductService.class);
    }
}
