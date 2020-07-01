package com.tungx.demoapi.service;

import com.tungx.demoapi.entity.ChuyenMuc;

import java.util.List;

public interface ChuyenMucService {
    List<ChuyenMuc> findAllChuyenMuc();
    ChuyenMuc findById(Integer id);
    void save(ChuyenMuc chuyenMuc);
    void remove(ChuyenMuc chuyenMuc);
}
