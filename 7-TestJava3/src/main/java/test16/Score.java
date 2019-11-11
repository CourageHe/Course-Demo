package test16;

public class Score {
	private String sid;
	private String sname;
	private int score;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Score [sid=" + sid + ", sname=" + sname + ", score=" + score + "]";
	}
	
}
