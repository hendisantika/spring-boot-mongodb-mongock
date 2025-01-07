package id.my.hendisantika.mongock;

import id.my.hendisantika.mongock.model.Expense;
import id.my.hendisantika.mongock.model.ExpenseCategory;
import id.my.hendisantika.mongock.repository.ExpenseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Testcontainers
class SpringBootMongockDemoApplicationTests {

    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:8.0.4");

    {
        mongoDBContainer.start();
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Autowired
    private ExpenseRepository expenseRepository;

    @Test
    @DisplayName("Test Whether Expenses are pre-populated")
    void shouldReturnPrePopulatedExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        assertEquals(5, expenses.size());
    }

    @Test
    @DisplayName("Should Find Expense By Name")
    void shouldFindExpenseByName() {
        Expense expectedExpense = new Expense();
        expectedExpense.setExpenseName("Evening Drinks");
        expectedExpense.setExpenseCategory(ExpenseCategory.MISC);
        expectedExpense.setExpenseAmount(BigDecimal.TEN);
        expenseRepository.save(expectedExpense);

        Expense actualExpense = expenseRepository.findByName("Evening Drinks").orElseThrow();
        assertEquals(expectedExpense.getExpenseName(), actualExpense.getExpenseName());
        assertEquals(expectedExpense.getExpenseCategory(), actualExpense.getExpenseCategory());
        assertEquals(expectedExpense.getExpenseAmount(), actualExpense.getExpenseAmount());
    }
}
