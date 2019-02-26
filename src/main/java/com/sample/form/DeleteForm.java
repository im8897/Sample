package com.sample.form;

/* *
 * ユーザー削除確認画面のリクエストから値を取得する
 * 20182012_松崎作成
 * */

public class DeleteForm {

	private String selectedId;
	private String selectedName;

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

}
