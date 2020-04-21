package kr.co.apps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.apps.service.CbEventType;
import kr.co.apps.service.ServiceRegistry;

import kr.co.apps.vo.*;
import java.util.*;

@Service
public class MyDocument {
	
	//옵저버관리서비스
	@Autowired
	ServiceRegistry serviceRegistry;
    
	int key = 0;
    
	//Subject 엔티티 관리를 위한 해시맵
	Map<Integer,MyDocumentVo> dataHashMap = new HashMap<Integer,MyDocumentVo>();
    
	//Subject 엔티티 목록 리턴
	public List<MyDocumentVo> selectDocList()
	{
		List<MyDocumentVo> list = new ArrayList<MyDocumentVo>();
		
		Iterator<Integer> keys = dataHashMap.keySet().iterator();
		
		while(keys.hasNext())
		{
			list.add(dataHashMap.get(keys.next()));
		}
		
		return list;
	}
    
	//Subject 엔티티 추가
	public synchronized void add(String title, String taskId)
	{
		MyDocumentVo vo = new MyDocumentVo();
        
		key++;
        
		vo.setKey(key);
		vo.setTitle(title);
		vo.setTaskId(taskId);
        
		dataHashMap.put(key,vo);
    }
    
	//notify
	//Subject와 관련된 연계서비스를 호출
    public void callEvtExecute(int docKey, CbEventType eventType)
    {
		MyDocumentVo docVo = dataHashMap.get(docKey);
		String taskId = docVo.getTaskId();
		serviceRegistry.notify(docVo,taskId,eventType);
        
    }
} 
