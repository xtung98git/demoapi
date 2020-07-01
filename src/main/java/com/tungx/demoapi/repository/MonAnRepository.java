package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.ChuyenMuc;
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
public class MonAnRepository extends BaseRepository<MonAn, Integer> implements IMonAnRepository{
    @Override
    public List<MonAn> findAllMonAnByChuyenMucId(Integer chuyenMucId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MonAn> criteriaQuery = criteriaBuilder.createQuery(MonAn.class);
        Root<MonAn> root = criteriaQuery.from(MonAn.class);
        Join<MonAn, ChuyenMuc> monAn = root.join("chuyenMuc");
        List<Predicate> predicates = new ArrayList<>();
        if(chuyenMucId != null){
            Predicate predicate = criteriaBuilder.equal(monAn.get("id"), chuyenMucId);
            predicates.add(predicate);
        }
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        TypedQuery<MonAn> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
        return typedQuery.getResultList();
    }
}
