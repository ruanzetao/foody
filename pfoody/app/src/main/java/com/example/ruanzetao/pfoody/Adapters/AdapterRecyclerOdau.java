package com.example.ruanzetao.pfoody.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ruanzetao.pfoody.Model.BinhLuanModel;
import com.example.ruanzetao.pfoody.Model.QuanAnModel;
import com.example.ruanzetao.pfoody.R;
import com.example.ruanzetao.pfoody.View.ChiTietQuanAnActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.example.ruanzetao.pfoody.Model.ChiNhanhQuanAnModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterRecyclerOdau extends RecyclerView.Adapter<AdapterRecyclerOdau.ViewHolder> {

    List<QuanAnModel> quanAnModelList;
    int resource;
    Context context;

    public AdapterRecyclerOdau(Context context, List<QuanAnModel> quanAnModelList, int resource) {
        this.quanAnModelList = quanAnModelList;
        this.resource = resource;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTenQuanAnOdau, txtTieudebinhluan2, txtTieudebinhluan, txtNodungbinhluan2, txtNodungbinhluan, txtChamDiemBinhLuan, txtChamDiemBinhLuan2, txtTongBinhLuan, txtTongHinhBinhLuan, txtDiemTrungBinhQuanAn, txtDiaChiQuanAnODau, txtKhoanCachQuanAnODau;
        Button btnDatMonOdau;
        ImageView imageHinhQuanAnODau;
        CircleImageView cicleImageUser2, cicleImageUser;
        LinearLayout containerBinhLuan, containerBinhLuan2;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            txtTenQuanAnOdau = itemView.findViewById(R.id.txtTenQuanQuanOdau);
            btnDatMonOdau = (Button) itemView.findViewById(R.id.btnDatMonOdau);
            imageHinhQuanAnODau = (ImageView) itemView.findViewById(R.id.imageHinhQuanAnOdau);
            txtNodungbinhluan = (TextView) itemView.findViewById(R.id.txtNodungbinhluan);
            txtNodungbinhluan2 = (TextView) itemView.findViewById(R.id.txtNodungbinhluan2);
            txtTieudebinhluan = (TextView) itemView.findViewById(R.id.txtTieudebinhluan);
            txtTieudebinhluan2 = (TextView) itemView.findViewById(R.id.txtTieudebinhluan2);
            cicleImageUser = (CircleImageView) itemView.findViewById(R.id.cicleImageUser);
            cicleImageUser2 = (CircleImageView) itemView.findViewById(R.id.cicleImageUser2);
            containerBinhLuan = (LinearLayout) itemView.findViewById(R.id.containerBinhLuan);
            containerBinhLuan2 = (LinearLayout) itemView.findViewById(R.id.containerBinhLuan2);
            txtChamDiemBinhLuan = (TextView) itemView.findViewById(R.id.txtChamDiemBinhLuan);
            txtChamDiemBinhLuan2 = (TextView) itemView.findViewById(R.id.txtChamDiemBinhLuan2);
            txtTongBinhLuan = (TextView) itemView.findViewById(R.id.txtTongBinhLuan);
            txtTongHinhBinhLuan = (TextView) itemView.findViewById(R.id.txtTongHinhBinhLuan);
            txtDiemTrungBinhQuanAn = (TextView) itemView.findViewById(R.id.txtDiemTrungBinhQuanAn);
            txtDiaChiQuanAnODau = (TextView) itemView.findViewById(R.id.txtDiaChiQuanAnODau);
            txtKhoanCachQuanAnODau = (TextView) itemView.findViewById(R.id.txtKhoangCachQuanAnODau);
            cardView = (CardView) itemView.findViewById(R.id.cardViewOdau);

        }
    }

    @NonNull
    @Override
    public AdapterRecyclerOdau.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterRecyclerOdau.ViewHolder holder, int position) {

        final QuanAnModel quanAnModel = quanAnModelList.get(position);
        holder.txtTenQuanAnOdau.setText(quanAnModel.getTenquanan());
        if (quanAnModel.isGiaohang()) {
            holder.btnDatMonOdau.setVisibility(View.VISIBLE);
        }

        if(quanAnModel.getBitmapList().size() > 0){
            holder.imageHinhQuanAnODau.setImageBitmap(quanAnModel.getBitmapList().get(0));
        }
        //Lấy danh sách bình luận của quán ăn
        if (quanAnModel.getBinhLuanModelList().size() > 0) {

            BinhLuanModel binhLuanModel = quanAnModel.getBinhLuanModelList().get(0);
            holder.txtTieudebinhluan.setText(binhLuanModel.getTieude());
            holder.txtNodungbinhluan.setText(binhLuanModel.getNoidung());
            holder.txtChamDiemBinhLuan.setText(binhLuanModel.getChamdiem() + "");
//            setHinhAnhBinhLuan(holder.cicleImageUser,binhLuanModel.getThanhVienModel().getHinhanh());
//            Log.d("kiemtraadapterhinhanh",binhLuanModel.getMauser()+"");
            if (quanAnModel.getBinhLuanModelList().size() > 2) {
                BinhLuanModel binhLuanModel2 = quanAnModel.getBinhLuanModelList().get(1);
                holder.txtTieudebinhluan2.setText(binhLuanModel2.getTieude());
                holder.txtNodungbinhluan2.setText(binhLuanModel2.getNoidung());
                holder.txtChamDiemBinhLuan2.setText(binhLuanModel2.getChamdiem() + "");
//                setHinhAnhBinhLuan(holder.cicleImageUser2, binhLuanModel2.getThanhVienModel().getHinhanh());
//                Log.d("kiemtraadapterhinhanh2",binhLuanModel.getMauser()+"");
            }
            holder.txtTongBinhLuan.setText(quanAnModel.getBinhLuanModelList().size() + "");

            int tongsohinhbinhluan = 0;
            double tongdiem = 0;
            //Tính tổng điểm trung bình của bình luận và đếm tổng số hình của bình luận
            for (BinhLuanModel binhLuanModel1 : quanAnModel.getBinhLuanModelList()) {
                tongsohinhbinhluan += binhLuanModel1.getHinhanhBinhLuanList().size();
                tongdiem += binhLuanModel1.getChamdiem();
            }

            double diemtrungbinh = tongdiem / quanAnModel.getBinhLuanModelList().size();
            holder.txtDiemTrungBinhQuanAn.setText(String.format("%.1f", diemtrungbinh));

            if (tongsohinhbinhluan > 0) {
                holder.txtTongHinhBinhLuan.setText(tongsohinhbinhluan + "");
            }

        } else {
            holder.containerBinhLuan.setVisibility(View.GONE);
            holder.containerBinhLuan2.setVisibility(View.GONE);
        }

        //Lấy chi nhánh quán ăn và hiển thị địa chỉ và km
        if (quanAnModel.getChiNhanhQuanAnModelList().size() > 0) {
            ChiNhanhQuanAnModel chiNhanhQuanAnModelTam = quanAnModel.getChiNhanhQuanAnModelList().get(0);
            for (ChiNhanhQuanAnModel chiNhanhQuanAnModel : quanAnModel.getChiNhanhQuanAnModelList()) {
                if (chiNhanhQuanAnModelTam.getKhoangcach() > chiNhanhQuanAnModel.getKhoangcach()) {
                    chiNhanhQuanAnModelTam = chiNhanhQuanAnModel;
                }
            }

            holder.txtDiaChiQuanAnODau.setText(chiNhanhQuanAnModelTam.getDiachi());
            holder.txtKhoanCachQuanAnODau.setText(String.format("%.1f", chiNhanhQuanAnModelTam.getKhoangcach()) + " km");
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent iChiTietQuanAn = new Intent(context, ChiTietQuanAnActivity.class);
                Log.d("quananmodelgetbug",context.getPackageName()+"");
                iChiTietQuanAn.putExtra("quanan",quanAnModel);
                Log.d("quananmodelgetbug2",quanAnModel.getTenquanan()+"");
                context.startActivity(iChiTietQuanAn);
                Log.d("kiemtraactivity",iChiTietQuanAn.getDataString()+"");

            }
        });

    }


    private void setHinhAnhBinhLuan(final CircleImageView circleImageView, String linkhinh) {
        StorageReference storageHinhUser = FirebaseStorage.getInstance().getReference().child("thanhvien").child(linkhinh);
        long ONE_MEGABYTE = 1024 * 1024;
        storageHinhUser.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                circleImageView.setImageBitmap(bitmap);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quanAnModelList.size();
    }


}
