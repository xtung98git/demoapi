package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.KhachHang;

import java.util.List;

public interface IKhachHangRepository {
    public List<KhachHang> findByLinkedId(String linkedID);
}
