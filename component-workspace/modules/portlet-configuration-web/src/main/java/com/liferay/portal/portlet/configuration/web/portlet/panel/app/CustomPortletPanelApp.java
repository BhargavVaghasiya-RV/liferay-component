package com.liferay.portal.portlet.configuration.web.portlet.panel.app;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.portlet.configuration.web.constants.PortletConfigurationWebPortletKeys;


/**
 * @author Bhargav Vaghasiya
 * Note : This class is used to add portlet into Liferay's control panel
 */
@Component(
		property = {
			"panel.app.order:Integer=100",
			"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
		},
		service = PanelApp.class
	)
public class CustomPortletPanelApp extends BasePanelApp  {
	@Override
	public Portlet getPortlet() {
		return _portlet;
	}

	@Override
	public String getPortletId() {
		return PortletConfigurationWebPortletKeys.PORTLET_CONFIGURATION_WEB_PORTLET_KEY;
	}

	@Reference(
		target = "(javax.portlet.name=" + PortletConfigurationWebPortletKeys.PORTLET_CONFIGURATION_WEB_PORTLET_KEY + ")"
	)
	private Portlet _portlet;
}
