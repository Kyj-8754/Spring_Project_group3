package com.codingbox.group3.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = -1428939209L;

    public static final QStore store = new QStore("store");

    public final StringPath addr = createString("addr");

    public final ListPath<Booking, QBooking> booking = this.<Booking, QBooking>createList("booking", Booking.class, QBooking.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath info = createString("info");

    public final StringPath keyword = createString("keyword");

    public final ListPath<Menu, QMenu> menu = this.<Menu, QMenu>createList("menu", Menu.class, QMenu.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final EnumPath<com.codingbox.group3.em.Parking> parking = createEnum("parking", com.codingbox.group3.em.Parking.class);

    public final StringPath phone = createString("phone");

    public final ListPath<Review, QReview> review = this.<Review, QReview>createList("review", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<com.codingbox.group3.em.Time> time = createEnum("time", com.codingbox.group3.em.Time.class);

    public QStore(String variable) {
        super(Store.class, forVariable(variable));
    }

    public QStore(Path<? extends Store> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStore(PathMetadata metadata) {
        super(Store.class, metadata);
    }

}

