package petrsu.smartroom.android.blogclient;

import java.io.Serializable;
import java.util.ArrayList;


import petrsu.smartroom.android.blogclient.xmlrpcclient.*;
import petrsu.smartroom.android.blogclient.arguments.*;
import petrsu.smartroom.android.blogclient.results.*;


public class BlogAdapter implements Serializable{
	
	/** Объект класса из Java-LiveJournalAPI, представляющий удобный xmlrpc-client 
	*
	* Все подключаемые библиотеки нужны для поддержки данного API.
	*/
	private ConvenientClient client;

	/** Тайм-аут для xmlrpc-вызовов в классе ConvenientClient */
	private int timeout;

	/** Флаг аутентификации */
	private boolean loggedIn;

	/** Общий логин для внешнего блог сервиса */
	private String login;

	/** Общий пароль для внешнего блог сервиса */
	private String pass;

	/** Имя пользователя в SR */
	private String SRName;

	/** Текущий логин для внешнего блог сервиса */
	private String curLogin;

	/** Текущий пароль для внешнего блог сервиса */
	private String curPass;

	public BlogAdapter(){
		client = new ConvenientClient(new XMLRPCClientImpl());
		timeout = 0; // пока что отключен
		
		
	}
	
	/**  Проверяет правильность пары логин-пароль, если они подходят, сохраняет в свойства curLogin, curPass 
	*
	* @param login - логин для внешнего блог-сервиса
	* @param password - пароль для внешнего блог-сервиса
	* @return - объект класса UserData, описанного в 4.2 Обмен данными с внешним блог-сервисом
	* @throws LJRuntimeException в случае, если возникли проблемы с сетью на стороне клиента или сервера
	* Вызывает метод login() в ConvenientClient.
	*/
	public UserData login(String login, String password){
		if(login == null || login == "" || password == null || password == "")
			return null;
		else
			return client.login(login, password, timeout);
		
	}
	
	/** Логинится под общими логином и паролем от SR.
	* @throws LJRuntimeException в случае, если возникли проблемы с сетью на стороне клиента или сервера
	* Вызывает метод login() в ConvenientClient.
	*/
	public UserData login(){
		return client.login(login, pass, timeout);
	}

	/**  Возвращает запрошенный у внешнего блог-сервиса пост 
	* @param itemid - идентификатор поста
	* @return - объект класса BlogEntry, описанного в 4.2 Обмен данными с внешним блог-сервисом
	* @throws LJRuntimeException в случае, если возникли проблемы с сетью на стороне клиента или сервера
	* Вызывает метод getBlogEntry() в ConvenientClient.
	*/
	public BlogEntry getBlogEntry(int itemid){
		return client.getBlogEntry(itemid, timeout);
	}

	/**  Возвращает запрошенные у внешнего блог-сервиса комментарии 
	* @param theme - объект класса Theme, для которого нужно получить комментарии
	* @return - массив объектов класса Comment, описанного в 4.2 Обмен данными с внешним блог-сервисом
	* @throws LJRuntimeException в случае, если возникли проблемы с сетью на стороне клиента или сервера
	* Calls for: ConvenientClient.getComments(), Theme.getID().
	*/
	public ThemeComment[] getComments(Theme theme){
		Comment[] c = client.getComments(theme.getID(), theme.getAnum(), timeout);
		ThemeComment[] c1 = new ThemeComment[c.length];
		for (int i = 0; i < c.length; i++)
			c1[i] = new ThemeComment(c[i]);
		//return client.getComments(theme.getID(), theme.getAnum(), timeout);
		return c1;
	}

	/**  Публикует комментарий к посту в блог-сервисе
	* @param body - текст комментария
	* @param theme - объект класса Theme, представляющий тему, к которой добавляется комментарий
	* @return объект класса CommentPostResult, описанного в 4.2 Обмен данными с внешним блог-сервисом
	* @throws LJRuntimeException в случае, если возникли проблемы с сетью на стороне клиента или сервера
	* Вызывает метод addComment() в ConvenientClient.
	*/
	public CommentPostResult postComment(String body, Theme theme){
		if(body == null || body == "" || theme == null)
			return null;
		else
			return client.addComment(body, theme.getID(), theme.getAnum(), timeout);
	}

	/** Устанавливает общие логин и пароль
	* @param login - общий логин на внешнем блог-сервисе (в формате srLogin)
	* @param pass - общий пароль на внешнем блог-сервисе (в формате srPassword)
	* @throws IllegalArgumentException в случае, если хотя бы один из аргументов не соответствует формату
	*/
	public void setLogPass(String login, String pass){
		this.login = login;
		this.pass = pass;
	}

	/** Устанавливает имя пользователя в SR
	* @param name - имя
	*/
	public void setSRName(String name){
		if(name != null && name != "")
			SRName = name;
	}

	/** 
	* Возвращает текущий логин на внешнем блог-сервисе. Если пользователь пользуется общим аккаунтом SR, возвращает пустую строку.
	* @return логин
	*/
	public String getCurLogin(){
		if(login.compareTo(curLogin) == 0)
			return "";
		else
			return curLogin;
	}

}
