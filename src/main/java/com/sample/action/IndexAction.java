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

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.util.StringUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.sample.dto.UserDto;
import com.sample.form.UserRegisterForm;
import com.sample.service.UserService;

public class IndexAction {

	/** 新規登録時のForm */
	 @ActionForm
	 public UserRegisterForm userRegisterForm;

	/** 画面表示用ユーザリスト */
	public List<UserDto> userList;

	/** ユーザ情報操作用サービスクラス */
	@Resource
	UserService userService;

	/** 初期常時メソッド */
	@Execute(validator = false)
	public String index() {
		userList = userService.getAllUsers();

		return "index.jsp";
	}

	/** 登録時メソッド */
	//matsuzaki.Modify 課題１validate要素使用
	@Execute(validator = true, validate = "validate", input = "index.jsp")
	public String register() {
		String name = userRegisterForm.getName();
		int LatestId = userService.getLatestId().getUserId();
		userService.registNewUser(name,LatestId);
		userList = userService.getAllUsers();

		return "index.jsp";
	}

	/** 確認時メソッド */
	//matsuzaki.Modify 課題2 確認画面遷移
	@Execute(validator = false,input = "danger.jsp")
	public String danger() {
		return "danger.jsp";
	}

	/** 確認時メソッド */
	//matsuzaki.Modify 課題2 確認画面遷移
	@Execute(validator = false,input = "detail.jsp")
	public String detail() {

		return "detail.jsp";
	}

	/** Validatteメソッド */
	//matsuzaki.add 課題１入力チェックメソッド使用
	public ActionMessages validate() {
		ActionMessages actionMessages = new ActionMessages();
		String name = userRegisterForm.getName();
		userList = userService.getAllUsers();
		if(StringUtil.isEmpty(name)){
			//入力文字数0チェックNG
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("errors.required","お名前"));
		}
		else if(name.length() >= 45){
			//入力文字数45NG
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("errors.maxlength","お名前","45"));
		}
		for(int i =0; i<userList.size(); i++){
			//入力名既存登録有NG
			String UserDtoName = userList.get(i).getName();
			if(UserDtoName.equals(name)){
				actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("labels.registed"));
				break;
			}
		}
		return actionMessages;
	}

}

