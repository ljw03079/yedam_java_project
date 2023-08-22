package co.yedam.board;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserServiceImpl implements UserService {
	List<User> userList = new ArrayList<>();

	UserServiceImpl(){
		loadFile();
	}
	void loadFile() {
		try {
			FileReader fr = new FileReader("C:/temp/users.txt");
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String str = br.readLine();//버퍼에는 한줄씩 읽는 기능이 있음
				if(str == null) {
					break;
				}
				String[] data = str.split(" ");
				userList.add(new User(data[0],data[1],data[2]));
			}
			fr.close();
		}catch(Exception e) {
			
		}
	}
	@Override
	public boolean checkLogin(User user) {
		for(int i=0; i<userList.size(); i++) {
			if(userList.get(i).getUserId().equals(user.getUserId())) {
				if(userList.get(i).getUserPw().equals(user.getUserPw())) {
					return true;
				}
			}
		}
		return false;
	}
}
