package com.pocmh.ketrika;

import android.content.Context;

import com.pocmh.ketrika.viewModel.LoginViewModelFactory;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {LoginViewModelModule.class})
interface LoginViewComponent {

    LoginViewModelFactory provideLoginViewModelFactory();

    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder withContext(Context context);

        LoginViewComponent build();

    }
}
