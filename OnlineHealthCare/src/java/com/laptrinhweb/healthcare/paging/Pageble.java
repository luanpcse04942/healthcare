package com.laptrinhweb.healthcare.paging;

import com.laptrinhweb.healthcare.sort.Sorter;

public interface Pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
