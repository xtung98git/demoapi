package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.GiaViSuDung;

import java.util.List;

public interface IGiaViSuDungRepository {
    List<GiaViSuDung> findAllByMonAnId(Integer monAnId);
}
