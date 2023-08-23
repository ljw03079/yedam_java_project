package co.yedam.board;

import java.util.List;

public interface ReplyService {
	public boolean rpAdd(Reply reply);
	public List<Reply> rpList();
	public boolean rpRemove(int rpNo);
	public boolean rpSearch(int brdNo);
	public void rpSave();
}