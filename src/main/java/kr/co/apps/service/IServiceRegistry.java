package kr.co.apps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kr.co.apps.vo.*;

public interface IServiceRegistry {
	
	public void register(String taskId, Observer observer);
	public void notify(MyDocumentVo docVo, String taskId, CbEventType eventType);
	public List<Map<String,String>> selectRegistryList();	
}
