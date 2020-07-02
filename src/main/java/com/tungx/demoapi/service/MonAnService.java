package com.tungx.demoapi.service;

import com.tungx.demoapi.entity.MonAn;
import com.tungx.demoapi.entity.dto.MonAnDTO;

import java.util.List;
import java.util.Optional;

public interface MonAnService {
    List<MonAnDTO> findAllMonAn();
    List<MonAnDTO> findAllMonAnByChuyenMucId(Integer chuyenMucId);
    List<MonAnDTO> findAllMonAnByName(String name);
    MonAnDTO findById(Integer id);
    void save(MonAnDTO nguyenLieu);
    void remove(MonAnDTO nguyenLieu);
    MonAn toEntity(MonAnDTO dto);
    MonAnDTO toDto(MonAn entity);
}
