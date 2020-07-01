package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.ChuyenMuc;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ChuyenMucRepository extends BaseRepository<ChuyenMuc, Integer> {
}
