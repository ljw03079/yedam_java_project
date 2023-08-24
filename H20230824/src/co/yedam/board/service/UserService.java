package co.yedam.board.service;

import co.yedam.board.vo.User;

public interface UserService {
	public User checkLogin(User user);
	public void initPassword(User user);
	public void save();
}
