package com.tungx.demoapi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tblnguyenlieu")
public class NguyenLieu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="ten")
    private String ten;
    @Column(name="donVi")
    private String donVi;
    @Column(name="moTa")
    private String moTa;
    @Column(name="gia")
    private Long gia;

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

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }
}
