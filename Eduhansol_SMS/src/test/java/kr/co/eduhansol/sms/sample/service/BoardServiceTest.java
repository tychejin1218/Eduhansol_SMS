package kr.co.eduhansol.sms.sample.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.eduhansol.sms.sample.domain.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {

	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;

	@Test
	public void testExist() {
		log.info(boardService);
		assertNotNull(boardService);
	}

	/** 게시글 목록 조회 테스트 */
	@Test
	public void testGetBoardList() {

		try {

			List<BoardVO> boardList = boardService.getBoardList();

			log.info(boardList);
			
			// 조회 결과가 1건일 경우 테스트 통과
			assertEquals(1, boardList.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 게시글 상세 조회 테스트 */
	@Test
	public void testGetBoardDetail() throws Exception { 

		try {

			BoardVO boardDetail = boardService.getBoardDetail(3);

			log.info(boardDetail);
			
			// 1번 게시글이 있는 경우 경우 테스트 통과
			assertNotNull(boardDetail);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 게시글 등록 테스트 */
	@Test
	public void testInsertBoard() throws Exception { 

		try {

			BoardVO insertBoard = new BoardVO();
			insertBoard.setBoard_writer("게시글 작성자");
			insertBoard.setBoard_subject("게시글 제목_10");
			insertBoard.setBoard_content("게시글 내용_10");
			boardService.insertBoard(insertBoard);

			int insertBoardSeq = insertBoard.getBoard_seq();					
			log.info("insertBoardSeq:" + insertBoardSeq);

			BoardVO boardDetail = boardService.getBoardDetail(insertBoardSeq);
			
			log.info(boardDetail);
			
			// 게시글이 있고, 제목이 일치하는 경우 테스트 통과
			assertNotNull(boardDetail);
			assertEquals("게시글 제목_10", boardDetail.getBoard_subject());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 게시글 수정 테스트 */
	@Test
	public void testUpdateBoard() throws Exception { 

		try {
			
			BoardVO insertBoard = new BoardVO();
			insertBoard.setBoard_writer("게시글 작성자");
			insertBoard.setBoard_subject("게시글 제목_등록");
			insertBoard.setBoard_content("게시글 제목_등록");
			boardService.insertBoard(insertBoard);

			int insertBoardSeq = insertBoard.getBoard_seq();			
			log.info("insertBoardSeq:" + insertBoardSeq);
			
			BoardVO updateBoard = new BoardVO();
			updateBoard.setBoard_seq(insertBoardSeq);
			updateBoard.setBoard_subject("게시글 제목_수정");
			updateBoard.setBoard_content("게시글 제목_수정");
			boardService.updateBoard(updateBoard);
			
			BoardVO boardDetail = boardService.getBoardDetail(insertBoardSeq);
			
			log.info(boardDetail);
			
			// 게시글이 있고, 등록한 게시글 제목이 수정되었으면 테스트 통과
			assertNotNull(boardDetail); 
			assertEquals("게시글 제목_수정", boardDetail.getBoard_subject());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 게시글 삭제 테스트 */
	@Test
	public void testDeleteBoard() throws Exception { 

		try {

			BoardVO insertBoard = new BoardVO();
			insertBoard.setBoard_writer("게시글 작성자");
			insertBoard.setBoard_subject("게시글 제목_등록1");
			insertBoard.setBoard_content("게시글 제목_등록1");
			boardService.insertBoard(insertBoard);

			int insertBoardSeq = insertBoard.getBoard_seq();			
			log.info("insertBoardSeq:" + insertBoardSeq);

			boardService.deleteBoard(insertBoardSeq);
			
			BoardVO boardDetail = boardService.getBoardDetail(insertBoardSeq);

			log.info(boardDetail);
			
			// 삭제한 게시글이 조회되지 않으면 테스트 통과
			assertNull(boardDetail);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
