/*
DO NOT MODIFY THE CODE STUB
NO NEED TO DEFINE main()
*/

import java.util.*;

class StreamingApp
{	
	
	public static Map<String, ArrayList<String> > getFavouriteGenres(Map<String, ArrayList<String> > userMovies, Map<String, ArrayList<String> > movieGenres)
	{	
		String sbuf;
		Map<String, ArrayList<String>> fav = new HashMap<String, ArrayList<String>>();
		Map<String, Integer> count = new HashMap<String, Integer>();
		Map<String, String> m2g = new HashMap<String, String>();
		for(Map.Entry<String, ArrayList<String>> entry: movieGenres.entrySet()){
			sbuf=entry.getKey();
			for(int i=0; i<entry.getValue().size(); i++){
				m2g.put(entry.getValue().get(i), sbuf);
			}
		}
		int m, buf;
		String user;
		for(Map.Entry<String, ArrayList<String>> entry1: userMovies.entrySet()){
			m=0;
			user= entry1.getKey();
			fav.put(user, new ArrayList<String>());
			for(int i=0; i<entry1.getValue().size(); i++){
				sbuf=m2g.get(entry1.getValue().get(i));
				count.merge(sbuf, 1, Integer::sum);
				buf=count.get(sbuf);
				if(buf==m){
					fav.get(user).add(sbuf);
				}
				else if(buf>m){
					m=buf;
					fav.get(user).clear();
					fav.get(user).add(sbuf);
				}
			}
			count.clear();
		}
		return fav;
	}
}