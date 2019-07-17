package com.mycode.jpmc.di;

import com.mycode.jpmc.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

//moudle is for injecting dependencies into the activities
@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector()
    abstract MainActivity contributesMainActivity();


}
