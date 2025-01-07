package id.my.hendisantika.mongock.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import id.my.hendisantika.mongock.model.Expense;
import id.my.hendisantika.mongock.model.ExpenseCategory;
import id.my.hendisantika.mongock.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static id.my.hendisantika.mongock.model.ExpenseCategory.ENTERTAINMENT;
import static id.my.hendisantika.mongock.model.ExpenseCategory.MISC;
import static id.my.hendisantika.mongock.model.ExpenseCategory.RESTAURANT;
import static id.my.hendisantika.mongock.model.ExpenseCategory.UTILITIES;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mongock-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 07/01/25
 * Time: 09.27
 * To change this template use File | Settings | File Templates.
 */
@ChangeLog
public class DatabaseChangeLog {
    @ChangeSet(order = "001", id = "seedDatabase", author = "Yu71")
    public void seedDatabase(ExpenseRepository expenseRepository) {
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(createNewExpense("Movie Tickets", ENTERTAINMENT, BigDecimal.valueOf(40)));
        expenseList.add(createNewExpense("Dinner", RESTAURANT, BigDecimal.valueOf(60)));
        expenseList.add(createNewExpense("Netflix", ENTERTAINMENT, BigDecimal.valueOf(10)));
        expenseList.add(createNewExpense("Gym", MISC, BigDecimal.valueOf(20)));
        expenseList.add(createNewExpense("Internet", UTILITIES, BigDecimal.valueOf(30)));

        expenseRepository.insert(expenseList);
    }

    private Expense createNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal amount) {
        Expense expense = new Expense();
        expense.setExpenseName(expenseName);
        expense.setExpenseAmount(amount);
        expense.setExpenseCategory(expenseCategory);
        return expense;
    }
}
