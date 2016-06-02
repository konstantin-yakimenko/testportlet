package com.vottvoydom.portlets.testportlet;

import java.net.MalformedURLException;
import java.util.Arrays;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


@Controller("TestportletPortletApp")
@RequestMapping({"VIEW"})
public class TestportletPortletController
{
	@Autowired
	private ApplicationContext _applicationContext;
	/*
	 * PortletApplicationContext for namespace 'testportlet-portlet': 
	 * startup date [Thu Jun 02 12:25:40 GMT 2016]; 
	 * parent: Root WebApplicationContext
	 * 
	 * Root WebApplicationContext: startup date [Thu Jun 02 12:55:05 GMT 2016]; 
	 * root of context hierarchy
	 */
	
	
	
	
	@RenderMapping
	public String handleRenderRequest(RenderRequest request, RenderResponse response, Model model)
	    throws MalformedURLException {
		System.out.println("YakimKY --- test portlet");
		ApplicationContext parentApplicationContext = _applicationContext.getParent();
		System.out.println("YakimKY --- app context = " + parentApplicationContext);
		System.out.println("---------------------------------------------------------");
		System.out.println(Arrays.asList(parentApplicationContext.getBeanDefinitionNames()));
		System.out.println("---------------------------------------------------------");
		model.addAttribute("portletResourceUrl", request.getContextPath());
		return "TestportletViewPage";
	}
/*
org.springframework.context.annotation.internalConfigurationAnnotationProcessor, 
org.springframework.context.annotation.internalAutowiredAnnotationProcessor, 
org.springframework.context.annotation.internalRequiredAnnotationProcessor, 
org.springframework.context.annotation.internalCommonAnnotationProcessor, 
org.springframework.context.annotation.internalPersistenceAnnotationProcessor, 
org.springframework.context.event.internalEventListenerProcessor, 
org.springframework.context.event.internalEventListenerFactory, 
org.springframework.web.portlet.mvc.annotation.DefaultAnnotationHandlerMapping#0, 
com.vottvoydom.portlets.testportlet.TestportletPortletController#0, 
org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor, 
org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor

--------------------------------------------------------------------------------------------------------

org.springframework.context.annotation.internalConfigurationAnnotationProcessor, 
org.springframework.context.annotation.internalAutowiredAnnotationProcessor, 
org.springframework.context.annotation.internalRequiredAnnotationProcessor, 
org.springframework.context.annotation.internalCommonAnnotationProcessor, 
org.springframework.context.annotation.internalPersistenceAnnotationProcessor, 
org.springframework.context.event.internalEventListenerProcessor, 
org.springframework.context.event.internalEventListenerFactory, 
messageSource, 
org.springframework.web.portlet.mvc.annotation.DefaultAnnotationHandlerMapping#0, 
templateResolver, 
templateEngine, 
org.thymeleaf.spring4.view.ThymeleafViewResolver#0, 
org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor, 
org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor

 */
}
