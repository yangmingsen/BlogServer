package top.yms.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yms.server.dao.CommentMapper;
import top.yms.server.entity.Comment;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> findAllByArticleId(long articleId) {
        return commentMapper.findAllByArticleId(articleId);
    }

    public int add(Comment comment) {
        return commentMapper.add(comment.getArticleId(),comment.getUsername(),
                comment.getContent(),comment.getCreatedTime());
    }


}
