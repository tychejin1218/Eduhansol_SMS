package kr.co.eduhansol.sms.send.mapper.mysql;

import java.util.List;

import kr.co.eduhansol.sms.send.domain.Board;


public interface BoardMapper {

	public List<Board> getBoardList();
}