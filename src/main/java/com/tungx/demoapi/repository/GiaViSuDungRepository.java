package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.GiaViSuDung;
import com.tungx.demoapi.entity.MonAn;
import com.tungx.demoapi.entity.NguyenLieuSuDung;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class GiaViSuDungRepository extends BaseRepository<GiaViSuDung, Integer> implements  IGiaViSuDungRepository{
    @Override
    public List<GiaViSuDung> findAllByMonAnId(Integer monAnId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<GiaViSuDung> criteriaQuery = criteriaBuilder.createQuery(GiaViSuDung.class);
        Root<GiaViSuDung> root = criteriaQuery.from(GiaViSuDung.class);
        Join<GiaViSuDung, MonAn> monAn = root.join("monAn");
        List<Predicate> predicates = new ArrayList<>();
        if(monAnId != null){
            Predicate predicate = criteriaBuilder.equal(monAn.get("id"), monAnId);
            predicates.add(predicate);
        }
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        TypedQuery<GiaViSuDung> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
        return typedQuery.getResultList();
    }
}
