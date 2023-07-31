package com.liferay.portal.object.customization.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.dynamic.data.mapping.form.field.type.constants.DDMFormFieldTypeConstants;
import com.liferay.object.admin.rest.dto.v1_0.ObjectField.BusinessType;
import com.liferay.object.constants.ObjectFieldConstants;
import com.liferay.object.field.business.type.ObjectFieldBusinessType;
import com.liferay.object.model.ObjectField;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.extension.PropertyDefinition;

/**
 * @author Bhargav Vaghasiya
 * 
 * @note When you try to add values in date fields with GraphQL APIs, it will not work in Vanilla Liferay,
 * After adding this class it will start working.
 * 
 * TEMP Fix until liferay provides actual fix
 */

@Component(
		property = {
		        "service.ranking:Integer=100",
		        "object.field.business.type.key=" + ObjectFieldConstants.BUSINESS_TYPE_DATE,
		    },
		service = ObjectFieldBusinessType.class
	)
public class DateObjectFieldBusinessType implements ObjectFieldBusinessType {
	
	private static final Log _log = LogFactoryUtil.getLog(DateObjectFieldBusinessType.class);

	@Override
	public String getDBType() {
		return ObjectFieldConstants.DB_TYPE_DATE;
	}

	@Override
	public String getDDMFormFieldTypeName() {
		return DDMFormFieldTypeConstants.DATE;
	}

	@Override
	public String getDescription(Locale locale) {
		return _language.get(locale, "add-a-date");
	}

	@Override
	public String getLabel(Locale locale) {
		return _language.get(locale, "date");
	}

	@Override
	public String getName() {
		return ObjectFieldConstants.BUSINESS_TYPE_DATE;
	}

	@Override
	public PropertyDefinition.PropertyType getPropertyType() {
		return PropertyDefinition.PropertyType.DATE_TIME;
	}
	
	@Override
	public Object getValue(ObjectField objectField, long userId, Map<String, Object> values) throws PortalException {
		if(objectField.getBusinessType().equalsIgnoreCase(BusinessType.DATE.getValue())) {
			SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			if(Validator.isNotNull(values.get(objectField.getName()))) {
				try {
					return outputFormat.format(inputFormat.parse(String.valueOf(values.get(objectField.getName()))));
				} catch (ParseException e) {
				}
			}
			return ObjectFieldBusinessType.super.getValue(objectField, userId, values);
		} else {
			return ObjectFieldBusinessType.super.getValue(objectField, userId, values);
		}
	}

	@Reference
	private Language _language;

}
