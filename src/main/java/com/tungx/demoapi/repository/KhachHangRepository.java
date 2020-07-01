package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.KhachHang;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class KhachHangRepository extends BaseRepository<KhachHang, Integer>{
}
