package co.yedam.board;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReplyServiceImpl implements ReplyService{

	List<Reply> replyList = new ArrayList<>();
	
	public ReplyServiceImpl() {
		init();
	}
	
	private void init() {
		try {
			FileInputStream fis = new FileInputStream("C:/temp/reply.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			replyList = (List<Reply>) ois.readObject();
			fis.close();
			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	private int getRpMaxNo() {
		int rpNo = 0;
		for(int i=0; i<replyList.size(); i++) {
			if(replyList.get(i).getRpNo() > rpNo) {
				rpNo = replyList.get(i).getRpNo();
			}
		}
		return rpNo + 1;
	}
	@Override
	public boolean rpAdd(Reply reply) {
		reply.setRpNo(getRpMaxNo());
		return replyList.add(reply);
	}

	@Override
	public List<Reply> rpList() {
		return replyList;
	}

	@Override
	public boolean rpRemove(int rpNo) {
		for(int i=0; i<replyList.size();i++) {
			if(replyList.get(i).getRpNo() == rpNo) {
				replyList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void rpSave() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/reply.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(replyList);
			oos.flush(); oos.close();
			fos.flush(); fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean rpSearch(int brdNo) {
		for(int i=0; i<replyList.size(); i++) {
			if(replyList.get(i).getBrdNo() == brdNo) {
				System.out.println(replyList.get(i).showInfo());
			}
		}
		return true;
	}
}
