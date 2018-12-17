package com.example.ruanzetao.pfoody.View;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ruanzetao.pfoody.Adapters.AdapterViewPagerTrangChu;
import com.example.ruanzetao.pfoody.R;

public class TrangChuActivity extends AppCompatActivity implements
        ViewPager.OnPageChangeListener,
        RadioGroup.OnCheckedChangeListener {
    ViewPager viewPagerTrangChu;
    RadioButton rdOdau,rdAngi;
    RadioGroup groupOdauAngi;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_trangchu);

        viewPagerTrangChu = (ViewPager) findViewById(R.id.viewpager_trangchu);

        rdOdau = (RadioButton) findViewById(R.id.rd_odau);
        rdAngi = (RadioButton) findViewById(R.id.rd_angi);

        groupOdauAngi = (RadioGroup) findViewById(R.id.group_odau_angi);

        AdapterViewPagerTrangChu adapterViewPagerTrangChu =
                new AdapterViewPagerTrangChu(getSupportFragmentManager());
        viewPagerTrangChu.setAdapter(adapterViewPagerTrangChu);

        viewPagerTrangChu.addOnPageChangeListener(this);
        groupOdauAngi.setOnCheckedChangeListener(this);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                rdOdau.setChecked(true);
                break;

            case 1:
                rdAngi.setChecked(true);
                break;

        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rd_angi:
                viewPagerTrangChu.setCurrentItem(1);
                break;

            case R.id.rd_odau:
                viewPagerTrangChu.setCurrentItem(0);
                break;
        }
    }
}
