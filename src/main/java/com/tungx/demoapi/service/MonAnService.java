package com.tungx.demoapi.service;

import com.tungx.demoapi.entity.MonAn;

import java.util.List;
import java.util.Optional;

public interface MonAnService {
    List<MonAn> findAllMonAn();
    List<MonAn> findAllMonAnByChuyenMucId(Integer chuyenMucId);
    List<MonAn> findAllMonAnByName(String name);
    MonAn findById(Integer id);
    void save(MonAn nguyenLieu);
    void remove(MonAn nguyenLieu);
}
