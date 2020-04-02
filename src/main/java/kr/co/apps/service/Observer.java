package kr.co.apps.service;

import kr.co.apps.vo.*;

public interface Observer {
	public void register();
	public void update(MyDocumentVo docVo, CbEventType evntType);
}
