package com.example.acer.exampapers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 7/9/2017.
 */

public class SemesterOneElectrical extends AppCompatActivity {

    private List<Branch> SemesterList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BranchAdapter branchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        branchAdapter = new BranchAdapter(SemesterList);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SemesterOneElectrical.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(branchAdapter);
        addSubjectData();
    }
    public void addSubjectData(){
        Branch branch_obj = new Branch("Calculus");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Basic Civil Engineering");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Electrical Workshop");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Engineering Physics");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("EME");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Communication Skills");
        SemesterList.add(branch_obj);
    }
}


