package co.yedam.board.service;

import java.util.List;

import co.yedam.board.vo.Reply;

public interface ReplyService {
	public boolean rpAdd(Reply reply);
	public List<Reply> rpList();
	public boolean rpRemove(int rpNo);
	public boolean rpSearch(int brdNo);
	public void rpSave();
}