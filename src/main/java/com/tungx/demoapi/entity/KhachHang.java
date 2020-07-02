package com.tungx.demoapi.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tblkhachhang")
public class KhachHang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "idLinked", unique = true)
    private String idLinked;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "monanyeuthich_id")
    List<MonAnYeuThich> monAnYeuThichList;

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

    public String getIdLinked() {
        return idLinked;
    }

    public void setIdLinked(String idLinked) {
        this.idLinked = idLinked;
    }

    public List<MonAnYeuThich> getMonAnYeuThichList() {
        return monAnYeuThichList;
    }

    public void setMonAnYeuThichList(List<MonAnYeuThich> monAnYeuThichList) {
        this.monAnYeuThichList = monAnYeuThichList;
    }
}
