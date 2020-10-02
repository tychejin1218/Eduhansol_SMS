package kr.co.eduhansol.sms.sample.domain;

import lombok.Data;

@Data
public class BoardVO {
	
	int board_seq;	
	int board_re_ref;	
	int board_re_lev;	
	int board_re_seq;	
	String board_writer;	
	String board_subject;	
	String board_content;	
	int board_hits;	
	String del_yn;	
	String ins_user_id;	
	String ins_date;	
	String upd_user_id;	
	String upd_date;
}