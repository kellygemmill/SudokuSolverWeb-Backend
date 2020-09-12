package com.kellygemmill.sudokusolverweb.api;

import com.kellygemmill.sudokusolverweb.model.SudokuSummary;
import com.kellygemmill.sudokusolverweb.service.SudokuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("sudoku/solve")
@RestController
public class SudokuController {

    private final SudokuService sudokuService;

    @Autowired
    public SudokuController(SudokuService sudokuService) {
        this.sudokuService = sudokuService;
    }

    @GetMapping(path = "{boardInput}")
    public SudokuSummary solveBoard(@PathVariable("boardInput") String boardInput) {
        return new SudokuSummary(boardInput,sudokuService.solve(boardInput));
    }

}