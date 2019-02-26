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

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.util.StringUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.sample.dto.UserDto;
import com.sample.form.UpdateUserForm;
import com.sample.service.UserService;

public class DetailAction{
	//matsuzaki.add 課題3ユーザー情報編集・更新処理クラス
	@Resource
    protected HttpServletRequest request;

	/** 削除時のForm */
	 @ActionForm
	 public UpdateUserForm updateUserForm;

	/** ユーザ情報操作用サービスクラス */
	@Resource
	UserService userService;

	/** 既存確認用ユーザリスト */
	public List<UserDto> userList;

	/** 既存確認用ユーザリスト */
	public UserDto updateUser;

	/** ユーザー変更メソッド */
	@Execute(validator = false, input = "change.jsp")
	public String index() {
		return "change.jsp";
	}

	/** ユーザー変更メソッド */
	@Execute(validator = true, validate = "validate", input = "change.jsp")
	public String change() {
		String selectedId = updateUserForm.getSelectedId();
		String selectedName = updateUserForm.getChangeName();
		String selectedAdd = updateUserForm.getChangeAdd();
		String selectedBd =updateUserForm.getChangeBd();
		userService.updateUser(selectedId, selectedName, selectedAdd, Date.valueOf(selectedBd));
		updateUser = userService.getUpdatedUser(Integer.parseInt(selectedId));
		return "fixed.jsp";
	}

	/** Validatteメソッド */
	public ActionMessages validate() {
		ActionMessages errors = new ActionMessages();
		String name = updateUserForm.getChangeName();
		String selectedAdd = updateUserForm.getChangeAdd();
		String selectedBd =updateUserForm.getChangeBd();
		userList = userService.getAllUsers();
		//名前
		//入力文字数0チェックNG
		if(StringUtil.isEmpty(name)){
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("errors.required","お名前"));
		}
		//入力文字数45以上NG
		else if(name.length() >= 45){
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("errors.maxlength","お名前","45"));
		}
		//住所
		//入力文字数50以上NG
		if(selectedAdd.length() >= 50){
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("errors.maxlength","ご住所","50"));
		}
		//生年月日
		//入力形式NG
		if(!selectedBd.isEmpty()){
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			df.setLenient(false);
			String s1 = selectedBd; // ←ここが画面などからの入力値になる
			String s2;
			try {
				s2 = df.format(df.parse(s1));
			} catch (ParseException e) {
				// 日付チェックエラー
				errors.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("labels.incollectdate"));
			}
			return errors;
		}
		return errors;
	}

}


