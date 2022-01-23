package com.sbrf.reboot.lab14.service;

import com.sbrf.reboot.lab14.dto.Customer;
import com.sbrf.reboot.lab14.dto.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class MainReportImpl implements MainReport {
    public static final String RUB_CURRENCY = "RUB";

    @Override
    public CompletableFuture<Double> getTotalsWithCompletableFuture(Stream<Customer> stream) {
        return CompletableFuture.supplyAsync(() -> {
            return
                    stream
                            .filter(customer -> customer.getAge() >= 18 && customer.getAge() <= 30)
                            .flatMap(customer -> customer.getAccounts().stream())
                            .filter(account -> account.getCreateDate().isBefore(LocalDate.of(2021, 8, 1)) &&
                                    account.getCreateDate().isAfter(LocalDate.of(2021, 7, 1)) &&
                                    RUB_CURRENCY.equals(account.getCurrency()))
                            .mapToDouble(Account::getBalance).sum();
        });
    }

    @Override
    public Mono<Double> getTotalsWithReact(Stream<Customer> stream) {
        return Flux.fromStream(stream)                            .
                filter(customer -> customer.getAge() >= 18 && customer.getAge() <= 30)
                .flatMap(customer -> Flux.fromStream(customer.getAccounts().stream()))
                .filter(account -> account.getCreateDate().isBefore(LocalDate.of(2021, 8, 1)) &&
                        account.getCreateDate().isAfter(LocalDate.of(2021, 7, 1)) &&
                        RUB_CURRENCY.equals(account.getCurrency()))
                .map(Account::getBalance)
                .reduce(Double::sum)
                .single();
    }
}
