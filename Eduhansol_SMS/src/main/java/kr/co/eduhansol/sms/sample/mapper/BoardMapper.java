package kr.co.eduhansol.sms.sample.mapper;

import java.util.List;

import kr.co.eduhansol.sms.annotation.mapper.MapperScanMysql;
import kr.co.eduhansol.sms.sample.domain.BoardVO;

@MapperScanMysql
public interface BoardMapper {

	/** 게시글 목록 조회 */
	public List<BoardVO> getBoardList(); 
	
	/** 게시글 상세 조회 */
	public BoardVO getBoardDetail(int board_seq);
	
	/** 게시글 등록 */
	public int insertBoard(BoardVO boardVO);
	
	/** 게시글 수정 */
	public int updateBoard(BoardVO boardVO);
	
	/** 게시글 삭제 */
	public int deleteBoard(int board_seq);
}