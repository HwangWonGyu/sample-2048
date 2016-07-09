package com.hugecomp.sample_2048.service;

import com.hugecomp.sample_2048.model.Table;
import com.hugecomp.sample_2048.model.enums.Direction;

public interface TableService {
	Table getInitializedTable();
	boolean isGameOver(Table table);
	void move(Table table, Direction direction);
}
