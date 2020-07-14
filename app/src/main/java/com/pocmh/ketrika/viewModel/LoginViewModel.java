package com.pocmh.ketrika.viewModel;

import android.content.Context;
import android.support.v4.os.IResultReceiver;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.pocmh.ketrika.MainActivity;
import com.pocmh.ketrika.Result;
import com.pocmh.ketrika.models.User;
import com.pocmh.ketrika.repo.UserRepository;

import java.net.ContentHandler;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;


public class LoginViewModel extends ViewModel {

    private Observable<Result> result;

    private UserRepository userRepository;

    public LoginViewModel() {

    }

    @Inject
    public LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void login(String username, String password) {
        result = Observable.just(new Result("validé"));
    }

    public Observable<Result> getResult() {
        return result;
    }

}
