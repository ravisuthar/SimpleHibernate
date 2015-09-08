package com.company.stock.xml;

import java.util.Date;

public class StockDetail {
	private Integer stockId;
	private Stock stock;
	private String compName;
	private String compDesc;
	private String remark;
	private Date listedDate;

	public StockDetail() {
		super();
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompDesc() {
		return compDesc;
	}

	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getListedDate() {
		return listedDate;
	}

	public void setListedDate(Date listedDate) {
		this.listedDate = listedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compDesc == null) ? 0 : compDesc.hashCode());
		result = prime * result + ((compName == null) ? 0 : compName.hashCode());
		result = prime * result + ((listedDate == null) ? 0 : listedDate.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
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
		StockDetail other = (StockDetail) obj;
		if (compDesc == null) {
			if (other.compDesc != null) {
				return false;
			}
		} else if (!compDesc.equals(other.compDesc)) {
			return false;
		}
		if (compName == null) {
			if (other.compName != null) {
				return false;
			}
		} else if (!compName.equals(other.compName)) {
			return false;
		}
		if (listedDate == null) {
			if (other.listedDate != null) {
				return false;
			}
		} else if (!listedDate.equals(other.listedDate)) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		if (stock == null) {
			if (other.stock != null) {
				return false;
			}
		} else if (!stock.equals(other.stock)) {
			return false;
		}
		if (stockId == null) {
			if (other.stockId != null) {
				return false;
			}
		} else if (!stockId.equals(other.stockId)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "StockDetail [stockId=" + stockId + ", stock=" + stock + ", compName=" + compName + ", compDesc=" + compDesc + ", remark=" + remark + ", listedDate=" + listedDate + "]";
	}

}
