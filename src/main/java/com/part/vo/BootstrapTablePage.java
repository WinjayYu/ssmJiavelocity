package com.part.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Description: bootstrap table 分页实体
 */
public class BootstrapTablePage implements Serializable {

	private static final long serialVersionUID = -6012298133905991482L;
	private Long total;
    @SuppressWarnings("rawtypes")
    private List rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @SuppressWarnings("rawtypes")
    public List getRows() {
        return rows;
    }

    @SuppressWarnings("rawtypes")
    public void setRows(List rows) {
        this.rows = rows;
    }

}
