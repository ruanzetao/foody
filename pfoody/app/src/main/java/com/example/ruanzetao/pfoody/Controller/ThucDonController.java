package com.example.ruanzetao.pfoody.Controller;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ruanzetao.pfoody.Adapters.AdapterThucDon;
import com.example.ruanzetao.pfoody.Controller.Interfaces.ThucDonInterface;
import com.example.ruanzetao.pfoody.Model.ThucDonModel;

import java.util.List;

public class ThucDonController {
    ThucDonModel thucDonModel;

    public ThucDonController(){

        thucDonModel = new ThucDonModel();
    }

    public void getDanhSachThucDonQuanAnTheoMa(final Context context, String manquanan, final RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        ThucDonInterface thucDonInterface = new ThucDonInterface() {
            @Override
            public void getThucDonThanhCong(List<ThucDonModel> thucDonModelList) {
                AdapterThucDon adapterThucDon = new AdapterThucDon(context,thucDonModelList);

                Log.d("ktthucdoncontroller",adapterThucDon.getItemCount()+"");
                recyclerView.setAdapter(adapterThucDon);
                Log.d("ktrvthucdon",recyclerView.getTransitionName()+"");
                adapterThucDon.notifyDataSetChanged();
            }
        };
        thucDonModel.getDanhSachThucDonQuanAnTheoMa(manquanan,thucDonInterface);
    }
}
