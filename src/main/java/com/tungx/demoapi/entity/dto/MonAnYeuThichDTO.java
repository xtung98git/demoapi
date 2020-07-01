package com.tungx.demoapi.entity.dto;

import com.tungx.demoapi.entity.KhachHang;
import com.tungx.demoapi.entity.MonAn;

import java.io.Serializable;
import java.util.Date;

public class MonAnYeuThichDTO implements Serializable {
    private static final long serialVersionUID = 2L;

    private Integer id;
    private Date day;
    private MonAn monAn;
    private KhachHang khachHang;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public MonAn getMonAn() {
        return monAn;
    }

    public void setMonAn(MonAn monAn) {
        this.monAn = monAn;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
