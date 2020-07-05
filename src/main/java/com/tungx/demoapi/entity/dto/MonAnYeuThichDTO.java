package com.tungx.demoapi.entity.dto;

import com.tungx.demoapi.entity.KhachHang;
import com.tungx.demoapi.entity.MonAn;

import java.io.Serializable;
import java.util.Date;

public class MonAnYeuThichDTO implements Serializable {
    private static final long serialVersionUID = 2L;

    private MonAn monAn;

    public MonAn getMonAn() {
        return monAn;
    }

    public void setMonAn(MonAn monAn) {
        this.monAn = monAn;
    }
}
