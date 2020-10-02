package kr.co.eduhansol.sms.sample.service;

import java.util.List;

import kr.co.eduhansol.sms.sample.domain.BoardVO;

public interface BoardService {
	
	/** 게시글 목록 조회 */
	public List<BoardVO> getBoardList() throws Exception;  
	
	/** 게시글 상세 조회 */
    public BoardVO getBoardDetail(int board_seq) throws Exception;
 
    /** 게시글 등록 */
    public int insertBoard(BoardVO boardVO) throws Exception;
 
    /** 게시글 수정 */
    public int updateBoard(BoardVO boardVO) throws Exception;
 
    /** 게시글 삭제 */
    public int deleteBoard(int board_seq) throws Exception;
}
