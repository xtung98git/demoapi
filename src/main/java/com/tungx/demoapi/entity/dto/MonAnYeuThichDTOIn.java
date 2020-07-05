package com.tungx.demoapi.entity.dto;

import com.tungx.demoapi.entity.KhachHang;
import com.tungx.demoapi.entity.MonAn;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class MonAnYeuThichDTOIn {
    private Integer idMonAn;
    private Integer idKhachHang;
    private Date day;

    public Integer getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(Integer idMonAn) {
        this.idMonAn = idMonAn;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
