package petrsu.smartroom.android.blogclient;

import java.util.Date;
import petrsu.smartroom.android.blogclient.results.*;

public class Theme {
	
	/** ������������� ���� ��� �������� ����-������� */
	private int itemid;
	
	/** ���������� ��� ��������� ������������ */
	private int anum;
	
	/** ������ ���� */
	private String status;

	/** ����(�����) ���� */
	public String body;

	/** ��������� ���� */
	public String subject;

	/** ����������� � ���� */
	private Comment[] comments; 

	/** ����� ������� */
	public Date time;

	/**  �����������. ��������� BlogEntry, ������� �� ���� ������ ������ */
	public Theme(BlogEntry post){
		this.itemid = post.getItemid();
		this.anum = post.getAnum();
		this.body = post.getBody();
		this.subject = post.getSubject();
		this.time = post.getDate();

	}
	
	/**  �����������. ��������� ����, ������� ������ �� SmartSpace, ����� ���� ����� ������� getBlogEntry(itemid) 
	 * � ���-�� ��������� ��������� ���� 
	 * 
	 * TBD
	 */
	public Theme(int itemid, String status, Date time){
		this.itemid = itemid;
		this.status = status;
		this.time = time;
	}
	

	/** 
	* ���������� ��������� ����.
	* @return ��������� ����
	*/
	public String getSubject(){
		return this.subject;
	}

	/** 
	* ���������� ����� ����.
	* @return ����� ����
	*/
	public String getText(){
		return this.body;
	}

	/** 
	* ���������� ����� �������.
	* @return ����� �������
	*/
	public Date getTime(){
		return this.time;
	}

	/** 
	* ���������� ID ����.
	* @return ID ����
	*/
	public int getID(){
		return this.itemid;
	}
	
	/** 
	* ���������� anum ����.
	* @return anum ����
	*/
	public int getAnum(){
		return this.anum;
	}

	/** 
	* ������������� ������ ����.
	* @param status ������ ���� (� ������� themeStatus)
	* @throws IllegalArgumentException, ���� ������ ������� ���������� �� ����������
	*/
	public void setStatus(String status){
		this.status = status;
	}

}
