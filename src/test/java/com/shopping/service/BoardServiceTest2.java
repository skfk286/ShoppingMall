package com.shopping.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.shopping.mapper.BoardMapper;
import com.shopping.service.impl.BoardServiceImpl;
import com.shopping.vo.BoardVo;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTest2 {

    @Mock
    private BoardMapper boardMapper;

    @InjectMocks
    private BoardService boardService = new BoardServiceImpl();

    private BoardVo sampleBoard1;
    private BoardVo sampleBoard2;
    private BoardVo sampleBoard3;

    @BeforeEach
    public void setUp() {
        sampleBoard1 = new BoardVo();
        sampleBoard1.setSn(1L);
        sampleBoard1.setTitle("Sample Board 1");
        sampleBoard1.setCn("This is the content of Sample Board 1.");
        sampleBoard1.setModifyDate(new Date());
        sampleBoard1.setFileSn(101L);

        sampleBoard2 = new BoardVo();
        sampleBoard2.setSn(2L);
        sampleBoard2.setTitle("Sample Board 2");
        sampleBoard2.setCn("This is the content of Sample Board 2.");
        sampleBoard2.setModifyDate(new Date());
        sampleBoard2.setFileSn(102L);

        sampleBoard3 = new BoardVo();
        sampleBoard3.setSn(3L);
        sampleBoard3.setTitle("Sample Board 3");
        sampleBoard3.setCn("This is the content of Sample Board 3.");
        sampleBoard3.setModifyDate(new Date());
        sampleBoard3.setFileSn(103L);
    }

    @Test
    public void testSelectAll() {
        // Mock 데이터 생성
        List<BoardVo> mockBoardList = new ArrayList<>();
        mockBoardList.add(sampleBoard1);
        mockBoardList.add(sampleBoard2);
        mockBoardList.add(sampleBoard3);
        when(boardMapper.selectAll()).thenReturn(mockBoardList);

        // Service 호출
        List<BoardVo> result = boardService.selectAll();

        // 검증
        assertEquals(3, result.size());
        // 실제 데이터 비교 등 필요한 검증을 추가할 수 있습니다.
    }

    @Test
    public void testSelectBySn() {
        // Mock 데이터 생성
        Long mockSn = 1L;
        when(boardMapper.selectBySn(mockSn)).thenReturn(sampleBoard1);

        // Service 호출
        BoardVo result = boardService.selectBySn(mockSn);

        // 검증
        assertEquals(mockSn, result.getSn());
        // 실제 데이터 비교 등 필요한 검증을 추가할 수 있습니다.
    }

    @Test
    public void testInsert() {
        // Service 호출
        boardService.insert(sampleBoard1);

        // 검증 없이 성공으로 가정합니다.
    }

    @Test
    public void testUpdate() {
        // Service 호출
        boardService.update(sampleBoard2);

        // 검증 없이 성공으로 가정합니다.
    }

    @Test
    public void testDelete() {
        // Mock 데이터 생성
        Long mockSn = 3L;

        // Service 호출
        boardService.delete(mockSn);

        // 검증 없이 성공으로 가정합니다.
    }
}

