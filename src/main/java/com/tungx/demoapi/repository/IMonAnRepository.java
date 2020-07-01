package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.MonAn;

import java.util.List;

public interface IMonAnRepository {
    List<MonAn> findAllMonAnByChuyenMucId(Integer chuyenMucId);
    List<MonAn> findAllMonAnByName(String name);
}
