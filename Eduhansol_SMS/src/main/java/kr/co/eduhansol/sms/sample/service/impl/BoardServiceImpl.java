package kr.co.eduhansol.sms.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.co.eduhansol.sms.sample.domain.BoardVO;
import kr.co.eduhansol.sms.sample.mapper.BoardMapper;
import kr.co.eduhansol.sms.sample.service.BoardService;

@Transactional(readOnly = true)
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	/** 게시글 목록 조회 */
	@Override
	public List<BoardVO> getBoardList() throws Exception {
		return boardMapper.getBoardList();
	}

	/** 게시글 상세 조회 */
	@Override
	public BoardVO getBoardDetail(int board_seq) throws Exception {
		return boardMapper.getBoardDetail(board_seq);
	}

	/** 게시글 등록 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		return boardMapper.insertBoard(boardVO);
	}

	/** 게시글 수정 */
	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		return boardMapper.updateBoard(boardVO);
	}

	/** 게시글 삭제 */
	@Override
	public int deleteBoard(int board_seq) throws Exception {
		return boardMapper.deleteBoard(board_seq);
	}	
}
