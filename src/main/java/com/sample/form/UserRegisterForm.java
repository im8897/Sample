package com.sample.form;


public class UserRegisterForm {
	private String name;

/*20190212ユーザー削除用に松崎追記
 * @param selectedId
 * @param selectedName
 */
	private String selectedId;
	private String selectedName;
	private String selectedAdd;
	private String selectedBd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*20190212ユーザー削除用に松崎追記
 * method getSelectedName
 * method getSelectedId
 */
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

/*20190212ユーザー詳細用に松崎追記
 * method getSelectedName
 * method getSelectedId
 */
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
}
