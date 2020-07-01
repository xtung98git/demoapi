package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.NguyenLieuSuDung;

import java.util.List;

public interface INguyenLieuSuDungRepository {
    List<NguyenLieuSuDung> findAllByMonAnId(Integer monAnId);
}
