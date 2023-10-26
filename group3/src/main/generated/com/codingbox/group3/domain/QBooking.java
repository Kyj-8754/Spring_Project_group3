package com.codingbox.group3.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBooking is a Querydsl query type for Booking
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBooking extends EntityPathBase<Booking> {

    private static final long serialVersionUID = -1167052753L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBooking booking = new QBooking("booking");

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    public final StringPath day = createString("day");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final QStore store;

    public final EnumPath<com.codingbox.group3.em.Time> time = createEnum("time", com.codingbox.group3.em.Time.class);

    public QBooking(String variable) {
        this(Booking.class, forVariable(variable), INITS);
    }

    public QBooking(Path<? extends Booking> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBooking(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBooking(PathMetadata metadata, PathInits inits) {
        this(Booking.class, metadata, inits);
    }

    public QBooking(Class<? extends Booking> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store")) : null;
    }

}

