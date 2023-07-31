package com.shopping.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.shopping.controller.BoardController;
import com.shopping.service.BoardService;
import com.shopping.vo.BoardVo;

@ExtendWith(MockitoExtension.class)
public class BoardControllerTest3 {

    @Mock
    private BoardService boardService;

    @InjectMocks
    private BoardController boardController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();
    }

    // Add other test methods here
    // ...

    @Test
    @DisplayName("모든 게시물 조회 화면 테스트")
    public void testGetAllBoard() throws Exception {
        List<BoardVo> boardList = Arrays.asList(
                new BoardVo(1L, "Title 1", "Content 1", new Date(), 1L),
                new BoardVo(2L, "Title 2", "Content 2", new Date(), 2L)
        );

        when(boardService.selectAll()).thenReturn(boardList);

        mockMvc.perform(get("/board/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("board/list"))
                .andExpect(model().attributeExists("boardList"))
                .andExpect(model().attribute("boardList", boardList));
    }

    @Test
    @DisplayName("특정 게시물 조회 화면 테스트")
    public void testGetBoard() throws Exception {
        Long sn = 1L;
        BoardVo board = new BoardVo(sn, "Title", "Content", new Date(), 1L);

        when(boardService.selectBySn(sn)).thenReturn(board);

        mockMvc.perform(get("/board/{sn}", sn))
                .andExpect(status().isOk())
                .andExpect(view().name("board/view"))
                .andExpect(model().attributeExists("board"))
                .andExpect(model().attribute("board", board));
    }

    @Test
    @DisplayName("게시물 추가 화면 테스트")
    public void testCreateBoardForm() throws Exception {
        mockMvc.perform(get("/board/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("board/create"));
    }

    @Test
    @DisplayName("게시물 추가 처리 테스트")
    public void testCreateBoard() throws Exception {
//        BoardVo board = new BoardVo(null, "New Title", "New Content", null, null);
//
//        doNothing().when(boardService).insert(board);

        mockMvc.perform(post("/board/create")
                .param("title", "New Title")
                .param("cn", "New Content"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/board/list"));
    }

    @Test
    @DisplayName("게시물 수정 화면 테스트")
    public void testUpdateBoardForm() throws Exception {
        Long sn = 1L;
        BoardVo board = new BoardVo(sn, "Title", "Content", new Date(), 1L);

        when(boardService.selectBySn(sn)).thenReturn(board);
        
        mockMvc.perform(get("/board/{sn}/update", sn))
                .andExpect(status().isOk())
                .andExpect(view().name("board/update"))
                .andExpect(model().attributeExists("board"))
                .andExpect(model().attribute("board", board));
    }

    @Test
    @DisplayName("게시물 수정 처리 테스트")
    public void testUpdateBoard() throws Exception {
        Long sn = 1L;
//        BoardVo board = new BoardVo(sn, "Title", "Content", new Date(), 1L);
//
//        doNothing().when(boardService).update(board);

        mockMvc.perform(post("/board/{sn}/update", sn)
                .param("title", "Updated Title")
                .param("cn", "Updated Content"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/board/list"));
    }

    @Test
    @DisplayName("게시물 삭제 화면 테스트")
    public void testDeleteBoardForm() throws Exception {
        Long sn = 1L;
        BoardVo board = new BoardVo(sn, "Title", "Content", new Date(), 1L);

        when(boardService.selectBySn(sn)).thenReturn(board);

        mockMvc.perform(get("/board/{sn}/delete", sn))
                .andExpect(status().isOk())
                .andExpect(view().name("board/delete"))
                .andExpect(model().attributeExists("board"))
                .andExpect(model().attribute("board", board));
    }

    @Test
    @DisplayName("게시물 삭제 처리 테스트")
    public void testDeleteBoard() throws Exception {
        Long sn = 1L;

        doNothing().when(boardService).delete(sn);

        mockMvc.perform(post("/board/{sn}/delete", sn))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/board/list"));
    }
}
