package com.tungx.demoapi.entity.dto;

import com.tungx.demoapi.entity.ChuyenMuc;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MonAnDTO {
    private Integer id;
    private String ten;
    private String moTa;
    private String congThuc;
    private Integer soNguoi;
    private ChuyenMuc chuyenMuc;
    private String urlAnh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getCongThuc() {
        return congThuc;
    }

    public void setCongThuc(String congThuc) {
        this.congThuc = congThuc;
    }

    public Integer getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(Integer soNguoi) {
        this.soNguoi = soNguoi;
    }

    public ChuyenMuc getChuyenMuc() {
        return chuyenMuc;
    }

    public void setChuyenMuc(ChuyenMuc chuyenMuc) {
        this.chuyenMuc = chuyenMuc;
    }

    public String getUrlAnh() {
        return urlAnh;
    }

    public void setUrlAnh(String urlAnh) {
        this.urlAnh = urlAnh;
    }
}
