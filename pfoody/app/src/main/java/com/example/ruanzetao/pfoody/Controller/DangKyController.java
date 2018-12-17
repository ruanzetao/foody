package com.example.ruanzetao.pfoody.Controller;

import com.example.ruanzetao.pfoody.Model.ThanhVienModel;

public class DangKyController {
    ThanhVienModel thanhVienModel;

    public DangKyController(){
        thanhVienModel = new ThanhVienModel();

    }

    public void ThemThongTinThanhVienController(ThanhVienModel thanhVienModel,String uid){
        thanhVienModel.ThemThongTinThanhVien(thanhVienModel,uid);
    }
}
