package com.uleos.cyprus.panache.repository;

import com.uleos.cyprus.panache.model.Publisher;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class PublisherRepositoryTest {

    @Test
    @TestTransaction
    public void shouldCreateAndFindAPublisher() {
        Publisher publisher = new Publisher("pubone");
        Publisher.persist(publisher);

        assertNotNull(publisher.id);

        publisher = Publisher.findById(publisher.id);
        assertEquals("pubone", publisher.name);
    }
}
