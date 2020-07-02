package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.ChuyenMuc;
import com.tungx.demoapi.entity.KhachHang;
import com.tungx.demoapi.entity.MonAn;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class KhachHangRepository extends BaseRepository<KhachHang, Integer> implements IKhachHangRepository{
    @Override
    public List<KhachHang> findByLinkedId(String linkedID) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<KhachHang> criteriaQuery = criteriaBuilder.createQuery(KhachHang.class);
        Root<KhachHang> root = criteriaQuery.from(KhachHang.class);
        List<Predicate> predicates = new ArrayList<>();
        if (linkedID != null ) {
            Predicate predicate = criteriaBuilder.equal(root.get("idLinked"), linkedID);
            predicates.add(predicate);
        }
        else{
            return new ArrayList<KhachHang>();
        }
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        TypedQuery<KhachHang> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
        return typedQuery.getResultList();
    }
}
