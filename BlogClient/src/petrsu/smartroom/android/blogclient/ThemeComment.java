package petrsu.smartroom.android.blogclient;

import java.util.Date;

import petrsu.smartroom.android.blogclient.results.Comment;

public class ThemeComment {

	/** Идентификатор комментария для внешнего блог-сервиса */
	private int dtalkid;

	/** Тело(текст) комментария */
	public String body;

	/** Автор комментария */
	public String posterName;

	/** Идентификатор автора комментария */
	public int posterid;

	/** Время и дата комментария */
	public Date time;

	/** 
	* Возвращает текст комментария.
	* @return текст комментария
	*/
	public String getText(){
		return body;
	}

	/** 
	* Возвращает имя автора комментария.
	* @return имя автора комментария
	*/
	public String getPosterName(){
		return posterName;
	}

	/** 
	* Возвращает время и дату публикации комментария.
	* @return время и дату публикации комментария
	*/
	public Date getTime(){
		return time;
	}

	/** 
	* Конструктор, разбирает объект класса Comment(который является классом API) и заполняет все свойства.
	* @throws NullPointerException, если comment == null
	*/
	public ThemeComment(Comment comment){
		this.body = comment.getBody();
		this.posterid = comment.getPosterid();
		this.posterName = comment.getPostername();
		this.time = comment.getDate();
		this.dtalkid = comment.getDtalkid();
	}
	
}
