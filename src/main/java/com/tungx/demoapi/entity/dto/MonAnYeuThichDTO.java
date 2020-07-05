package com.tungx.demoapi.entity.dto;

import com.tungx.demoapi.entity.KhachHang;
import com.tungx.demoapi.entity.MonAn;

import java.io.Serializable;
import java.util.Date;

public class MonAnYeuThichDTO implements Serializable {
    private static final long serialVersionUID = 2L;

    private Integer id;
    private Date day;
    private int idMonAn;
    private String tenMonAn;
    private String urlAnhMonAn;
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

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public String getUrlAnhMonAn() {
        return urlAnhMonAn;
    }

    public void setUrlAnhMonAn(String urlAnhMonAn) {
        this.urlAnhMonAn = urlAnhMonAn;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
