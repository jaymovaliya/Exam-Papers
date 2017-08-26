package com.example.acer.exampapers;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 7/9/2017.
 */

public class SemesterOneComputer extends AppCompatActivity {

    private List<Branch> SemesterList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BranchAdapter branchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //final PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
        branchAdapter = new BranchAdapter(SemesterList);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SemesterOneComputer.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(branchAdapter);
        addSubjectData();
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new MainActivity.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                switch (position) {
                    case 0: {
                        try{
                            Toast.makeText(getBaseContext(), "Opening PDF... ", Toast.LENGTH_SHORT).show();
                            Intent inte = new Intent(Intent.ACTION_VIEW,Uri.parse("http://192.168.0.61/test/cirti.pdf"));
                            /*inte.setDataAndType(
                                    Uri.parse("http://192.168.0.61/test/cirti.pdf"),
                                    "application/pdf");*/

                            startActivity(inte);
                        }catch(ActivityNotFoundException e){
                            Log.e("Viewer not installed.", e.getMessage());
                        }
                        break;
                    }
                }
            }
        }));
    }
    public void addSubjectData(){
        Branch branch_obj = new Branch("Calculus");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Fundamental of Electronics");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("EME");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Engineering Physics");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Communication Skills");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Computer Workshop");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Electronics Workshop");
        SemesterList.add(branch_obj);
    }
}



