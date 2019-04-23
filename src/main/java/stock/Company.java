package stock;

import javax.persistence.*;

@Entity
@Table(name = "company")

public class Company {
	@Id
   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "change")
    private Double change;
	 @Column (name = "username")
	    private String userName;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "latestTime")
    private String latestTime;
    @Column(name = "sector")
    private String sector;
    @Column(name = "primaryExchange")
    private String primaryExchange;
    @Column(name = "previousClose_change")
    private Double previousClose_change;
    @Column(name = "changePercent")
    private Double changePercent;
    @Column(name = "marketCap")
    private Double marketCap;
    @Column(name = "open")
    private Double open;
    @Column(name = "high")
    private Double high;
    @Column(name = "low")
    private Double low;
    @Column(name = "close")
    private Double close;
    @Column(name = "previousClose")
    private Double previousClose;
    @Column(name = "latestVolume")
    private int latestVolume;
    @Column(name = "week52High")
    private Double week52High;
    @Column(name = "week52Low")
    private Double week52Low;
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String firstName) {
        this.userName = firstName;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getCompanyName() {
        return companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }
    public String getPrimaryExchange() {
        return primaryExchange;
    }

    public void setPrimaryExchange(String primaryExchange) {
        this.primaryExchange = primaryExchange;
    }
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector= sector;
    }
    public Double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Double marketCap) {
        this.marketCap = marketCap;
    }
    public Double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(Double changePercent) {
        this.changePercent = changePercent;
    }
    public Double getPreviousClose_change() {
        return previousClose_change;
    }

    public void setPreviousClose_change(Double previousClose_change) {
        this.previousClose_change = previousClose_change;
    }
    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }
    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }
    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }
    public Double getClose() {
        return close;
    }
    public void setClose(Double close) {
        this.close = close;
    }
    public Double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(Double previousClose) {
        this.previousClose = previousClose;
    }
    public int getLatestVolume() {
        return latestVolume;
    }

    public void setLatestVolume(int latestVolume) {
        this.latestVolume = latestVolume;
    }
    public Double getWeek52High() {
        return week52High;
    }
    public void setWeek52High(Double week52High) {
        this.week52High = week52High;
    }
    public Double getWeek52Low() {
        return week52Low;
    }
    public void setWeek52Low(Double week52Low) {
        this.week52Low = week52Low;
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return this.companyName+ this.change+this.symbol;
    }
}