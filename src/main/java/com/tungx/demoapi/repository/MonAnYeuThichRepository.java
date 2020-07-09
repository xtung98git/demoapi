package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.ChuyenMuc;
import com.tungx.demoapi.entity.KhachHang;
import com.tungx.demoapi.entity.MonAn;
import com.tungx.demoapi.entity.MonAnYeuThich;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MonAnYeuThichRepository extends BaseRepository<MonAnYeuThich, Integer> implements  IMonAnYeuThichRepository{

    @Override
    public List<MonAnYeuThich> findAllByKhachHangId(Integer khachHangId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MonAnYeuThich> criteriaQuery = criteriaBuilder.createQuery(MonAnYeuThich.class);
        Root<MonAnYeuThich> root = criteriaQuery.from(MonAnYeuThich.class);
        Join<MonAnYeuThich, KhachHang> khachHang = root.join("khachHang");
        List<Predicate> predicates = new ArrayList<>();
        if(khachHangId != null){
            Predicate predicate = criteriaBuilder.equal(khachHang.get("id"), khachHangId);
            predicates.add(predicate);
        }
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        TypedQuery<MonAnYeuThich> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
        return typedQuery.getResultList();
    }

    @Override
    public List<MonAnYeuThich> findByKhachHangAndMonAnId(Integer khachHangId, Integer monAnId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MonAnYeuThich> criteriaQuery = criteriaBuilder.createQuery(MonAnYeuThich.class);
        Root<MonAnYeuThich> root = criteriaQuery.from(MonAnYeuThich.class);
        Join<MonAnYeuThich, KhachHang> khachHang = root.join("khachHang");
        Join<MonAnYeuThich, MonAn> monAn = root.join("monAn");
        List<Predicate> predicates = new ArrayList<>();
        if(khachHangId != null){
            Predicate predicate = criteriaBuilder.equal(khachHang.get("id"), khachHangId);
            Predicate predicate1 = criteriaBuilder.equal(monAn.get("id"), monAnId);
            predicates.add(predicate);
            predicates.add(predicate1);
        }
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        TypedQuery<MonAnYeuThich> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
        return typedQuery.getResultList();
    }

}
