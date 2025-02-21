package org.example.board.service;

import java.util.List;
import org.example.board.dto.BoardDto;
import org.example.board.dto.BoardsDTO;
import org.example.board.vo.Board;
import org.example.board.vo.Like;
import org.example.board.vo.User;

public interface BoardService {
  List<BoardsDTO> getAllBoars(String keyWord);
  BoardDto getBoardById(Long id, String userId);
  void createBoard(Board board);
  void removeBoard(Long id);
  void updateBoard(Board board);
  void updateCount(Long id);
  Boolean updateLike(Like like,Boolean liked);
}
