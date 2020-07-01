package com.tungx.demoapi.service.implement;

import com.tungx.demoapi.entity.GiaViSuDung;
import com.tungx.demoapi.repository.GiaViSuDungRepository;
import com.tungx.demoapi.service.GiaViSuDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class GiaViSuDungServiceImpl implements GiaViSuDungService {
    private GiaViSuDungRepository giaViSuDungRepository;

    @Autowired
    public GiaViSuDungServiceImpl(GiaViSuDungRepository giaViSuDungRepository) {
        this.giaViSuDungRepository = giaViSuDungRepository;
    }

    @Override
    public List<GiaViSuDung> findAllGiaViSuDung() {
        return giaViSuDungRepository.getAll();
    }

    @Override
    public List<GiaViSuDung> findAllGiaViSuDungByMonAnId(Integer monAnId) {
        return giaViSuDungRepository.findAllByMonAnId(monAnId);
    }

    @Override
    public GiaViSuDung findById(Integer id) {
        return giaViSuDungRepository.getById(id);
    }

    @Override
    public void save(GiaViSuDung giaViSuDung) {
        giaViSuDungRepository.add(giaViSuDung);
    }

    @Override
    public void remove(GiaViSuDung giaViSuDung) {
        giaViSuDungRepository.delete(giaViSuDung);
    }
}
