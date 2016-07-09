package com.hugecomp.sample_2048.service.impl;

import com.hugecomp.sample_2048.model.Table;
import com.hugecomp.sample_2048.model.enums.Direction;
import com.hugecomp.sample_2048.service.BlockMerger;
import com.hugecomp.sample_2048.service.BlockMover;
import com.hugecomp.sample_2048.service.TableService;

public class TableServiceImpl implements TableService {
	public static final int INITIAL_BLOCK_COUNT = 2;
	private static BlockMover blockMover = new BlockMoverImpl();
	private static BlockMerger blockMerger = new BlockMergerImpl();
	
	public Table getInitializedTable() {
		Table table = new Table();
		for (int i = 0; i < INITIAL_BLOCK_COUNT; i++) {
			table.createBlockToEmptySpace();
		}

		return table;
	}

	public void move(Table table, Direction direction) {
		blockMover.moveBlocks(table.getBlocks(), direction);
		int score = blockMerger.mergeBlocksIfAbleToMergeAndReturnScore(table.getBlocks(), direction);
		blockMover.moveBlocks(table.getBlocks(), direction);
		table.addScore(score);

		if (table.isContinuable()) {
			table.createBlockToEmptySpace();
		}
	}
}
