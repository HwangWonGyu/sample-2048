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

	private static void printGameOver(Table table) {
		System.out.println("***** GAME OVER *****");
		System.out.println("score : " + table.getScore());
		System.out.println(table);
	}
	
	private static void printTable(Table table) {
		System.out.println();
		System.out.println(table);
	}
}
