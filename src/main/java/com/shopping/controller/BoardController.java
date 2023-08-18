package com.shopping.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.shopping.service.BoardService;
import com.shopping.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
    
    private final static Logger logger = LogManager.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;
    
    // 모든 게시물 조회 화면
    @GetMapping("/list")
    public String getAllBoard(Model model) {
        logger.info("getAllBoard() 메서드 호출");
        List<BoardVo> boardList = boardService.selectAll();
        model.addAttribute("boardList", boardList);
        
        return "board/list"; // board/list.jsp로 이동
    }

    // 특정 게시물 조회 화면
    @GetMapping("/{sn}")
    public String getBoard(@PathVariable Long sn, Model model) {
        logger.info("getBoard() 메서드 호출 - 게시물 식별번호: {}", sn);
        BoardVo board = boardService.selectBySn(sn);
        model.addAttribute("board", board);
        return "board/view"; // board/view.jsp로 이동
    }

    // 게시물 추가 화면
    @GetMapping("/create")
    public String createBoardForm() {
        logger.info("createBoardForm() 메서드 호출 - 게시물 추가 화면으로 이동");
        return "board/create"; // board/create.jsp로 이동
    }

    // 게시물 추가 처리
    @PostMapping("/create")
    public String createBoard(@ModelAttribute BoardVo boardVo) {
        logger.info("createBoard() 메서드 호출 - 새로운 게시물 추가: {}", boardVo);
        boardService.insert(boardVo);
        return "redirect:/board/list"; // 게시물 목록 화면으로 리다이렉트
    }

    // 게시물 수정 화면
    @GetMapping("/{sn}/update")
    public String updateBoardForm(@PathVariable Long sn, Model model) {
        logger.info("updateBoardForm() 메서드 호출 - 게시물 수정 화면으로 이동 - 게시물 식별번호: {}", sn);
        BoardVo board = boardService.selectBySn(sn);
        model.addAttribute("board", board);
        return "board/update"; // board/update.jsp로 이동
    }

    // 게시물 수정 처리
    @PostMapping("/{sn}/update")
    public String updateBoard(@PathVariable Long sn, @ModelAttribute BoardVo boardVo) {
        logger.info("updateBoard() 메서드 호출 - 게시물 수정 - 게시물 식별번호: {}, 수정할 게시물 정보: {}", sn, boardVo);
        boardVo.setSn(sn);
        boardService.update(boardVo);
        return "redirect:/board/list"; // 게시물 목록 화면으로 리다이렉트
    }

    // 게시물 삭제 화면
    @GetMapping("/{sn}/delete")
    public String deleteBoardForm(@PathVariable Long sn, Model model) {
        logger.info("deleteBoardForm() 메서드 호출 - 게시물 삭제 화면으로 이동 - 게시물 식별번호: {}", sn);
        BoardVo board = boardService.selectBySn(sn);
        model.addAttribute("board", board);
        return "board/delete"; // board/delete.jsp로 이동
    }

    // 게시물 삭제 처리
    @PostMapping("/{sn}/delete")
    public String deleteBoard(@PathVariable Long sn) {
        logger.info("deleteBoard() 메서드 호출 - 게시물 삭제 - 게시물 식별번호: {}", sn);
        boardService.delete(sn);
        return "redirect:/board/list"; // 게시물 목록 화면으로 리다이렉트
    }
}
