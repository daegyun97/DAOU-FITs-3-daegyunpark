package org.example.board.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.example.board.vo.Comment;

public class CommentDAOImpl implements CommentDAO {
  private SqlSession sqlSession;

  public CommentDAOImpl() {
  }

  @Override
  public void setSession(SqlSession session) {
    this.sqlSession = session;
  }

  @Override
  public List<Comment> selectCommentById(Long id) {
    return sqlSession.selectList("example.MyComment.selectCommentsById",id);
  }

  @Override
  public void insertComment(Comment comment) {
    sqlSession.insert("example.MyComment.insertComment", comment);
  }

  @Override
  public void deleteComment(Long id) {
    sqlSession.delete("example.MyComment.deleteCommentById", id);
  }

  @Override
  public int getCount(Long id) {
    Integer count = sqlSession.selectOne("example.MyComment.selectCnt", id);
    return count;
  }
}
