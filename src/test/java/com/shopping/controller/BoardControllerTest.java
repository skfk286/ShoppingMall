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
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.shopping.service.BoardService;
import com.shopping.vo.BoardVo;

@ExtendWith(MockitoExtension.class)
public class BoardControllerTest {

    @Mock
    private BoardService boardService;

    @InjectMocks
    private BoardController boardController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();
    }

    // 이전에 작성한 testSelectAll(), testSelect(), testInsert(), testUpdate(), testDelete() 메소드들을 여기에 추가해주세요.
    // ...

    @Test
    @Order(1)
    @DisplayName("모든 게시물 조회 화면 테스트")
    public void testGetAllBoard() throws Exception {
        // 가상의 게시물 목록 데이터 생성
        List<BoardVo> boardList = Arrays.asList(
            new BoardVo(1L, "제목1", "내용1", new Date(), 1L),
            new BoardVo(2L, "제목2", "내용2", new Date(), 2L),
            new BoardVo(3L, "제목3", "내용3", new Date(), 3L)
        );

        // Mock Service의 selectAll() 메소드가 호출될 때 가상의 데이터 반환
        when(boardService.selectAll()).thenReturn(boardList);

        // /board/list를 GET 요청하여 컨트롤러를 테스트
        mockMvc.perform(get("/board/list"))
            .andExpect(status().isOk())
            .andExpect(view().name("board/list"))
            .andExpect(model().attributeExists("boardList"))
            .andExpect(model().attribute("boardList", boardList));
    }

    @Test
    @Order(2)
    @DisplayName("특정 게시물 조회 화면 테스트")
    public void testGetBoard() throws Exception {
        // 가상의 게시물 데이터 생성
        BoardVo boardVo = new BoardVo(1L, "제목1", "내용1", new Date(), 1L);

        // Mock Service의 selectBySn() 메소드가 호출될 때 가상의 데이터 반환
        when(boardService.selectBySn(1L)).thenReturn(boardVo);

        // /board/1를 GET 요청하여 컨트롤러를 테스트
        mockMvc.perform(get("/board/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("board/view"))
            .andExpect(model().attributeExists("board"))
            .andExpect(model().attribute("board", boardVo));
    }

    @Test
    @Order(3)
    @DisplayName("게시물 추가 화면 테스트")
    public void testCreateBoardForm() throws Exception {
        // /board/create를 GET 요청하여 컨트롤러를 테스트
        mockMvc.perform(get("/board/create"))
            .andExpect(status().isOk())
            .andExpect(view().name("board/create"));
    }

    @Test
    @Order(4)
    @DisplayName("게시물 추가 처리 테스트")
    public void testCreateBoard() throws Exception {
        // /board/create를 POST 요청하여 컨트롤러를 테스트
        mockMvc.perform(post("/board/create")
                .param("title", "새로운 제목")
                .param("cn", "새로운 내용"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/board/list"));
    }

    @Test
    @Order(5)
    @DisplayName("게시물 수정 화면 테스트")
    public void testUpdateBoardForm() throws Exception {
        // 가상의 게시물 데이터 생성
        BoardVo boardVo = new BoardVo(1L, "제목1", "내용1", new Date(), 1L);

        // Mock Service의 selectBySn() 메소드가 호출될 때 가상의 데이터 반환
        when(boardService.selectBySn(1L)).thenReturn(boardVo);

        // /board/1/update를 GET 요청하여 컨트롤러를 테스트
        mockMvc.perform(get("/board/1/update"))
            .andExpect(status().isOk())
            .andExpect(view().name("board/update"))
            .andExpect(model().attributeExists("board"))
            .andExpect(model().attribute("board", boardVo));
    }

    @Test
    @Order(6)
    @DisplayName("게시물 수정 처리 테스트")
    public void testUpdateBoard() throws Exception {
        // /board/1/update를 POST 요청하여 컨트롤러를 테스트
        mockMvc.perform(post("/board/1/update")
                .param("title", "수정된 제목")
                .param("cn", "수정된 내용"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/board/list"));
    }

    @Test
    @Order(7)
    @DisplayName("게시물 삭제 화면 테스트")
    public void testDeleteBoardForm() throws Exception {
        // 가상의 게시물 데이터 생성
        BoardVo boardVo = new BoardVo(1L, "제목1", "내용1", new Date(), 1L);

        // Mock Service의 selectBySn() 메소드가 호출될 때 가상의 데이터 반환
        when(boardService.selectBySn(1L)).thenReturn(boardVo);

        // /board/1/delete를 GET 요청하여 컨트롤러를 테스트
        mockMvc.perform(get("/board/1/delete"))
            .andExpect(status().isOk())
            .andExpect(view().name("board/delete"))
            .andExpect(model().attributeExists("board"))
            .andExpect(model().attribute("board", boardVo));
    }

    @Test
    @Order(8)
    @DisplayName("게시물 삭제 처리 테스트")
    public void testDeleteBoard() throws Exception {
        // /board/1/delete를 POST 요청하여 컨트롤러를 테스트
        mockMvc.perform(post("/board/1/delete"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/board/list"));
    }
}
