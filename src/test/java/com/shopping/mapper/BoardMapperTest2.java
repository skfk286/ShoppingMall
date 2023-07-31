package com.shopping.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.shopping.config.MybatisConfiguration;
import com.shopping.vo.BoardVo;

@ExtendWith(SpringExtension.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(MybatisConfiguration.class)
@ContextConfiguration(classes = {com.shopping.wasboot.WebInitializer.class, com.shopping.web.RootConfig.class})
public class BoardMapperTest2 {

    @Autowired
    private BoardMapper boardMapper;

    @BeforeEach
    public void setUp() {
        // 테스트용 데이터를 삽입하거나 초기화하는 작업을 수행할 수 있습니다.
        // 필요에 따라서 테스트용 데이터베이스를 초기화하거나 데이터를 삽입할 수 있습니다.
    }

    @Test
    public void testSelectAll() {
        List<BoardVo> boards = boardMapper.selectAll();
        assertNotNull(boards);
        assertEquals(0, boards.size()); // 테스트용 데이터가 없으므로 비어있는 리스트를 기대합니다.
    }

    @Test
    public void testSelectBySn() {
        Long sn = 1L; // 존재하는 Board 데이터의 등록번호를 사용합니다. (테스트용 데이터베이스에 따라서 다를 수 있습니다.)
        BoardVo board = boardMapper.selectBySn(sn);
        assertNotNull(board);
    }

    @Test
    public void testInsert() {
        BoardVo newBoard = new BoardVo();
        // 새로운 Board 데이터를 설정합니다. (필요에 따라 필드를 채워넣습니다.)
        // ...
        boardMapper.insert(newBoard);

        // 데이터를 삽입한 후 적절한 검증을 수행합니다.
        // ...
    }

    @Test
    public void testUpdate() {
        Long sn = 1L; // 존재하는 Board 데이터의 등록번호를 사용합니다. (테스트용 데이터베이스에 따라서 다를 수 있습니다.)
        BoardVo board = boardMapper.selectBySn(sn);
        assertNotNull(board);

        // 업데이트할 내용을 변경합니다. (필요에 따라 필드를 수정합니다.)
        // ...
        boardMapper.update(board);

        // 데이터를 업데이트한 후 적절한 검증을 수행합니다.
        // ...
    }

    @Test
    public void testDelete() {
        Long sn = 1L; // 존재하는 Board 데이터의 등록번호를 사용합니다. (테스트용 데이터베이스에 따라서 다를 수 있습니다.)
        boardMapper.delete(sn);

        // 데이터를 삭제한 후 적절한 검증을 수행합니다.
        // ...
    }
}
