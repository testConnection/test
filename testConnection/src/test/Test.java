package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String args[]) {
		String gantanhao = "65281";
		System.out.println((char)Integer.parseInt(gantanhao));
//		asciiToStr();
//		strToAscii();
	}

	public static void strToAscii() {// 字符串转换为ASCII码

		String s = "新年快乐！";// 字符串

		char[] chars = s.toCharArray(); // 把字符中转换为字符数组

		System.out.println("\n\n汉字 ASCII\n----------------------");
		for (int i = 0; i < chars.length; i++) {// 输出结果

			System.out.println(" " + chars[i] + " " + (int) chars[i]);
		}
	}
	
	public static void asciiToStr() {// ASCII转换为字符串

		String s = "22307,35806,24555,20048";// ASCII码

		String[] chars = s.split(",");
		System.out.println("ASCII 汉字 \n----------------------");
		for (int i = 0; i < chars.length; i++) {
			System.out.println(chars[i] + " " + (char) Integer.parseInt(chars[i]));
		}
	}
	
	public void testMap() {
		Test test = new Test();
		List<Map<String, Object>> listMap = test.getList();
		List<Object> listUpdateDate = new ArrayList<Object>();
		for (Map<String, Object> map : listMap) {
			listUpdateDate.add(map.get("UPDATE_DATE"));
		}
		listUpdateDate = removeDuplicate(listUpdateDate);
		System.out.println(listUpdateDate);
	}

	public List<Map<String, Object>> getList() {
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		map = new HashMap<String, Object>();
		map.put("STAGE_REPORT_SETTING_ID", "201505220944000037");
		map.put("UPDATE_DATE", "2015/6/5");
		map.put("TIME_INDEX", 1);
		map.put("INPUT_CNT", 1000);
		listMap.add(map);

		map = new HashMap<String, Object>();
		map.put("STAGE_REPORT_SETTING_ID", "201505220944000037");
		map.put("UPDATE_DATE", "2015/6/5");
		map.put("TIME_INDEX", 2);
		map.put("INPUT_CNT", 300);
		listMap.add(map);

		map = new HashMap<String, Object>();
		map.put("STAGE_REPORT_SETTING_ID", "201505220944000037");
		map.put("UPDATE_DATE", "2015/6/5");
		map.put("TIME_INDEX", 3);
		map.put("INPUT_CNT", 700);
		listMap.add(map);

		map = new HashMap<String, Object>();
		map.put("STAGE_REPORT_SETTING_ID", "201505220944000037");
		map.put("UPDATE_DATE", "2015/6/5");
		map.put("TIME_INDEX", 4);
		map.put("INPUT_CNT", 3000);
		listMap.add(map);

		map = new HashMap<String, Object>();
		map.put("STAGE_REPORT_SETTING_ID", "201505220944000037");
		map.put("UPDATE_DATE", "2015/6/5");
		map.put("TIME_INDEX", 5);
		map.put("INPUT_CNT", 200);
		listMap.add(map);

		map = new HashMap<String, Object>();
		map.put("STAGE_REPORT_SETTING_ID", "201505220944000037");
		map.put("UPDATE_DATE", "2015/6/5");
		map.put("TIME_INDEX", 6);
		map.put("INPUT_CNT", 390);
		listMap.add(map);

		map = new HashMap<String, Object>();
		map.put("STAGE_REPORT_SETTING_ID", "201505220944000037");
		map.put("UPDATE_DATE", "2015/6/6");
		map.put("TIME_INDEX", 1);
		map.put("INPUT_CNT", 290);
		listMap.add(map);

		map = new HashMap<String, Object>();
		map.put("STAGE_REPORT_SETTING_ID", "201505220944000037");
		map.put("UPDATE_DATE", "2015/6/6");
		map.put("TIME_INDEX", 3);
		map.put("INPUT_CNT", 190);
		listMap.add(map);

		// map = new HashMap<String,Object>();
		// map.put("STAGE_REPORT_SETTING_ID", "201505290828000059");
		// map.put("UPDATE_DATE", "2015/6/6");
		// map.put("TIME_INDEX", 2);
		// map.put("INPUT_CNT", 90);
		// listMap.add(map);
		//
		// map = new HashMap<String,Object>();
		// map.put("STAGE_REPORT_SETTING_ID", "201505290828000059");
		// map.put("UPDATE_DATE", "2015/6/6");
		// map.put("TIME_INDEX", 3);
		// map.put("INPUT_CNT", 30);
		// listMap.add(map);

		return listMap;
	}

	public static void test() {
		List<Bill> list = new ArrayList<Bill>();
		Bill b = new Bill();
		b.setType("A");
		b.setMoney(1);
		list.add(b);
		b = new Bill();
		b.setType("B");
		b.setMoney(2);
		list.add(b);
		b = new Bill();
		b.setType("C");
		b.setMoney(3);
		list.add(b);
		b = new Bill();
		b.setType("A");
		b.setMoney(1);
		list.add(b);
		b = new Bill();
		b.setType("B");
		b.setMoney(2);
		list.add(b);
		b = new Bill();
		b.setType("C");
		b.setMoney(3);
		list.add(b);

		List<Bill> bi = new ArrayList<Bill>();
		for (Bill bill : list) {
			boolean state = false;
			for (Bill bills : bi) {
				if (bills.getType().equals(bill.getType())) {
					int money = bills.getMoney();
					money += bill.getMoney();
					bills.setMoney(money);
					state = true;
				}
			}
			if (!state) {
				bi.add(bill);
			}
		}
		for (Bill bill : bi) {
			System.out.println(bill.getType() + "    " + bill.getMoney());
		}
	}

	public static List<Object> removeDuplicate(List<Object> list) {
		HashSet<Object> h = new HashSet<Object>(list);
		list.clear();
		list.addAll(h);
		return list;
	}

	public static void twoArray() {
		String[][] a = new String[5][5];
		a[0][0] = "1";
		a[0][1] = "2";
		System.out.println(a);
	}

	public static void testList() {
		List<Object> listA = new ArrayList<Object>();
		listA.add(1);
		listA.add(2);
		listA.add(3);
		listA.add(4);
		listA.add(5);
		listA.add(6);

		listA.add(1);
		listA.add(2);
		listA.add(3);
		listA.add(4);
		listA.add(5);
		listA.add(6);

		listA.add(1);

		int size = listA.size() % 6 != 0 ? listA.size() / 6 + 1 : listA.size() / 6;

		List<LinkedHashMap<String, Object>> list = new ArrayList<LinkedHashMap<String, Object>>();
		for (int i = 0; i < size; i++) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			list.add(map);
		}

		for (int i = 0; i < listA.size(); i++) {
			list.get(i / 6).put("map" + (i % 6 + 1), listA.get(i));
		}

		System.out.println(list);
	}

	public static void println(Object object) {
		System.out.println(object);
	}
}
