package com.adelia.nainggolan.retrofit_java.Remote;

public class APIUtils {
    private APIUtils(){

    }

    public static final String API_URL = "http://10.0.2.2/marketplace/index.php/";
    public static com.adelia.nainggolan.retrofit_java.Remote.ProductService getProductService(){
        return com.adelia.nainggolan.retrofit_java.Remote.RetrofitClient.getClient(API_URL).create(com.adelia.nainggolan.retrofit_java.Remote.ProductService.class);
    }
}
