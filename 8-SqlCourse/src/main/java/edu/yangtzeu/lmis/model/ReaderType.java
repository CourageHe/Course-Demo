package edu.yangtzeu.lmis.model;
/**
 * 读者类型实体类
 * @author CourageHe
 *
 */
public class ReaderType extends AbstractModel {
	private int rdType;
	private String rdTypeName;
	private int canLendQty;
	private int canLendDay;
	private int canContinueTimes;
	private float punishRate;
	private int dateValid;
	public ReaderType(){
		
	}
	//复制构造函数
	public ReaderType(ReaderType rt) {
		setCanContinueTimes(rt.getCanContinueTimes());
		setCanLendDay(rt.getCanLendDay());
		setCanLendQty(rt.getCanLendQty());
		setDateValid(rt.getDateValid());
		setPunishRate(rt.getPunishRate());
		setRdType(rt.getRdType());
		setRdTypeName(rt.getRdTypeName());
	}
	public int getRdType() {
		return rdType;
	}
	public void setRdType(int rdType) {
		this.rdType = rdType;
	}
	public String getRdTypeName() {
		return rdTypeName;
	}
	public void setRdTypeName(String rdTypeName) {
		this.rdTypeName = rdTypeName;
	}
	public int getCanLendQty() {
		return canLendQty;
	}
	public void setCanLendQty(int canLendQty) {
		this.canLendQty = canLendQty;
	}
	public int getCanLendDay() {
		return canLendDay;
	}
	public void setCanLendDay(int canLendDay) {
		this.canLendDay = canLendDay;
	}
	public int getCanContinueTimes() {
		return canContinueTimes;
	}
	public void setCanContinueTimes(int canContinueTimes) {
		this.canContinueTimes = canContinueTimes;
	}
	public  float getPunishRate() {
		return punishRate;
	}
	public void setPunishRate( float punishRate) {
		this.punishRate = punishRate;
	}
	public int getDateValid() {
		return dateValid;
	}
	public void setDateValid(int dateValid) {
		this.dateValid = dateValid;
	}
	@Override
	public String toString() {
		return getRdTypeName();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ReaderType) {
			ReaderType dp= (ReaderType) obj;
			return this.rdType == dp.rdType;
			
		}
		return false;
	}
	
}
