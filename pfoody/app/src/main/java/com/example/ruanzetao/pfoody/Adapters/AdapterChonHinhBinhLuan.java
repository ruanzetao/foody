package com.example.ruanzetao.pfoody.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.example.ruanzetao.pfoody.Model.ChonHinhBinhLuanModel;
import com.example.ruanzetao.pfoody.R;

import java.util.List;

public class AdapterChonHinhBinhLuan extends RecyclerView.Adapter<AdapterChonHinhBinhLuan.ViewHolderChonHinh> {

    Context context;
    int resource;
    List<ChonHinhBinhLuanModel> listDuongDan;

    public  AdapterChonHinhBinhLuan(Context context,int resource,List<ChonHinhBinhLuanModel> listDuongDan){
        this.context = context;
        this.resource = resource;
        this.listDuongDan = listDuongDan;
    }
    @NonNull
    @Override
    public AdapterChonHinhBinhLuan.ViewHolderChonHinh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);

        ViewHolderChonHinh viewHolderChonHinh = new ViewHolderChonHinh(view);
        return viewHolderChonHinh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterChonHinhBinhLuan.ViewHolderChonHinh holder, final int position) {

        final ChonHinhBinhLuanModel chonHinhBinhLuanModel = listDuongDan.get(position);
        Uri uri = Uri.parse(chonHinhBinhLuanModel.getDuongdan());
        holder.imageView.setImageURI(uri);
        holder.checkBox.setChecked(chonHinhBinhLuanModel.isCheck());
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = (CheckBox) v;
                listDuongDan.get(position).setCheck(checkBox.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderChonHinh extends RecyclerView.ViewHolder {
        ImageView imageView;
        CheckBox checkBox;

        public ViewHolderChonHinh(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imgChonHinhBinhLuan);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBoxChonHinhBinhLuan);

        }
    }
}
