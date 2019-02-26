/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.sample.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.sample.form.DeleteForm;
import com.sample.service.UserService;

public class DangerAction{
	//matsuzaki.add 課題2 ユーザー削除処理クラス
	@Resource
    protected HttpServletRequest request;

	/** 削除時のForm */
	 @ActionForm
	 public DeleteForm DeleteForm;

	/** ユーザ情報操作用サービスクラス */
	@Resource
	UserService userService;

	/** ユーザー削除メソッド */
	@Execute(validator = false, input = "deleted.jsp")
	public String delete() {
		String deleteId = DeleteForm.getSelectedId();
		userService.deleteUser(deleteId);
		return "deleted.jsp";
	}
}

