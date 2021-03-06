package com.example.ruanzetao.pfoody.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruanzetao.pfoody.Model.ThucDonModel;
import com.example.ruanzetao.pfoody.R;

import java.util.List;

public class AdapterThucDon extends RecyclerView.Adapter<AdapterThucDon.HolderThucDon> {

    Context context;
    List<ThucDonModel> thucDonModels;

    public AdapterThucDon(Context context, List<ThucDonModel> thucDonModels){
        this.context = context;
        this.thucDonModels = thucDonModels;
    }

    @Override
    public AdapterThucDon.HolderThucDon onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_layout_thucdon,parent,false);
        return new HolderThucDon(view);
    }

    @Override
    public void onBindViewHolder(AdapterThucDon.HolderThucDon holder, int position) {
        ThucDonModel thucDonModel = thucDonModels.get(position);
        holder.txtThucDon.setText(thucDonModel.getTenthucdon());
        holder.recyclerViewMonAn.setLayoutManager(new LinearLayoutManager(context));
        AdapterMonAn adapterMonAn = new AdapterMonAn(context,thucDonModel.getMonAnModelList());
        //Log.d("kiemtraadaptertd",adapterMonAn.getItemCount()+"");
        holder.recyclerViewMonAn.setAdapter(adapterMonAn);
        adapterMonAn.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return thucDonModels.size();
    }

    public class HolderThucDon extends RecyclerView.ViewHolder {
        TextView txtThucDon;
        RecyclerView recyclerViewMonAn;
        public HolderThucDon(View itemView) {
            super(itemView);

            txtThucDon = (TextView) itemView.findViewById(R.id.txtTenThucDon);
            recyclerViewMonAn = (RecyclerView) itemView.findViewById(R.id.recyclerMonAn);
        }
    }
}

