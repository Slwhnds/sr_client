package petrsu.smartroom.android.blogclient;

import java.util.ArrayList;
import java.util.Date;

import petrsu.smartroom.android.blogclient.*;
import petrsu.smartroom.android.blogclient.results.BlogEntry;


public class Blog {
		
	/** —писок тем */
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
	 
	/**  ¬озвращает список заголовков тем.
	* @throws NullPointerException в случае, если какой-либо элемент themes == null
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
	 
	/**  ¬озвращает тему с определенным номером
	* @param i номер темы
	* @return тема, или null, если темы с таким i нет
	*/
	public Theme getTheme(int i){
		if(themes.size() > i)
			return themes.get(i);
		else
			return null;
	}

	/**  ѕолучает список тем и записывает в свойство themes
	* @param items список тем в формате "ID themeStatus"
	* @param adapter адаптер дл€ поучени€ тем из внешнего блог-сервиса
	* @throws LJRuntimeException в случае, если возникли проблемы с сетью на стороне клиента или сервера
	*
	* ¬ызывает методы: в цикле по полученным items getBlogEntry(itemid) в BlogAdapter.java
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
		Date time; // оно нужно еще?
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
