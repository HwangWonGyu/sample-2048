package com.hugecomp.sample_2048.service.impl;

import com.hugecomp.sample_2048.model.Table;
import com.hugecomp.sample_2048.model.enums.Direction;
import com.hugecomp.sample_2048.service.BlockMerger;

public class BlockMergerImpl implements BlockMerger {

	class MergeTraversalDetail {
		int rowStartIndex;
		int rowEndIndex;
		int columnStartIndex;
		int columnEndIndex;
		int rowInterval;
		int columnInterval;

		MergeTraversalDetail(Direction direction) {
			switch (direction) {
				case UP :
					rowStartIndex = 0;
					rowEndIndex = Table.SIZE;
					columnStartIndex = 0;
					columnEndIndex = Table.SIZE;
					rowInterval = 1;
					columnInterval = 1;
					break;
				case DOWN :
					rowStartIndex = Table.SIZE - 1;
					rowEndIndex = -1;
					columnStartIndex = 0;
					columnEndIndex = Table.SIZE;
					rowInterval = -1;
					columnInterval = 1;
					break;
				case RIGHT :
					rowStartIndex = 0;
					rowEndIndex = Table.SIZE;
					columnStartIndex = Table.SIZE - 1;
					columnEndIndex = -1;
					rowInterval = 1;
					columnInterval = -1;
					break;
				case LEFT :
					rowStartIndex = 0;
					rowEndIndex = Table.SIZE;
					columnStartIndex = 0;
					columnEndIndex = Table.SIZE;
					rowInterval = 1;
					columnInterval = 1;
					break;
			}
		}
	}

}
