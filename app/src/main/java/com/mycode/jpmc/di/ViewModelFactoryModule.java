package com.mycode.jpmc.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.mycode.jpmc.ui.MainViewModel;
import com.mycode.jpmc.viewmodel.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

//this is where the dependencies for viewmodelproviderfactory or any viewmodels is
@Module
public abstract class ViewModelFactoryModule {

    //dependency for viewmodelproviderfactory
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);
}
