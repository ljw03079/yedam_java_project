package co.yedam.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class User{
	private String id;
	private String pw;
	
	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	//논리동등객체, 재정의 -> hashCode와 id,pw가 같아야 동일객체로 인식
	@Override
	public int hashCode() {
		return this.id.hashCode();//id로 구분하고 16진수로 반환
	}

	@Override
	public boolean equals(Object obj) {
		User target = (User) obj;
		return this.id.equals(target.id) && this.pw.equals(target.pw);
	}
	
}

public class MapExe {
	public static void main(String[] args) {
		//Map: 키 & 값 형식으로 저장
		Map<String, Integer> map = new HashMap<>();//<키 타입,값 타입>
		map.put("홍길동", 80);
		map.put("김길동", 85);
		map.put("박길동", 90);
		
		Integer val = map.get("홍길동");//키를 넣어주면 값을 반환
		System.out.println(val);
		
		List<User> users = new ArrayList<>();
		users.add(new User("user1", "1234"));
		
		Map<String, String> userMap = new HashMap<>();
		userMap.put("user2", "1111");//클래스 만들 필요 없음
		userMap.put("user3", "2222");
		userMap.put("user4", "3333");
		
		if(userMap.containsKey("user2")) {
			System.out.println(userMap.get("user2"));
		}
		
		//key 반환해야 전체값 출력가능
		Set<String> keyset = userMap.keySet();//key 반환 메소드, Set 컬렉션<key타입>
		for(String key : keyset) {
			String value = userMap.get(key);//해당되는 키를 알면 value를 가져올 수 있음
			System.out.printf("key: %s, val: %s\n", key, value);
		}
		
		//map
		Map<User, String> umap = new HashMap<>();
		umap.put(new User("user1","1111"),"홍길동");//키에 User클래스를 담음
		umap.put(new User("user2","2222"),"김길동");
		umap.put(new User("user3","3333"),"박길동");
		
		String name = umap.get(new User("user1","1111"));//값이 똑같더라도 객체는 반환되는 주소값이 항상 다르기때문에 값을 못 가져옴
		//id와 pw가 같으면 논리적 동등임을 User 클래스에 정의
		System.out.println("name: "+name);
		
	}
}
