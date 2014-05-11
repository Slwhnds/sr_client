package petrsu.smartroom.android.blogclient;

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
	
}
