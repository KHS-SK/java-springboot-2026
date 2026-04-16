package com.pknu26.studygroup.service;

// import java.util.List;

import com.pknu26.studygroup.dto.Board;
import com.pknu26.studygroup.dto.PageRequest;
import com.pknu26.studygroup.dto.PageResponse;
import com.pknu26.studygroup.validation.BoardForm;

// 서비스를 구현할 때 반드시 아래의 메서드를 전부 구현할 것
public interface BoardService {
    // CRUD = Create, Read(Select), Update, Delete
    // #PRC07 - 얘는 인터페이스니까 구현을 찾아야 함
    void createBoard(BoardForm boardform);

    // List<Board> readBoardList();
    PageResponse<Board> readBoardList(PageRequest PageRequest);

    Board readBoardById(Long boardId);

    void updateBoard(BoardForm boardform);

    void deleteBoard(Long boardId);
}
