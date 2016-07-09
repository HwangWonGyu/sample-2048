package com.hugecomp.sample_2048.service;

import com.hugecomp.sample_2048.model.Board;
import com.hugecomp.sample_2048.model.enums.Direction;

public interface BlockMover {
	void moveBlocks(Board[][] blocks, Direction direction);
}

