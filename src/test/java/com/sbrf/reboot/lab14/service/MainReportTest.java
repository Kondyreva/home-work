package com.sbrf.reboot.lab14.service;

import com.sbrf.reboot.lab14.dto.Account;
import com.sbrf.reboot.lab14.dto.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MainReportTest {
    @InjectMocks
    private MainReportImpl operation;

    List<Customer> newCustomer;

    @BeforeEach
    void init() {
        List<Account> accountFirstList = new ArrayList<>();
        accountFirstList.add(new Account(100.0, "RUB", LocalDate.of(2021, 7, 1)));
        accountFirstList.add(new Account(200.0, "RUB", LocalDate.of(2021, 7, 5)));
        accountFirstList.add(new Account(300.0, "RUB", LocalDate.of(2021, 7, 6)));
        accountFirstList.add(new Account(400.0, "EUR", LocalDate.of(2021, 7, 7)));

        List<Account> accountSecondList = new ArrayList<>();
        accountSecondList.add(new Account(2000.0, "RUB", LocalDate.of(2021, 7, 10)));
        accountSecondList.add(new Account(5000.0, "RUB", LocalDate.of(2021, 8, 1)));
        accountSecondList.add(new Account(3500.0, "USD", LocalDate.of(2021, 7, 10)));

        List<Account> accountThirdList = new ArrayList<>();
        accountThirdList.add(new Account(155.55, "RUB", LocalDate.of(2021, 7, 15)));
        accountThirdList.add(new Account(355.5, "RUB", LocalDate.of(2021, 7, 15)));

        newCustomer = new ArrayList<>();
        newCustomer.add(new Customer(18, "First", accountFirstList));
        newCustomer.add(new Customer(20, "Second", accountSecondList));
        newCustomer.add(new Customer(31, "Third", accountThirdList));
    }

    @Test
    void getTotalsWithCompletableFuture() throws ExecutionException, InterruptedException {
        List<CompletableFuture<Double>> balanceByCustomer = newCustomer.stream()
                .map(customer -> operation.getTotalsWithCompletableFuture(Stream.of(customer)))
                .collect(Collectors.toList());
        CompletableFuture<Void> allBalances = CompletableFuture.allOf(
                balanceByCustomer.toArray(new CompletableFuture[0]));

        CompletableFuture<List<Double>> allCustomersBalancesList = allBalances.thenApply(v -> {
            return balanceByCustomer.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList());});

        CompletableFuture<Double> countBalance = allCustomersBalancesList.thenApply(balance -> {
            return balance.stream()
                    .mapToDouble(Double::doubleValue)
                    .sum();
        });
        Double expected = 2500.0;
        Double result = countBalance.get();

        assertEquals(expected,result);
    }

    @Test
    void getTotalsWithReact() {
        Mono<Double> balanceByReact = operation.getTotalsWithReact(newCustomer.stream());
        balanceByReact.subscribeOn(Schedulers.parallel());
        Double result = balanceByReact.block();

        assertEquals(2500.0,result);
    }

}