package org.md.dto;

public class Btraffic {

	private String tno;
	private String ttype;
	private String no;
	private String route;
	private String coment;
	public Btraffic() {}
	public Btraffic(String tno, String ttype, String no, String route, String coment) {
		super();
		this.tno = tno;
		this.ttype = ttype;
		this.no = no;
		this.route = route;
		this.coment = coment;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getComent() {
		return coment;
	}
	public void setComent(String coment) {
		this.coment = coment;
	}
	@Override
	public String toString() {
		return "Btraffic [tno=" + tno + ", ttype=" + ttype + ", no=" + no + ", route=" + route + ", coment=" + coment
				+ "]";
	}
}
