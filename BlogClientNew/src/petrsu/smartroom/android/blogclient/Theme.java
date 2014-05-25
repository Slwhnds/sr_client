package petrsu.smartroom.android.blogclient;

import java.io.Serializable;
import java.util.Date;
import petrsu.smartroom.android.blogclient.results.*;

public class Theme implements Serializable {
	
	/** Идентификатор темы для внешнего блог-сервиса */
	private int itemid;
	
	/** Необходимо для получения комментариев */
	private int anum;
	
	/** Статус темы */
	private String status;

	/** Тело(текст) темы */
	public String body;

	/** Заголовок темы */
	public String subject;

	/** Комментарии к теме */
	private ThemeComment[] comments; 

	/** Время доклада */
	public Date time;
	
	public Theme(String subject) {
		this.subject = subject;
	}

	/**  Конструктор. Принимает BlogEntry, забирая из него нужные данные */
	public Theme(BlogEntry post){
		this.itemid = post.getItemid();
		this.anum = post.getAnum();
		this.body = post.getBody();
		this.subject = post.getSubject();
		this.time = post.getDate();

	}
	
	/**  Конструктор. Заполняет поля, получив данные из SmartSpace, после него нужно вызвать getBlogEntry(itemid) 
	 * и как-то заполнить остальные поля 
	 * 
	 * TBD
	 */
	public Theme(int itemid, String status, Date time){
		this.itemid = itemid;
		this.status = status;
		this.time = time;
	}
	

	/**  Конструктор. Заполняет поля. 
	 * 
	 * TBD
	 */
	public Theme(int itemid, String status, Date time, BlogEntry post){
		this.itemid = itemid;
		this.status = status;
		this.time = time;
		
		this.anum = post.getAnum();
		this.body = post.getBody();
		this.subject = post.getSubject();
		this.time = post.getDate();
	}
	
	/**  Конструктор. Заполняет поля
	 * 
	 * TBD
	 */
	public Theme(int itemid, String status, BlogEntry post){
		this.itemid = itemid;
		this.status = status;
		
		this.anum = post.getAnum();
		this.body = post.getBody();
		this.subject = post.getSubject();
		this.time = post.getDate();
	}
	
	
	/** 
	* Возвращает заголовок темы.
	* @return заголовок темы
	*/
	public String getSubject(){
		return this.subject;
	}

	/** 
	* Возвращает текст темы.
	* @return текст темы
	*/
	public String getText(){
		return this.body;
	}

	/** 
	* Возвращает время доклада.
	* @return время доклада
	*/
	public Date getTime(){
		return this.time;
	}

	/** 
	* Возвращает ID темы.
	* @return ID темы
	*/
	public int getID(){
		return this.itemid;
	}
	
	/** 
	* Возвращает anum темы.
	* @return anum темы
	*/
	public int getAnum(){
		return this.anum;
	}

	/** 
	* Устанавливает статус темы.
	* @param status статус темы (в формате themeStatus)
	* @throws IllegalArgumentException, если формат статуса отличается от требуемого
	*/
	public void setStatus(String status){
		this.status = status;
	}

}
