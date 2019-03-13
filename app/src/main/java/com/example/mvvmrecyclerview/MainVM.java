package com.example.mvvmrecyclerview;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainVM extends ViewModel {

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> realname = new ObservableField<>();
    public ObservableField<String> team = new ObservableField<>();
    public ObservableField<String> firstappearance = new ObservableField<>();
    public ObservableField<String> createdby = new ObservableField<>();
    public ObservableField<String> publisher = new ObservableField<>();
    public ObservableField<String> imageurl = new ObservableField<>();



    public MutableLiveData<ArrayList<MainVM>> arrayListMutableLiveData = new MutableLiveData<>();

    public ObservableField<String> imageUrl()
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

        this.name.set(heroPojo.getName());
        this.realname.set(heroPojo.getRealname());
        this.team.set(heroPojo.getTeam());
        this.firstappearance.set(heroPojo.getFirstappearance());
        this.createdby.set(heroPojo.getCreatedby());
        this.publisher.set(heroPojo.getPublisher());
        this.imageurl.set(heroPojo.getImageurl());
    }

    public MutableLiveData<ArrayList<MainVM>> getArrayListMutableLiveData() {

        return arrayListMutableLiveData;
    }
}
