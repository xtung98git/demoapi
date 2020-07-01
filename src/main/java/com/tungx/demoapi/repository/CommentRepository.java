package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.Comment;
import com.tungx.demoapi.entity.MonAn;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
public class CommentRepository extends BaseRepository<Comment, Integer> implements ICommentRepository  {

    @Override
    public List<Comment> findAllByMonAnId(Integer monAnId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comment> criteriaQuery = criteriaBuilder.createQuery(Comment.class);
        Root<Comment> root = criteriaQuery.from(Comment.class);
        Join<Comment, MonAn> user = root.join("monAn");
        List<Predicate> predicates = new ArrayList<>();
        if(monAnId != null){
            Predicate predicate = criteriaBuilder.equal(user.get("id"), monAnId);
            predicates.add(predicate);
        }
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("ngayDang")));
        TypedQuery<Comment> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
        return typedQuery.getResultList();
    }
}
