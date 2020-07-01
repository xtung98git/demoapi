package com.tungx.demoapi.service.implement;

import com.tungx.demoapi.entity.Comment;
import com.tungx.demoapi.entity.dto.CommentDTO;
import com.tungx.demoapi.repository.CommentRepository;
import com.tungx.demoapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDTO> findAllComment() {
        List<Comment> commentList =  commentRepository.getAll();
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for(int i=0; i<commentList.size(); i++){
            commentDTOList.add(toDto(commentList.get(i)));
        }
        return commentDTOList;
    }

    @Override
    public List<CommentDTO> findAllCommentWithMonAnId(Integer monAnId) {
        List<Comment> commentList =  commentRepository.findAllByMonAnId(monAnId);
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for(int i=0; i<commentList.size(); i++){
            commentDTOList.add(toDto(commentList.get(i)));
        }
        return commentDTOList;
    }

    @Override
    public CommentDTO findById(Integer id) {
        Comment comment = commentRepository.getById(id);
        CommentDTO commentDTO = toDto(comment);
        return commentDTO;
    }

    @Override
    public void save(CommentDTO commentDto) {
        Comment comment = toEntity(commentDto);
        commentRepository.add(comment);
        commentDto.setId(comment.getId());
    }

    @Override
    public void remove(CommentDTO commentDto) {
        Comment comment = toEntity(commentDto);
        commentRepository.delete(comment);
    }

    @Override
    public Comment toEntity(CommentDTO dto) {
        Comment cmt = new Comment();
//        cmt.setId(dto.getId());
        cmt.setKhachHang(dto.getKhachHang());
        cmt.setMonAn(dto.getMonAn());
        cmt.setNoiDung(dto.getNoiDung());
        cmt.setMonAn(dto.getMonAn());
        return cmt;
    }

    @Override
    public CommentDTO toDto(Comment entity) {
        CommentDTO cmt = new CommentDTO();
        cmt.setId(entity.getId());
        cmt.setKhachHang(entity.getKhachHang());
        cmt.setMonAn(entity.getMonAn());
        cmt.setNoiDung(entity.getNoiDung());
        cmt.setMonAn(entity.getMonAn());
        cmt.setNgayDang(entity.getNgayDang());
        return cmt;
    }
}
