package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.Comment;
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
public class NguyenLieuSuDungRepository extends BaseRepository<NguyenLieuSuDung, Integer> implements INguyenLieuSuDungRepository{
    @Override
    public List<NguyenLieuSuDung> findAllByMonAnId(Integer monAnId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<NguyenLieuSuDung> criteriaQuery = criteriaBuilder.createQuery(NguyenLieuSuDung.class);
        Root<NguyenLieuSuDung> root = criteriaQuery.from(NguyenLieuSuDung.class);
        Join<NguyenLieuSuDung, MonAn> monAn = root.join("monAn");
        List<Predicate> predicates = new ArrayList<>();
        if(monAnId != null){
            Predicate predicate = criteriaBuilder.equal(monAn.get("id"), monAnId);
            predicates.add(predicate);
        }
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        TypedQuery<NguyenLieuSuDung> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
        return typedQuery.getResultList();
    }
}
