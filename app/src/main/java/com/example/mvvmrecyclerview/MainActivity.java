package com.example.mvvmrecyclerview;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mvvmrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainVM mainVM;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMain(mainVM);

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));


        mainVM = ViewModelProviders.of(this).get(MainVM.class);

        mainVM.getArrayListMutableLiveData().observe(this, new Observer<ArrayList<MainVM>>() {
            @Override
            public void onChanged(@Nullable ArrayList<MainVM> mainVMS) {

                mainAdapter = new MainAdapter(MainActivity.this, mainVMS);
                binding.recyclerView.setAdapter(mainAdapter);


            }
        });
    }
}
