package com.example.mvvmrecyclerview;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainVM extends ViewModel {

    public String name = "";
    public String realname = "";
    public String team = "";
    public String firstappearance = "";
    public String createdby = "";
    public String publisher = "";
    public String imageurl = "";

    public MutableLiveData<ArrayList<MainVM>> arrayListMutableLiveData = new MutableLiveData<>();

    public String imageUrl()
    {
        return imageurl;
    }


    @BindingAdapter("bind:imageUrl")

    public static void loadImage(ImageView imageView, String imageUrl)
    {
        Picasso.get().load(imageUrl).placeholder(R.drawable.user).into(imageView);
    }

    public MainVM() {

        HeroRepository heroRepository = new HeroRepository();
        arrayListMutableLiveData = heroRepository.getArrayListMutableLiveData();

    }

    public MainVM(HeroPojo heroPojo) {
        this.name = heroPojo.name;
        this.realname = heroPojo.realname;
        this.team = heroPojo.team;
        this.firstappearance = heroPojo.firstappearance;
        this.createdby = heroPojo.createdby;
        this.publisher = heroPojo.publisher;
        this.imageurl = heroPojo.imageurl;
    }

    public MutableLiveData<ArrayList<MainVM>> getArrayListMutableLiveData() {

        return arrayListMutableLiveData;
    }
}
