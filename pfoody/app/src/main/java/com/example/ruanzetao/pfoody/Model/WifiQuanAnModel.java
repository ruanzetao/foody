package com.example.ruanzetao.pfoody.Model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.ruanzetao.pfoody.Controller.Interfaces.ChiTietQuanAnInterface;
import com.example.ruanzetao.pfoody.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WifiQuanAnModel {
    String ten,matkhau,ngaydang;

    public WifiQuanAnModel(){

    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getNgaydang() {
        return ngaydang;
    }

    public void setNgaydang(String ngaydang) {
        this.ngaydang = ngaydang;
    }


    private DatabaseReference nodeWifiQuanAn;

    public void LayDanhSachWifiQuanAn(String maquan, final ChiTietQuanAnInterface chiTietQuanAnInterface){
        nodeWifiQuanAn = FirebaseDatabase.getInstance().getReference().child("wifiquanans").child(maquan);

        nodeWifiQuanAn.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot valueWifi : dataSnapshot.getChildren()){
                    WifiQuanAnModel wifiQuanAnModel = valueWifi.getValue(WifiQuanAnModel.class);
                    chiTietQuanAnInterface.HienThiDanhSachWifi(wifiQuanAnModel);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }

    public void ThemWifiQuanAn(final Context context, WifiQuanAnModel wifiQuanAnModel, String maquanan){
        DatabaseReference dataNodeWifiQuanAn = FirebaseDatabase.getInstance().getReference().child("wifiquanans").child(maquanan);
        dataNodeWifiQuanAn.push().setValue(wifiQuanAnModel, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                Toast.makeText(context,context.getResources().getString(R.string.themthanhcong),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
