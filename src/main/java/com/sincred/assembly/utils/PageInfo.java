package com.sincred.assembly.utils;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PageInfo {
    private int totalPages;
    private int pageSize;
    private long totalRecords;
    private int pageNumber;

    @Builder
    public PageInfo(Page page) {
        this.totalPages = pageOrPageableIsNull(page) ? 0 : page.getTotalPages();
        this.pageSize = pageOrPageableIsNull(page) ? 0 : page.getPageable().getPageSize();
        this.totalRecords = (pageOrPageableIsNull(page)) ? 0 : page.getTotalElements();
        this.pageNumber = (pageOrPageableIsNull(page)) ? 0 : page.getPageable().getPageNumber();

    }

    private static boolean pageOrPageableIsNull(Page page) {
        if (page == null) return Boolean.TRUE;
        return page.getPageable().isUnpaged();
    }
}
