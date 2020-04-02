package kr.co.apps;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.apps.service.CbEventType;
import kr.co.apps.service.ServiceRegistry;
import kr.co.apps.service.MyDocument;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ServiceRegistry serviceRegistry;
    
    @Autowired
    MyDocument myDoc;


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
        model.addAttribute("docList", myDoc.selectDocList());		
		model.addAttribute("taskList", serviceRegistry.selectRegistryList());		
		return "home";
	}
	
	@RequestMapping(value = "/subjectEvtExec", method = RequestMethod.POST)
	public String callEvent(Integer docKey, String evntTyp) 
    {
		myDoc.callEvtExecute(docKey,CbEventType.valueOf(evntTyp));

        return "redirect:./";
	}
	
	@RequestMapping(value = "/documentAdd", method = RequestMethod.POST)
	public String subjectAdd(String title, String taskId, Model model) 
    {	
        myDoc.add(title,taskId);
		        
		return "redirect:./";
	}
    
}
