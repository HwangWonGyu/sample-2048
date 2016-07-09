package com.hugecomp.sample_2048;

import com.hugecomp.sample_2048.model.Table;
import com.hugecomp.sample_2048.service.TableService;
import com.hugecomp.sample_2048.service.impl.TableServiceImpl;

public class MainController {

	private static TableService tableService = new TableServiceImpl();
	
	public static void main(String[] args) {
		Table table = tableService.getInitializedTable();

		while(true) {
			if (tableService.isGameOver(table)) {
				printGameOver(table);
				return;
			}
			printTable(table);
			moveTable(table);
		}
	}

}
