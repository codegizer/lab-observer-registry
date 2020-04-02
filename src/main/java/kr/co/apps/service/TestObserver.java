package kr.co.apps.service;

import javax.annotation.PostConstruct;
import javax.swing.event.DocumentEvent.EventType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.apps.vo.*;

@Service
public class TestObserver implements Observer {

	@Autowired
	ServiceRegistry serviceRegistry;
	
	@PostConstruct
	@Override
	public void register() {
		// TODO Auto-generated method stub
		serviceRegistry.register("ERP3401", this);
	}

	@Override
	public void update(MyDocumentVo docVo,CbEventType evntType) {
		// TODO Auto-generated method stub
		StringBuffer msg = new StringBuffer();
		msg.append("문서명:"+docVo.getTitle()+", 연계업무:"+docVo.getTaskId());
		
		switch(evntType)
		{
			case SAVE:
				msg.append(", 이벤트 발생: SAVE(저장)");
				break;
			case EDIT:
				msg.append(", 이벤트 발생: EDIT(수정)");
				break;
			case DELETE:
				msg.append(", 이벤트 발생: DELETE(삭제)");
				break;
			case ROLLBACK:
				msg.append(", 이벤트 발생: ROLLBACK(행위롤백)");
				break;
			case APPROVE:
				msg.append(", 이벤트 발생: APPROVE(문서결재승인)");
				break;
			default:
				msg.append(", 이벤트 발생: "+evntType);
				break;
		}
		
		System.out.println(msg);
		
	}

}
