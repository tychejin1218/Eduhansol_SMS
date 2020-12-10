package kr.co.eduhansol.sms.sample.mapper;

import java.util.List;
import java.util.Map;

import kr.co.eduhansol.sms.annotation.mapper.MapperScanMysql;

//@MapperScanMysql
public interface SampleMapperMysql {

	public List<Map<String, String>> getSampleList();
}