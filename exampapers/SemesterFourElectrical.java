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

public class SemesterFourElectrical extends AppCompatActivity {

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
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SemesterFourElectrical.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(branchAdapter);
        addSubjectData();
    }
    public void addSubjectData(){
        Branch branch_obj = new Branch("ElectroMagnetic Field Theory");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Digital Electronics");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("DC Machine & Transformer");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Power Electronics-1");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Numerical Methods");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Economics & Management");
        SemesterList.add(branch_obj);
    }
}




