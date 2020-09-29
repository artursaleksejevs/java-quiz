package com.example.quiz;

import com.example.quiz.app.ShadyService;
import com.example.quiz.app.StreamWarrior;
import com.example.quiz.app.Warrior;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StreamsTests {

    @Autowired
    StreamWarrior warrior;

    @Test
    void AllDebtorNames() {
        var result = warrior.AllDebtorNames();
        assertEquals(result, List.of("John Kristopherson","Stephan Anderson ","Pavel Glovacky","Patricia Swan","Roselin Leimgruber","Johnana Kristopherson","Kunz Angelina","Novakovic Stanko","Hassan Ahmed","Zivanovic Ivanka","Barhoumi Nadia","Miladnovic Vesna","Sidibe Youssouf","Schwierz Thomas","Pavel Sidorov","Aleksandr Sevcenko", "Gleb Tremzin","Natasha Sasnovskaja"));
    }

    @Test
    void SpecificSortedDebtAmounts() {
        var result = warrior.SpecificSortedDebtAmounts();
        assertEquals(result, "Natasha Sasnovskaja");
    }
    @Test
    void GroupedDebtosrByAge() {
        var result = warrior.GroupedDebtosrByAge();
        assertEquals(result, List.of("Stephan Anderson", "Zivanovic Ivanka"));
    }
}
