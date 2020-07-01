package com.tungx.demoapi.service;

import com.tungx.demoapi.entity.NguyenLieuSuDung;

import java.util.List;
import java.util.Optional;

public interface NguyenLieuSuDungService {
    List<NguyenLieuSuDung> findAllNguyenLieuSuDung();
    List<NguyenLieuSuDung> findAllNguyenLieuSuDungByMonAnId(Integer monAnId);
    NguyenLieuSuDung findById(Integer id);
    void save(NguyenLieuSuDung nguyenLieuSuDung);
    void remove(NguyenLieuSuDung nguyenLieuSuDung);
}
