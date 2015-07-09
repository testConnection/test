package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 集合分组测试
 * 
 */
public class GroupTest {
	public static List<List<Object[]>> groupList(List<Object[]> list, int index) {
		if (list == null)
			return null;
		Map<Object, List<Object[]>> map = new HashMap<Object, List<Object[]>>();
		for (int i = 0; i < list.size(); i++) {
			Object key = map.get(list.get(i)[index].toString());
			List<Object[]> temp = null;
			if (key == null) {
				temp = new ArrayList<Object[]>();
				temp.add(list.get(i));
				map.put(list.get(i)[0].toString(), temp);
			} else {
				temp = (ArrayList<Object[]>) map.get(list.get(i)[index]
						.toString());
				temp.add(list.get(i));
				map.put(list.get(i)[0].toString(), temp);
			}
		}
		if (map == null)
			return null;
		Iterator it = map.keySet().iterator();
		Object obj = null;
		List<List<Object[]>> resList = new ArrayList<List<Object[]>>();
		while (it.hasNext()) {
			obj = it.next();
			if (obj != null)
				resList.add(map.get(obj));
		}
		return resList;
	}
}