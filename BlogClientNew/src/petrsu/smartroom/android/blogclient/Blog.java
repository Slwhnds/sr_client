package petrsu.smartroom.android.blogclient;

import java.util.ArrayList;
import java.util.Date;

import petrsu.smartroom.android.blogclient.*;
import petrsu.smartroom.android.blogclient.results.BlogEntry;


public class Blog {
		
	/** ������ ��� */
	private ArrayList<Theme> themes = new ArrayList<Theme>();
	
	//for test
	public String[] getTestThemes() {
		String[] t = {"theme1", "theme2", "theme3"};
		return t;
	}
	
	//for test
	public void setTestThemes(String[] t) {
		themes = new ArrayList<Theme>();
		if (t == null) {
			themes = null;
			return;
		}
		for(int i = 0; i < t.length; i++) {
			Theme tm;
			if (t[i] == null)
				tm = null;
			else 
				tm = new Theme(t[i]);
			add(tm);
		}
	}
	 
	/**  ���������� ������ ���������� ���.
	* @throws NullPointerException � ������, ���� �����-���� ������� themes == null
	*
	* Calls for: Theme.getSubject()
	*/
	public String[] getThemeSubjects(){
		int count = themes.size();
		String[] subjects = new String[count];
		for(int i = 0; i < count; i++){
			Theme theme = themes.get(i);
			if(theme != null){
				subjects[i] = theme.getSubject();
			}
			else{
				throw new NullPointerException("ArrayList themes contained null pointers");			
			}
		}
		return subjects;
		
	}
	
	public void add(Theme t) {
		themes.add(t);
	}
	 
	/**  ���������� ���� � ������������ �������
	* @param i ����� ����
	* @return ����, ��� null, ���� ���� � ����� i ���
	*/
	public Theme getTheme(int i){
		if(themes.size() > i)
			return themes.get(i);
		else
			return null;
	}

	/**  �������� ������ ��� � ���������� � �������� themes
	* @param items ������ ��� � ������� "ID themeStatus"
	* @param adapter ������� ��� �������� ��� �� �������� ����-�������
	* @throws LJRuntimeException � ������, ���� �������� �������� � ����� �� ������� ������� ��� �������
	*
	* �������� ������: � ����� �� ���������� items getBlogEntry(itemid) � BlogAdapter.java
	*/
	public void setThemes(String[] items, BlogAdapter adapter){	
		
		if(themes == null){
			themes = new ArrayList<Theme>();
		}else{
			themes.clear();
		}
		
		int itemsCount = items.length;
		int itemID;
		String status;
		Date time; // ��� ����� ���?
		BlogEntry theme;
		String[] item;
		for(int i = 0; i < itemsCount; i++){
			item = items[i].split(" ");
			if(item != null && item.length == 2){
				itemID = Integer.parseInt(item[0]);
				status = item[1];
				theme = adapter.getBlogEntry(itemID);
				themes.add(new Theme(itemID, status, theme));
			}		
		}
	}
}
