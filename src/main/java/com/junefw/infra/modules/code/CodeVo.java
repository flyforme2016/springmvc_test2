package com.junefw.infra.modules.code;

public class CodeVo {
	
//  infrCodeGroup
	private String ifcgSeq;
	
//  infrCodeGroup search
	private String shIfcgName;
	private Integer shIfcgDelNy;
	
//  infrCode
	private String ifcdSeq;
	
//  infrCode search
	private String shIfcgSeq;
	
//  common
	private String shOption;
	private String shValue;
	
//	paging
	private int thisPage = 1;					// 현재 페이지
	private int rowNumToShow = 10;				// 화면에 보여줄 데이터 줄 갯수, limit에 두번째 파라미터
	private int pageNumToShow = 5;				// 화면에 보여줄 페이징 번호 갯수
	
	private int totalRows;						// 전체 데이터 갯수
	private int totalPages;						// 전체 페이지 번호
	private int startPage;						// 시작 페이지 번호
	private int endPage;						// 마지막 페이지 번호
	
	private int startRnumForOracle = 1;			// 쿼리 시작 row
	private int endRnumForOracle;				// 쿼리 끝 row
	private Integer RNUM;
	
	private int startRnumForMysql = 0;			// 쿼리 시작 row, limit에 첫번재 파라미터
	
//------------

	public void setParamsPaging(int totalRowsParam) {
		
		totalRows = totalRowsParam;

		totalPages = totalRows / rowNumToShow;

		if (totalRows % rowNumToShow > 0) {
			totalPages = totalPages+ 1;
		}

		if (totalPages < thisPage) {
			thisPage = totalPages;
		}
		
		startPage = (((thisPage - 1) / pageNumToShow) * pageNumToShow + 1);

		endPage = (startPage + pageNumToShow - 1);

		if (endPage > totalPages) {
			endPage = (totalPages);
		}
		
		endRnumForOracle = ((rowNumToShow * thisPage));
		startRnumForOracle = ((endRnumForOracle - rowNumToShow) + 1);
		if (startRnumForOracle < 1) startRnumForOracle = 1;
		
		
		if (thisPage == 1) {
			startRnumForMysql = 0;
		} else {
			startRnumForMysql = ((rowNumToShow * (thisPage-1)));
		}
		
		System.out.println("getThisPage():" + thisPage);
		System.out.println("getTotalRows():" + totalRows);
		System.out.println("getRowNumToShow():" + rowNumToShow);
		System.out.println("getTotalPages():" + totalPages);
		System.out.println("getStartPage():" + startPage);
		System.out.println("getEndPage():" + endPage);		
		System.out.println("getStartRnumForOracle():" + startRnumForOracle);
		System.out.println("getEndRnumForOracle():" + endRnumForOracle);
		System.out.println("getStartRnumForMysql(): " + startRnumForMysql);
		
	}
	
	public String getIfcgSeq() {return ifcgSeq;}
	public void setIfcgSeq(String ifcgSeq) {this.ifcgSeq = ifcgSeq;}
	
	public String getIfcdSeq() {return ifcdSeq;}
	public void setIfcdSeq(String ifcdSeq) {this.ifcdSeq = ifcdSeq;}
	
	public String getShIfcgName() {return shIfcgName;}
	public void setShIfcgName(String shIfcgName) {this.shIfcgName = shIfcgName;}
	
	public Integer getShIfcgDelNy() {return shIfcgDelNy;}
	public void setShIfcgDelNy(Integer shIfcgDelNy) {this.shIfcgDelNy = shIfcgDelNy;}
	
	public String getShIfcgSeq() {return shIfcgSeq;}
	public void setShIfcgSeq(String shIfcgSeq) {this.shIfcgSeq = shIfcgSeq;}
	
	public String getShOption() {return shOption;}
	public void setShOption(String shOption) {this.shOption = shOption;}
	
	public String getShValue() {return shValue;}
	public void setShValue(String shValue) {this.shValue = shValue;}

	public int getThisPage() {return thisPage;}
	public void setThisPage(int thisPage) {this.thisPage = thisPage;}

	public int getRowNumToShow() {return rowNumToShow;}
	public void setRowNumToShow(int rowNumToShow) {this.rowNumToShow = rowNumToShow;}

	public int getPageNumToShow() {return pageNumToShow;}
	public void setPageNumToShow(int pageNumToShow) {this.pageNumToShow = pageNumToShow;}

	public int getTotalRows() {return totalRows;}
	public void setTotalRows(int totalRows) {this.totalRows = totalRows;}

	public int getTotalPages() {return totalPages;}
	public void setTotalPages(int totalPages) {this.totalPages = totalPages;}

	public int getStartPage() {return startPage;}
	public void setStartPage(int startPage) {this.startPage = startPage;}

	public int getEndPage() {return endPage;}
	public void setEndPage(int endPage) {this.endPage = endPage;}

	public int getStartRnumForOracle() {return startRnumForOracle;}
	public void setStartRnumForOracle(int startRnumForOracle) {this.startRnumForOracle = startRnumForOracle;}

	public int getEndRnumForOracle() {return endRnumForOracle;}
	public void setEndRnumForOracle(int endRnumForOracle) {this.endRnumForOracle = endRnumForOracle;}

	public Integer getRNUM() {return RNUM;}
	public void setRNUM(Integer rNUM) {RNUM = rNUM;}

	public int getStartRnumForMysql() {return startRnumForMysql;}
	public void setStartRnumForMysql(int startRnumForMysql) {this.startRnumForMysql = startRnumForMysql;}
	
}