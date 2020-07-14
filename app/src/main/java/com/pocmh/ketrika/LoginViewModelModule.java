package com.pocmh.ketrika;

import android.content.Context;

import com.pocmh.ketrika.repo.UserRepository;
import com.pocmh.ketrika.viewModel.LoginViewModel;
import com.pocmh.ketrika.viewModel.LoginViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class LoginViewModelModule {

    @Provides
    @Singleton
    UserRepository provideRepository(Context context) {
        return new UserRepository(context);
    }

    @Provides
    @Singleton
    LoginViewModel provideLoginViewModel(Context context) {
        return new LoginViewModel(new UserRepository(context));
    }

    @Provides
    @Singleton
    LoginViewModelFactory provideLoginViewModelFactory(Context context) {
        return new LoginViewModelFactory(new LoginViewModel(new UserRepository(context)));
    }
}
