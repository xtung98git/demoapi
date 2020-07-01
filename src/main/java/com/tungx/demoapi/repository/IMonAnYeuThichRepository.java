package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.MonAnYeuThich;

import java.util.List;

public interface IMonAnYeuThichRepository {
    List<MonAnYeuThich> findAllByKhachHangId(Integer khachHangId);
}
