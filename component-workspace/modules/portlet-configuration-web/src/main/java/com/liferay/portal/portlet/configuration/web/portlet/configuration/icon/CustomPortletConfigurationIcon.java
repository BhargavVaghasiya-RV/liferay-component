package com.liferay.portal.portlet.configuration.web.portlet.configuration.icon;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.configuration.icon.BasePortletConfigurationIcon;
import com.liferay.portal.kernel.portlet.configuration.icon.PortletConfigurationIcon;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.portlet.configuration.web.constants.PortletConfigurationWebPortletKeys;


/**
 * @author Bhargav Vaghasiya
 * Note : This class is used to add custom action icon for portlet on top right corner
 */

@Component(property = { "javax.portlet.name=" + PortletConfigurationWebPortletKeys.PORTLET_CONFIGURATION_WEB_PORTLET_KEY, },

		service = PortletConfigurationIcon.class)
public class CustomPortletConfigurationIcon extends BasePortletConfigurationIcon {

	@Override
	public boolean isShow(PortletRequest portletRequest) {
		// Your permission checker logic
		return true;
	}

	@Override
	public String getURL(PortletRequest portletRequest, PortletResponse portletResponse) {
		return PortletURLBuilder.createRenderURL(_portal.getLiferayPortletResponse(portletResponse))
				.setMVCPath("/configuration/icon/popup.jsp").setWindowState(LiferayWindowState.POP_UP).buildString();
	}

	@Override
	public double getWeight() {
		return 100;
	}

	@Override
	public String getMessage(PortletRequest portletRequest) {
		return _language.get(getLocale(portletRequest), "custom-action");
	}

	@Override
	public String getIconCssClass() {
		return "cog";
	}

	@Override
	public boolean isUseDialog() {
		return true;
	}

	@Reference
	private Language _language;

	@Reference
	private Portal _portal;
}
