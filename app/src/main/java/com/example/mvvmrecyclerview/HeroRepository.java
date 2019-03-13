package com.example.mvvmrecyclerview;

import android.arch.lifecycle.MutableLiveData;
import java.util.ArrayList;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HeroRepository {

    private MutableLiveData<ArrayList<MainVM>> arrayListMutableLiveData = new MutableLiveData<>();
    private ArrayList<MainVM> arrayList;

    public HeroRepository() {
    }

    public MutableLiveData<ArrayList<MainVM>> getArrayListMutableLiveData() {

        ApiService apiService = RetrofitClient.getApiService();

        Observable<ArrayList<HeroPojo>> observable = apiService.getHeros()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(new Observer<ArrayList<HeroPojo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<HeroPojo> heroPojos) {

                MainVM mainVM;
                HeroPojo heroPojo;

                arrayList = new ArrayList<>();

                for (int i = 0; i<heroPojos.size(); i++)
                {
                    heroPojo = new HeroPojo(
                            heroPojos.get(i).getName(),
                            heroPojos.get(i).getRealname(),
                            heroPojos.get(i).getTeam(),
                            heroPojos.get(i).getFirstappearance(),
                            heroPojos.get(i).getCreatedby(),
                            heroPojos.get(i).getPublisher(),
                            heroPojos.get(i).getImageurl()
                    );
                    mainVM = new MainVM(heroPojo);
                    arrayList.add(mainVM);
                }


                arrayListMutableLiveData.setValue(arrayList);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        return arrayListMutableLiveData;
    }


   }
