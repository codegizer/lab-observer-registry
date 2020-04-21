package kr.co.apps.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import kr.co.apps.vo.*;

@Service
public class ServiceRegistry implements IServiceRegistry {
	
	private Map<String,Observer> registyMap = new HashMap<String,Observer>();  
	
	//파라미터로 받은 옵저버 인스턴스와 업무ID를 함께 레지스트리(해시맵)에 등록
	@Override
	public void register(String taskId, Observer observer) {
		// TODO Auto-generated method stub
		registyMap.put(taskId,observer);
		System.out.println("새로운 옵저버가 등록되었습니다===>");
		System.out.println("태스크ID :" + taskId );
		System.out.println("이벤트처리 옵저버 :" + observer.getClass().getName() );
	}

	//파라미터로 받은 taskId를 이용해 레지스트리에서 관련 옵저버를 찾아 이벤트와 처리할 Subject 엔티티를 전달
	@Override
	public void notify(MyDocumentVo docVo, String taskId, CbEventType eventType) {
		// TODO Auto-generated method stub
		Observer observer = registyMap.get(taskId);
		
		if(observer!=null) observer.update(docVo,eventType);
		
	}

	//옵저버레지스트리에 등록된 옵저버 목록을 조회
	@Override
	public List<Map<String,String>> selectRegistryList() {
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map = null;
		// TODO Auto-generated method stub
		Iterator<String> keys = registyMap.keySet().iterator();
		
		while(keys.hasNext())
		{
			map = new HashMap<String,String>();
			map.put("TASKID", keys.next());
			map.put("CLASS_NAME", registyMap.get(map.get("TASKID").toString()).getClass().getName());
			list.add(map);
		}
		
		return list;
	}

}
