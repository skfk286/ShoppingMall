package com.shopping.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

import com.shopping.controller.BoardController;
import com.shopping.service.BoardService;
import com.shopping.vo.BoardVo;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class BoardControllerTest2 {

    @Mock
    private BoardService boardService;

    @InjectMocks
    private BoardController boardController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("모든 게시물 조회 테스트")
    public void testGetAllBoard() {
        // Given
        List<BoardVo> boardList = new ArrayList<>();
        boardList.add(new BoardVo(1L, "제목1", "내용1", null, null));
        boardList.add(new BoardVo(2L, "제목2", "내용2", null, null));

        when(boardService.selectAll()).thenReturn(boardList);
        Model model = mock(Model.class);

        // When
        String viewName = boardController.getAllBoard(model);

        // Then
        Assertions.assertEquals("board/list", viewName);
        verify(boardService, times(1)).selectAll();
        verify(model, times(1)).addAttribute("boardList", boardList);
    }

    @Test
    @DisplayName("특정 게시물 조회 테스트")
    public void testGetBoard() {
        // Given
        Long sn = 1L;
        BoardVo board = new BoardVo(sn, "제목1", "내용1", null, null);

        when(boardService.selectBySn(sn)).thenReturn(board);
        Model model = mock(Model.class);

        // When
        String viewName = boardController.getBoard(sn, model);

        // Then
        Assertions.assertEquals("board/view", viewName);
        verify(boardService, times(1)).selectBySn(sn);
        verify(model, times(1)).addAttribute("board", board);
    }

    @Test
    @DisplayName("게시물 추가 테스트")
    public void testCreateBoard() {
        // Given
        BoardVo boardVo = new BoardVo(null, "제목1", "내용1", null, null);

        // When
        String viewName = boardController.createBoard(boardVo);

        // Then
        Assertions.assertEquals("redirect:/board/list", viewName);
        verify(boardService, times(1)).insert(boardVo);
    }

    @Test
    @DisplayName("게시물 수정 테스트")
    public void testUpdateBoard() {
        // Given
        Long sn = 1L;
        BoardVo boardVo = new BoardVo(sn, "수정된 제목", "수정된 내용", null, null);

        // When
        String viewName = boardController.updateBoard(sn, boardVo);

        // Then
        Assertions.assertEquals("redirect:/board/list", viewName);
        verify(boardService, times(1)).update(boardVo);
    }

    @Test
    @DisplayName("게시물 삭제 테스트")
    public void testDeleteBoard() {
        // Given
        Long sn = 1L;

        // When
        String viewName = boardController.deleteBoard(sn);

        // Then
        Assertions.assertEquals("redirect:/board/list", viewName);
        verify(boardService, times(1)).delete(sn);
    }
}

