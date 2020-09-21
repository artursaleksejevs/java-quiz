package com.example.quiz;

import com.example.quiz.app.ShadyService;
import com.example.quiz.app.Warrior;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class QuizApplicationTests {

    @MockBean
    ShadyService shadyService;

    @Autowired
    Warrior warrior;

    @Test
    void passWhatever1() {
        when(shadyService.getData()).thenReturn("Something");
        var result = warrior.passWhatever();
        assertEquals(result, "Something");
    }

    @Test
    void passWhatever2() {
        when(shadyService.getData()).thenReturn("");
        var result = warrior.passWhatever();
        assertEquals(result, "");
    }

    @Test
    void passWhatever3() {
        when(shadyService.getData()).thenReturn(null);
        var result = warrior.passWhatever();
        assertEquals(result, null);
    }

    @Test
    void passUpper1() {
        when(shadyService.getData()).thenReturn("Whatever");
        var result = warrior.passUpper();
        assertEquals(result, "WHATEVER");
    }

    @Test
    void passUpper2() {
        when(shadyService.getData()).thenReturn("");
        Exception exception = assertThrows(RuntimeException.class, () -> warrior.passUpper());
        assertEquals(exception.getMessage(), "Empty");
    }

    @Test
    void passUpper3() {
        when(shadyService.getData()).thenReturn(null);
        Exception exception = assertThrows(RuntimeException.class, () -> warrior.passUpper());
        assertEquals(exception.getMessage(), "Empty");
    }

    @Test
    void passDefault1() {
        when(shadyService.getData()).thenReturn("Whatever");
        var result = warrior.passDefault();
        assertEquals(result, "Whatever");
    }

    @Test
    void passDefault2() {
        when(shadyService.getData()).thenReturn("");
        var result = warrior.passDefault();
        assertEquals(result, "Default");
    }

    @Test
    void passDefault3() {
        when(shadyService.getData()).thenReturn(null);
        var result = warrior.passDefault();
        assertEquals(result, "Default");
    }

    @Test
    void exists1() {
        when(shadyService.getData()).thenReturn("Whatever");
        var result = warrior.exists();
        assertEquals(result, true);
    }

    @Test
    void exists2() {
        when(shadyService.getData()).thenReturn("");
        var result = warrior.exists();
        assertEquals(result, true);
    }

    @Test
    void exists3() {
        when(shadyService.getData()).thenReturn(null);
        var result = warrior.exists();
        assertEquals(result, false);
    }

    @Test
    void notEmpty1() {
        when(shadyService.getData()).thenReturn("Whatever");
        var result = warrior.notEmpty();
        assertEquals(result, true);
    }

    @Test
    void notEmpty2() {
        when(shadyService.getData()).thenReturn("");
        var result = warrior.notEmpty();
        assertEquals(result, false);
    }

    @Test
    void notEmpty3() {
        when(shadyService.getData()).thenReturn(null);
        var result = warrior.notEmpty();
        assertEquals(result, false);
    }

    @Test
    void filterList1() {
        when(shadyService.getList()).thenReturn(Arrays.asList("1","2","3"));
        var result = warrior.filterList("1");
        assertEquals(result, true);
    }

    @Test
    void filterList2() {
        when(shadyService.getList()).thenReturn(Arrays.asList("1","2","3"));
        var result = warrior.filterList("4");
        assertEquals(result, false);
    }

    @Test
    void filterList3() {
        when(shadyService.getList()).thenReturn(null);
        Exception exception = assertThrows(RuntimeException.class, () -> warrior.filterList("1"));
        assertEquals(exception.getMessage(), "Empty");
    }

    @Test
    void filterList4() {
        when(shadyService.getList()).thenReturn(Arrays.asList());
        Exception exception = assertThrows(RuntimeException.class, () -> warrior.filterList("1"));
        assertEquals(exception.getMessage(), "Empty");
    }

    @Test
    void filterList5() {
        when(shadyService.getList()).thenReturn(Arrays.asList("1","2","3"));
        var result = warrior.filterList(null);
        assertEquals(result, false);
    }
}
