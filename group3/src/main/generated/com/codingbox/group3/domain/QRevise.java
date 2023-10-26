package com.codingbox.group3.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRevise is a Querydsl query type for Revise
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRevise extends EntityPathBase<Revise> {

    private static final long serialVersionUID = -1389724062L;

    public static final QRevise revise = new QRevise("revise");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath userId = createString("userId");

    public final StringPath userPw = createString("userPw");

    public QRevise(String variable) {
        super(Revise.class, forVariable(variable));
    }

    public QRevise(Path<? extends Revise> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRevise(PathMetadata metadata) {
        super(Revise.class, metadata);
    }

}

