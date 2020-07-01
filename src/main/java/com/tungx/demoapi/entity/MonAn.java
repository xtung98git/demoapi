package com.tungx.demoapi.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tblmonan")
public class MonAn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "moTa")
    private String moTa;
    @Column(name = "congThuc")
    private String congThuc;
    @Column(name = "soNguoi")
    private Integer soNguoi;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chuyenmuc_id")
    private ChuyenMuc chuyenMuc;
    @Column(name = "tenFileAnh")
    private  String tenFileAnh;
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

    public String getTenFileAnh() {
        return tenFileAnh;
    }

    public void setTenFileAnh(String tenFileAnh) {
        this.tenFileAnh = tenFileAnh;
    }


}
