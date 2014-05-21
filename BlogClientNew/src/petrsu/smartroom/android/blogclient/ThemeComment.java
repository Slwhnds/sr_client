package petrsu.smartroom.android.blogclient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import petrsu.smartroom.android.blogclient.results.Comment;

public class ThemeComment {

	/** ������������� ����������� ��� �������� ����-������� */
	private int dtalkid;

	/** ����(�����) ����������� */
	public String body;

	/** ����� ����������� */
	public String posterName;

	/** ������������� ������ ����������� */
	public int posterid;

	/** ����� � ���� ����������� */
	public Date time;

	/** 
	* ���������� ����� �����������.
	* @return ����� �����������
	*/
	public String getText(){
		return body;
	}

	/** 
	* ���������� ��� ������ �����������.
	* @return ��� ������ �����������
	*/
	public String getPosterName(){
		return posterName;
	}

	/** 
	* ���������� ����� � ���� ���������� �����������.
	* @return ����� � ���� ���������� �����������
	*/
	public Date getTime(){
		return time;
	}

	/** 
	* �����������, ��������� ������ ������ Comment(������� �������� ������� API) � ��������� ��� ��������.
	* @throws NullPointerException, ���� comment == null
	*/
	public ThemeComment(Comment comment){
		this.body = comment.getBody();
		this.posterid = comment.getPosterid();
		this.posterName = comment.getPostername();
		this.time = comment.getDate();
		this.dtalkid = comment.getDtalkid();
	}
	
	//for test
	public ThemeComment(String body, String name, String date){
		this.body = body;
		this.posterName = name;
		try {
			this.time =new SimpleDateFormat("hh:mm").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
