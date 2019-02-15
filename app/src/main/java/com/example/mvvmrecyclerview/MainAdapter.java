package com.example.mvvmrecyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mvvmrecyclerview.databinding.MainAdapterBinding;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private Context context;
    private ArrayList<MainVM> arrayList;
    private LayoutInflater layoutInflater;

    public MainAdapter(Context context, ArrayList<MainVM> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (layoutInflater == null)
        {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        MainAdapterBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.inner_layout, viewGroup, false);

        return new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {

        MainVM mainVM = arrayList.get(i);
        mainViewHolder.bind(mainVM);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{

        private MainAdapterBinding binding;


        public MainViewHolder(@NonNull MainAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void bind(MainVM mainVM)
        {
            this.binding.setAdapterMain(mainVM);
            binding.executePendingBindings();
        }

        public MainAdapterBinding getBinding()
        {
            return binding;
        }
    }
}
