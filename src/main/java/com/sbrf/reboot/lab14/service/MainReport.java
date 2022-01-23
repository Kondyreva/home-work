package com.sbrf.reboot.lab14.service;
import com.sbrf.reboot.lab14.dto.Customer;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public interface MainReport {
    CompletableFuture<Double> getTotalsWithCompletableFuture(Stream<Customer> stream) throws ExecutionException, InterruptedException;

    Mono<Double> getTotalsWithReact(Stream<Customer> stream);
}
