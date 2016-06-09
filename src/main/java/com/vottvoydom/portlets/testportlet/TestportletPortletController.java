package com.vottvoydom.portlets.testportlet;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.security.lang.DoPrivilegedFactory;


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
		System.out.println("YakimKY --- app context = " + _applicationContext);
		ApplicationContext ac = _applicationContext.getParent();
		System.out.println("YakimKY --- app parent context = " + ac);
		System.out.println("---------------------------------------------------------");
		System.out.println(Arrays.asList(_applicationContext.getBeanDefinitionNames()));
		System.out.println("--------------------------------------------------------- parent");
		System.out.println(Arrays.asList(ac.getBeanDefinitionNames()));
		System.out.println("---------------------------------------------------------");

/*
YakimKY ---- PortletBeanLocatorUtil setBeanLocator = model-manager-0.0.2.A-SNAPSHOT
YakimKY ---- PortletBeanLocatorUtil setBeanLocator = rlt_offer_details
YakimKY ---- PortletBeanLocatorUtil setBeanLocator = rlt_offer_table
YakimKY ---- PortletBeanLocatorUtil setBeanLocator = testanotherportlet-0.0.2.A-SNAPSHOT
YakimKY ---- PortletBeanLocatorUtil setBeanLocator = testportlet-0.0.2.A-SNAPSHOT
 */
		
		Testbean testbean = (Testbean)_applicationContext.getBean(Testbean.class);
		System.out.println("YakimKY --- founded str = " + testbean.getStr());
		
		BeanLocator locator = com.liferay.portal.kernel.bean.PortletBeanLocatorUtil.getBeanLocator("testanotherportlet-0.0.2.A-SNAPSHOT");
		System.out.println("YakimKY --- locator = " + locator);

		String[] arStr = locator.getNames();
		System.out.println("YakimKY --- locator = " + (new ArrayList<String>(Arrays.asList(arStr))));
	
//		DoPrivilegedFactory dopf = (DoPrivilegedFactory)locator.locate("com.liferay.portal.security.lang.DoPrivilegedFactory");
		
		
		
		try {
			Testbeana testbeana = (Testbeana) locator.locate("testbeananame");
			System.out.println("YakimKY --- founded testbeana Str = " + testbeana.getStr());
//			com.vottvoydom.portlets.testanotherportlet.Anotherbeana a1 = (Anotherbeana) locator.locate("anotherbeanaid");
//			System.out.println("YakimKY --- founded Anotherbeana Str = " + a1.getStr());
//			
//			com.vottvoydom.portlets.testanotherportlet.Anotherbean a2 = (Anotherbean) locator.locate("anotherbeanid");
//			System.out.println("YakimKY --- founded Anotherbean Str = " + a2.getStr());

		} catch(Exception e) {
			System.out.println("exception ---> " + e.getMessage());
		}
		
/*
 YakimKY --- locator = [com.liferay.portal.security.lang.DoPrivilegedFactory]
 exception ---> org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'testbeananame' is defined
 */
		
		
		
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
