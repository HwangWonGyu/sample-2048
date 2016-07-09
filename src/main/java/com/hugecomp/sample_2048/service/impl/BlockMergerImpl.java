package com.hugecomp.sample_2048.service.impl;

import com.hugecomp.sample_2048.model.Board;
import com.hugecomp.sample_2048.model.Point;
import com.hugecomp.sample_2048.model.Table;
import com.hugecomp.sample_2048.model.enums.Direction;
import com.hugecomp.sample_2048.service.BlockMerger;

public class BlockMergerImpl implements BlockMerger {

	@Override
	public int mergeBlocksIfAbleToMergeAndReturnScore(Board[][] blocks, Direction direction) {

		int sumOfScore = 0;

		MergeTraversalDetail mergeTraversalDetail = new MergeTraversalDetail(direction);

		for (int rowIndex = mergeTraversalDetail.rowStartIndex; rowIndex != mergeTraversalDetail.rowEndIndex; rowIndex += mergeTraversalDetail.rowInterval) {
			for (int columnIndex = mergeTraversalDetail.columnStartIndex; columnIndex != mergeTraversalDetail.columnEndIndex; columnIndex += mergeTraversalDetail.columnInterval) {

				Point mergeTargetPoint = getValidMergeTargetPoint(blocks, rowIndex, columnIndex, direction);

				if (mergeTargetPoint == null) {
					continue;
				}

				sumOfScore += mergeSourceIntoTargetAndReturnScore(blocks, new Point(columnIndex, rowIndex), mergeTargetPoint);
			}
		}

		return sumOfScore;
	}
	
	private Point getValidMergeTargetPoint(Board[][] blocks, int rowIndex, int columnIndex, Direction direction) {

		if (blocks[rowIndex][columnIndex] == null) {
			return null;
		}

		if (isDirectionFacedOutOfEdge(rowIndex, columnIndex, direction)) {
			return null;
		}

		Point mergeTargetPoint = getMergeTargetPoint(columnIndex, rowIndex, direction);

		if (blocks[mergeTargetPoint.getY()][mergeTargetPoint.getX()] == null) {
			return null;
		}

		if (blocks[rowIndex][columnIndex].getValue() != blocks[mergeTargetPoint.getY()][mergeTargetPoint.getX()].getValue()) {
			return null;
		}

		return mergeTargetPoint;
	}
	
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
