package com.tungx.demoapi.service.implement;

import com.tungx.demoapi.entity.NguyenLieuSuDung;
import com.tungx.demoapi.repository.NguyenLieuSuDungRepository;
import com.tungx.demoapi.service.NguyenLieuSuDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NguyenLieuSuDungServiceImpl implements NguyenLieuSuDungService {
    private NguyenLieuSuDungRepository nguyenLieuSuDungRepository;

    @Autowired
    public NguyenLieuSuDungServiceImpl(NguyenLieuSuDungRepository nguyenLieuSuDungRepository) {
        this.nguyenLieuSuDungRepository = nguyenLieuSuDungRepository;
    }

    @Override
    public List<NguyenLieuSuDung> findAllNguyenLieuSuDung() {
        return nguyenLieuSuDungRepository.getAll();
    }

    @Override
    public List<NguyenLieuSuDung> findAllNguyenLieuSuDungByMonAnId(Integer monAnId) {
        return nguyenLieuSuDungRepository.findAllByMonAnId(monAnId);
    }

    @Override
    public NguyenLieuSuDung findById(Integer id) {
        return nguyenLieuSuDungRepository.getById(id);
    }

    @Override
    public void save(NguyenLieuSuDung nguyenLieuSuDung) {
        nguyenLieuSuDungRepository.add(nguyenLieuSuDung);
    }

    @Override
    public void remove(NguyenLieuSuDung nguyenLieuSuDung) {
        nguyenLieuSuDungRepository.delete(nguyenLieuSuDung);
    }
}
