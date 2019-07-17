package com.mycode.jpmc;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mycode.jpmc.adapter.RecyclerViewAdapter;
import com.mycode.jpmc.entity.HighSchools;
import com.mycode.jpmc.entity.SATResults;
import com.mycode.jpmc.ui.MainViewModel;
import com.mycode.jpmc.viewmodel.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends DaggerAppCompatActivity implements RecyclerViewAdapter.OnItemClickListener{

    private final CompositeDisposable mDisposable = new CompositeDisposable();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private MainViewModel viewModel;
    private List<HighSchools> schools;
    private List<SATResults> results;
    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel = ViewModelProviders.of(this, providerFactory).get(MainViewModel.class);
        viewModel.HighSchoolAPICall().observe(this, new Observer<List<HighSchools>>() {
            @Override
            public void onChanged(List<HighSchools> highSchools) {
                schools = highSchools;
                adapter = new RecyclerViewAdapter(getApplicationContext(),schools);
                recyclerView.setAdapter(adapter);
                adapter.setOnItemClickListener(MainActivity.this);

            }
        });
        viewModel.SATResultsAPICall().observe(this, new Observer<List<SATResults>>() {
            @Override
            public void onChanged(List<SATResults> satResults) {
                results = satResults;
            }
        });
    }


    @Override
    public void itemClick(int position) {
        String dbn = schools.get(position).getDbn();
        for(int i=0; i<results.size(); i++){
            if(dbn.equals(results.get(i).getDbn())){
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("SAT Results")
                        .setMessage("Number of Test Takers: " + results.get(i).getTestTakers()+"\n"+"\n"
                        + "Average Math Score: " +results.get(i).getAvgMath()+"\n"+"\n"
                        + "Average Reading Score: " +results.get(i).getAvgReading()+"\n"+"\n"
                        + "Average Writing Score: " + results.get(i).getAvgWriting()
                        ).create();
                dialog.show();
            }
        }
    }
}
