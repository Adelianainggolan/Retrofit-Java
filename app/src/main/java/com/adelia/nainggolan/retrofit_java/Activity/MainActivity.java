package com.adelia.nainggolan.retrofit_java.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.adelia.nainggolan.retrofit_java.Adapter.ProductAdapter;
import com.adelia.nainggolan.retrofit_java.Model.PersonItem;
import com.adelia.nainggolan.retrofit_java.R;
import com.adelia.nainggolan.retrofit_java.Remote.APIUtils;
import com.adelia.nainggolan.retrofit_java.Remote.ProductService;

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
    List<PersonItem> list = new ArrayList<PersonItem>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddUser = findViewById(R.id.btn_addUser);
        btnGetUser = findViewById(R.id.btn_getUserList);
        rv = findViewById(R.id.rv_main);
        productService = APIUtils.getProductService();

        btnAddUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                intent.putExtra("name","");
                intent.putExtra("price","");
                intent.putExtra("desc", "");
                startActivity(intent);
            }
        });

        btnGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserList();
            }
        });
    }

    public void getUserList() {
        Call<List<PersonItem>> call = productService.getProduct();
        call.enqueue(new Callback<List<PersonItem>>() {
            @Override
            public void onResponse(Call<List<PersonItem>> call, Response<List<PersonItem>> response) {
                if (response.isSuccessful()){
                    list = response.body();
                    rv.setAdapter(new ProductAdapter(MainActivity.this, R.layout.list_item,list));
                }
            }

            @Override
            public void onFailure(Call<List<PersonItem>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}