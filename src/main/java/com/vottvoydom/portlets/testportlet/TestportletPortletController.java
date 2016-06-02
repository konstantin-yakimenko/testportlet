package com.vottvoydom.portlets.testportlet;

import java.net.MalformedURLException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import org.springframework.web.portlet.ModelAndView;
import com.liferay.portal.kernel.exception.PortalException;


@Controller("TestportletPortletApp")
@RequestMapping({"VIEW"})
public class TestportletPortletController
{
	@RenderMapping
	public String handleRenderRequest(RenderRequest request, RenderResponse response, Model model)
	    throws MalformedURLException {
		model.addAttribute("portletResourceUrl", request.getContextPath());
		return "TestportletViewPage";
	}
}
