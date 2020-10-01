package com.example.quiz;

import com.example.quiz.app.classroom.Streams;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StreamsTests {

    @Autowired
    Streams warrior;

    @Test
    void AllDebtorNames() {
        var result = warrior.AllDebtorNames();
        assertEquals(result, List.of("John Kristopherson","Stephan Anderson ","Pavel Glovacky","Patricia Swan","Roselin Leimgruber","Johnana Kristopherson","Kunz Angelina","Novakovic Stanko","Hassan Ahmed","Zivanovic Ivanka","Barhoumi Nadia","Miladnovic Vesna","Sidibe Youssouf","Schwierz Thomas","Pavel Sidorov","Aleksandr Sevcenko", "Gleb Tremzin","Natasha Sasnovskaja"));
    }

    @Test
    void SpecificSortedDebtAmounts() {
        var result = warrior.SpecificSortedDebtAmounts("RUB");
        assertEquals(result, "Natasha Sasnovskaja");
    }

    @Test
    void SpecificSortedDebtAmountsWithOptionalException() {
        Exception exception = assertThrows(RuntimeException.class, () -> warrior.SpecificSortedDebtAmounts(""));
        assertEquals(exception.getMessage(), "Wrong currency");
    }

    @Test
    void GroupedDebtosrByAgeSpaggetti() {
        var result = warrior.GroupedDebtosrByAgeSpaggetti();
        assertEquals(result, List.of("Stephan Anderson ", "Zivanovic Ivanka"));
    }

    @Test
    void GroupedDebtosrByAge() {
        var result = warrior.GroupedDebtosrByAge();
        assertEquals(result, List.of("Stephan Anderson ", "Zivanovic Ivanka"));
    }
}
