package com.tungx.demoapi.repository;

import com.tungx.demoapi.entity.Comment;

import java.util.List;

public interface ICommentRepository {
    List<Comment> findAllByMonAnId(Integer monAnId);
}
