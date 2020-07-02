package com.tungx.demoapi.service;

import com.tungx.demoapi.entity.KhachHang;
import com.tungx.demoapi.entity.dto.KhachHangDTO;

import java.util.List;
import java.util.Optional;

public interface KhachHangService {
    List<KhachHangDTO> findAllKhachHang();
    List<KhachHangDTO> findKhachHangByLinkedId(String idLinked);
    KhachHangDTO findById(Integer id);
    void save(KhachHangDTO khachHang);
    void remove(KhachHangDTO khachHang);
    KhachHangDTO toDto(KhachHang entity);
    KhachHang toEntity(KhachHangDTO dto);
}
