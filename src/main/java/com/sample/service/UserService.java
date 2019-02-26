package com.sample.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.seasar.extension.jdbc.JdbcManager;

import com.sample.dto.UserDto;

/** ユーザ関連サービスクラス */
public class UserService {

	/** JdbcManager */
	public JdbcManager jdbcManager;

	/** ユーザ全件取得用SQL */
	private static final String SQL_GET_ALL_USERS = "sql/getAllUsers.sql";
	/** ユーザ登録用SQL */
	private static final String SQL_REGIST_NEW_USERS = "sql/registNewUser.sql";
	/** ユーザ削除用SQL */
	private static final String SQL_DELETE_USERS = "sql/deleteUser.sql";
	/** ユーザ変更用SQL */
	private static final String SQL_UPDATE_USERS = "sql/updateUser.sql";
	/** 最新ユーザ取得用SQL */
	private static final String SQL_LATEST_USERID = "sql/getLatestUserId.sql";
	/** 更新ユーザ取得用SQL */
	private static final String SQL_UPDETED_USER = "sql/getUpdetedUser.sql";


	/**
	 * ユーザ取得
	 *
	 * @return ユーザの一覧(全件)
	 * */
	public List<UserDto> getAllUsers() {

		List<UserDto> results =
				jdbcManager
					.selectBySqlFile(
						UserDto.class,
						SQL_GET_ALL_USERS)
					.getResultList();

		return results;
	}

	/**
	 * 最新ユーザ取得
	 *
	 * @return 最新の登録user_id
	 * */
	public UserDto getLatestId() {

		UserDto results =
			    jdbcManager
			        .selectBySqlFile(
			            UserDto.class,
			            SQL_LATEST_USERID)
			        .getSingleResult();

		return results;
	}

	/**
	 * 更新ユーザ取得
	 *
	 * @return 更新ユーザの登録user_id
	 * */
	public UserDto getUpdatedUser(int id) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", id);
		UserDto results =
			    jdbcManager
			        .selectBySqlFile(
			            UserDto.class,
			            SQL_UPDETED_USER,param)
			        .getSingleResult();


		return results;
	}

	/**
	 * ユーザ登録処理
	 *
	 * @param name ユーザ名
	 * @return id ユーザid
	 * */
	public int registNewUser(String name,int id) {

		// TODO: ここの実装イケてない。
//		int total = (int)jdbcManager.getCountBySqlFile(SQL_GET_ALL_USERS);
//		total++;


		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", id);
		param.put("name", name);

		return jdbcManager.updateBySqlFile(SQL_REGIST_NEW_USERS, param).execute();
	}

	/**
	 * ユーザ削除処理
	 *
	 * @param id ユーザid
	 * @param name ユーザ名
	 * @return 削除処理
	 * */
	public int deleteUser(String id) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", id);

		return jdbcManager.updateBySqlFile(SQL_DELETE_USERS, param).execute();
	}

	/**
	 * ユーザ情報変更処理
	 *
	 * @param id ユーザid
	 * @param name ユーザ名
	 * @param add 住所
	 * @param birth 生年月日
	 * @return 変更処理
	 * */
	public int updateUser(String id,String name,String add, Date birth) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", id);
		param.put("name", name);
		param.put("address", add);
		param.put("birthDay", birth);

		return jdbcManager.updateBySqlFile(SQL_UPDATE_USERS, param).execute();
	}
}
