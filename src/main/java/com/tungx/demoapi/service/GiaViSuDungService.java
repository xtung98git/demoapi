package com.tungx.demoapi.service;

import com.tungx.demoapi.entity.GiaViSuDung;

import java.util.List;
import java.util.Optional;

public interface GiaViSuDungService {
    List<GiaViSuDung> findAllGiaViSuDung();
    List<GiaViSuDung> findAllGiaViSuDungByMonAnId(Integer monAnId);
    GiaViSuDung findById(Integer id);
    void save(GiaViSuDung giaViSuDung);
    void remove(GiaViSuDung giaViSuDung);
}
