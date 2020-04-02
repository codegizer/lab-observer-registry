package kr.co.apps.service;

import javax.annotation.PostConstruct;
import javax.swing.event.DocumentEvent.EventType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.apps.vo.*;

@Service
public class TestObserver2 implements Observer {

	@Autowired
	ServiceRegistry serviceRegistry;
	
	@PostConstruct
	@Override
	public void register() {
		// TODO Auto-generated method stub
		serviceRegistry.register("ERP3406", this);
	}

	@Override
	public void update(MyDocumentVo docVo,CbEventType evntType) {
		// TODO Auto-generated method stub
		System.out.println("문서명:"+docVo.getTitle()+", 연계업무:"+docVo.getTaskId()+", 이벤트발생:"+ evntType	);
		
	}

}
