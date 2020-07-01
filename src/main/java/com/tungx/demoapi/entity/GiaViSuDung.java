package com.tungx.demoapi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tblgiavisudung")
public class GiaViSuDung implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "soLuong")
    private Integer soLuong;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "giavi_id")
    private GiaVi giaVi;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "monan_id")
    private MonAn monAn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }


    public GiaVi getGiaVi() {
        return giaVi;
    }

    public void setGiaVi(GiaVi giaVi) {
        this.giaVi = giaVi;
    }

    public MonAn getMonAn() {
        return monAn;
    }

    public void setMonAn(MonAn monAn) {
        this.monAn = monAn;
    }
}
