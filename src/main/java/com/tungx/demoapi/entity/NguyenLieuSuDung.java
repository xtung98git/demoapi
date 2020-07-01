package com.tungx.demoapi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tblnguyenlieusudung")
public class NguyenLieuSuDung implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nguyenlieu_id")
    private NguyenLieu nguyenLieu;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "monan_id")
    private MonAn monAn;
    @Column(name = "soLuong")
    private Integer soLuong;

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

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }

}
