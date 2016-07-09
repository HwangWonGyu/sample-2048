package com.hugecomp.sample_2048.service;

import com.hugecomp.sample_2048.model.Board;
import com.hugecomp.sample_2048.model.enums.Direction;

public interface BlockMerger {
	int mergeBlocksIfAbleToMergeAndReturnScore(Board[][] blocks, Direction direction);
	boolean isAbleToMerge(Board[][] blocks, int rowIndex, int columnIndex, Direction direction);
}
