package com.hugecomp.sample_2048.service.impl;

import com.hugecomp.sample_2048.model.Table;
import com.hugecomp.sample_2048.model.enums.Direction;
import com.hugecomp.sample_2048.service.TableService;

public class TableServiceImpl implements TableService {
	public static final int INITIAL_BLOCK_COUNT = 2;
	
	public Table getInitializedTable() {
		Table table = new Table();
		for (int i = 0; i < INITIAL_BLOCK_COUNT; i++) {
			table.createBlockToEmptySpace();
		}

		return table;
	}

}
