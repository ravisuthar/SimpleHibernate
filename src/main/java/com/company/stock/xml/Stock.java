package com.company.stock.xml;

public class Stock {

	private Integer stockId;
	private String stockCode;
	private String stockName;
	private StockDetail stockDetail;

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public StockDetail getStockDetail() {
		return stockDetail;
	}

	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stockCode == null) ? 0 : stockCode.hashCode());
		result = prime * result + ((stockDetail == null) ? 0 : stockDetail.hashCode());
		result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
		result = prime * result + ((stockName == null) ? 0 : stockName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Stock other = (Stock) obj;
		if (stockCode == null) {
			if (other.stockCode != null) {
				return false;
			}
		} else if (!stockCode.equals(other.stockCode)) {
			return false;
		}
		if (stockDetail == null) {
			if (other.stockDetail != null) {
				return false;
			}
		} else if (!stockDetail.equals(other.stockDetail)) {
			return false;
		}
		if (stockId == null) {
			if (other.stockId != null) {
				return false;
			}
		} else if (!stockId.equals(other.stockId)) {
			return false;
		}
		if (stockName == null) {
			if (other.stockName != null) {
				return false;
			}
		} else if (!stockName.equals(other.stockName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockCode=" + stockCode + ", stockName=" + stockName + ", stockDetail=" + stockDetail + "]";
	}

}
