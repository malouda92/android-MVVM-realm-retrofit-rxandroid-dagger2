package com.pocmh.ketrika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.pocmh.ketrika.viewModel.LoginViewModel;
import com.pocmh.ketrika.viewModel.LoginViewModelFactory;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    LoginViewModelFactory loginViewModelFactory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginViewComponent loginViewModelFactoryComponent = DaggerLoginViewComponent.builder().withContext(this).build();
        loginViewModelFactoryComponent.inject(this);

        LoginViewModel loginViewModel = new ViewModelProvider(this, loginViewModelFactory).get(LoginViewModel.class);

        //loginViewModel.getUserRepository().Persist(new User("RLM92", "RAMA92", "RAMANANDAFY Lova Mialy", "Malouda92", "+261342833581", "ramalomi@gmail.com", "Mg"));
        loginViewModel.login("RAMA92", "Malouda92");

        loginViewModel.getResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Result result) {
                        Log.e("TAG", "onNext: " + result.getResultat());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}