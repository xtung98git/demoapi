package com.tungx.demoapi.service;

import com.tungx.demoapi.entity.Comment;
import com.tungx.demoapi.entity.dto.CommentDTO;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<CommentDTO> findAllComment();
    List<CommentDTO> findAllCommentWithMonAnId(Integer monAnId);
    CommentDTO findById(Integer id);
    void save(CommentDTO khachHang);
    void remove(CommentDTO khachHang);
    Comment toEntity(CommentDTO dto);
    CommentDTO toDto(Comment entity);
}
