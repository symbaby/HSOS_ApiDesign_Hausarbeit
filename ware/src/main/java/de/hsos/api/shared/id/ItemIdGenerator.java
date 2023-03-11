package de.hsos.api.shared.id;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
@IdGenerationQualifier(type = IdGenerationType.ITEM)
public class ItemIdGenerator implements IdGeneration {
    private final AtomicInteger idCounter;

    public ItemIdGenerator() {
        this.idCounter = new AtomicInteger(0);
    }

    @Override
    public Integer generateId() {
        return this.idCounter.incrementAndGet();
    }

    public AtomicInteger getIdCounter() {
        return this.idCounter;
    }

}