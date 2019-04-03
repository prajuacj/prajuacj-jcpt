/**
 * Project Name:prajuacj-common
 * File Name:ValidatorUtils.java
 * Package Name:com.prajuacj.jcpt.common.validator
 * Date:2019年4月1日上午10:11:11
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.common.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.prajuacj.jcpt.common.exception.RRException;

/**
 * ClassName:ValidatorUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年4月1日 上午10:11:11 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public class ValidatorUtils {

	private static Validator validator;

	static {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	/**
	 * 校验对象
	 * 
	 * @param object 待校验对象
	 * @param groups 待校验的组
	 * @throws RRException 校验不通过，则报RRException异常
	 */
	public static void validateEntity(Object object, Class<?>... groups) throws RRException {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
		if (!constraintViolations.isEmpty()) {
			ConstraintViolation<Object> constraint = (ConstraintViolation<Object>) constraintViolations.iterator()
					.next();
			throw new RRException(constraint.getMessage());
		}
	}
}
