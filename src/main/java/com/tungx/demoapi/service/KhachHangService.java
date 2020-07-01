package com.tungx.demoapi.service;

import com.tungx.demoapi.entity.KhachHang;

import java.util.List;
import java.util.Optional;

public interface KhachHangService {
    List<KhachHang> findAllKhachHang();
    KhachHang findById(Integer id);
    void save(KhachHang khachHang);
    void remove(KhachHang khachHang);
}
