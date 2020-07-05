package com.tungx.demoapi.entity.dto;

import com.tungx.demoapi.entity.MonAnYeuThich;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

public class KhachHangDTO {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String ten;
    private String idLinked;

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

}
