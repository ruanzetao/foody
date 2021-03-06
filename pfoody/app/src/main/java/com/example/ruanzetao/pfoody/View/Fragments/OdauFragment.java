package com.example.ruanzetao.pfoody.View.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.ruanzetao.pfoody.Controller.OdauController;
import com.example.ruanzetao.pfoody.Model.QuanAnModel;
import com.example.ruanzetao.pfoody.R;

import java.util.List;

public class OdauFragment extends Fragment {
    OdauController odauController;
    RecyclerView recyclerOdau;
    ProgressBar progressBar;
    SharedPreferences sharedPreferences;
    NestedScrollView nestedScrollView;
    QuanAnModel quanAnModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_fragment_odau,container,false);
        recyclerOdau = (RecyclerView) view.findViewById(R.id.recyclerOdau);

        progressBar = (ProgressBar) view.findViewById(R.id.progressBarODau);
        nestedScrollView = (NestedScrollView) view.findViewById(R.id.nestScrollViewODau);

        sharedPreferences = getContext().getSharedPreferences("toado", Context.MODE_PRIVATE);

        Location vitrihientai = new Location("");
        vitrihientai.setLatitude(Double.parseDouble(sharedPreferences.getString("latitude","0")));
        vitrihientai.setLongitude(Double.parseDouble(sharedPreferences.getString("longitude","0")));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        sharedPreferences = getContext().getSharedPreferences("toado", Context.MODE_PRIVATE);

        Location vitrihientai = new Location("");
        vitrihientai.setLatitude(Double.parseDouble(sharedPreferences.getString("latitude","0")));
        vitrihientai.setLongitude(Double.parseDouble(sharedPreferences.getString("longitude","0")));

        odauController=new OdauController(getContext());
        //Log.d("kiemtratoado",sharedPreferences.getString("latitude", String.valueOf(0))+"");
        odauController.getDanhSachQuanAnController(getContext(),nestedScrollView,recyclerOdau,progressBar,vitrihientai);
    }
}
