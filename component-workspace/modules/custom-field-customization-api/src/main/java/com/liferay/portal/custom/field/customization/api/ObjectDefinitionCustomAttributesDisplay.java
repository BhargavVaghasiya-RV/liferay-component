package com.liferay.portal.custom.field.customization.api;

import org.osgi.service.component.annotations.Component;

import com.liferay.expando.kernel.model.BaseCustomAttributesDisplay;
import com.liferay.expando.kernel.model.CustomAttributesDisplay;
import com.liferay.object.constants.ObjectPortletKeys;
import com.liferay.object.model.ObjectDefinition;

/**
 * @author Bhargav Vaghasiya
 * 
 * @note Using this type of class you can manage the custom fields for custom entities that you created using Liferay Service Builder
 * 
 */

@Component(
		property = "javax.portlet.name=" + ObjectPortletKeys.OBJECT_DEFINITIONS,
		service = CustomAttributesDisplay.class
	)
public class ObjectDefinitionCustomAttributesDisplay extends BaseCustomAttributesDisplay {

	@Override
	public String getClassName() {
		return ObjectDefinition.class.getName();
	}
	
	@Override
	public String getIconCssClass() {
		return "relationship";
	}

}
