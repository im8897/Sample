package com.sample.form;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/* *
 * ユーザー変更確認画面のリクエストから値を取得する
 * 20182012_松崎作成
 * */

public class UpdateUserForm {
	@Resource
    protected HttpServletRequest request;

	private String selectedId;
	private String selectedName;
	private String selectedAdd;
	private String selectedBd;
	private String changeId;
	private String changeName;
	private String changeAdd;
	private String changeBd;

	public String getSelectedName() {
		return selectedName;
	}

	public void setSelectedName(String selectName) {
		this.selectedName = selectName;
	}

	public String getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(String selectId) {
		this.selectedId = selectId;
	}

	public String getSelectedAdd() {
		return selectedAdd;
	}

	public void setSelectedAdd(String selectedAdd) {
		this.selectedAdd = selectedAdd;
	}

	public String getSelectedBd() {
		return selectedBd;
	}

	public void setSelectedBd(String selectedBd) {
		this.selectedBd = selectedBd;
	}

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}
	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getChangeAdd() {
		return changeAdd;
	}

	public void setChangeAdd(String changeAdd) {
		this.changeAdd = changeAdd;
	}

	public String getChangeBd() {
		return changeBd;
	}

	public void setChangeBd(String changeBd) {
		this.changeBd = changeBd;
	}
}
